/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageSvg;
import rife.idea.highlighter.Rife2TemplateHighlighterSvg;

import javax.swing.*;

public class Rife2FileTypeSvg extends Rife2FileType {
    public static final LanguageFileType INSTANCE = new Rife2FileTypeSvg();

    private Rife2FileTypeSvg() {
        super(Rife2LanguageSvg.INSTANCE);

        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, ((project, fileType, virtualFile, colors) -> new Rife2TemplateHighlighterSvg(project, virtualFile, colors)));
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "svg";

    @NotNull
    @Override
    public String getName() {
        return "RIFE2SVG";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RIFE2 SVG template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Rife2Icons.FILE_SVG;
    }

    protected LanguageFileType getAssociatedFileType() {
        return Rife2LanguageSvg.getDefaultTemplateLang();
    }
}
