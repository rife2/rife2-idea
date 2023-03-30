/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageHtml;
import rife.idea.highlighter.Rife2TemplateHighlighterHtml;

import javax.swing.*;

public class Rife2FileTypeHtml extends Rife2FileType {
    public static final LanguageFileType INSTANCE = new Rife2FileTypeHtml();

    private Rife2FileTypeHtml() {
        super(Rife2LanguageHtml.INSTANCE);

        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, ((project, fileType, virtualFile, colors) -> new Rife2TemplateHighlighterHtml(project, virtualFile, colors)));
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "html";

    @NotNull
    @Override
    public String getName() {
        return "RIFE2HTML";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RIFE2 HTML template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Rife2Icons.FILE_HTML;
    }

    protected LanguageFileType getAssociatedFileType() {
        return Rife2LanguageHtml.getDefaultTemplateLang();
    }
}
