/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.ide.highlighter.XmlLikeFileType;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageHtml;

import java.nio.charset.Charset;

public abstract class Rife2FileType extends XmlLikeFileType implements TemplateLanguageFileType {
    protected Rife2FileType(Language language) {
        super(language);
    }

    @Override
    public Charset extractCharsetFromFileContent(@Nullable final Project project, @Nullable final VirtualFile file, @NotNull final CharSequence content) {
        var associatedFileType = getAssociatedFileType(file, project);

        if (associatedFileType == null) {
            return null;
        }

        return CharsetUtil.extractCharsetFromFileContent(project, file, associatedFileType, content);
    }

    private static LanguageFileType getAssociatedFileType(VirtualFile file, Project project) {
        if (project == null) {
            return null;
        }

        var language = TemplateDataLanguageMappings.getInstance(project).getMapping(file);

        LanguageFileType associatedFileType = null;
        if (language != null) {
            associatedFileType = language.getAssociatedFileType();
        }

        if (language == null || associatedFileType == null) {
            associatedFileType = Rife2LanguageHtml.getDefaultTemplateLang();
        }

        return associatedFileType;
    }
}
