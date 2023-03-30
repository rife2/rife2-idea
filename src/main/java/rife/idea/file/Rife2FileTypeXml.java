/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageJson;
import rife.idea.Rife2LanguageXml;
import rife.idea.highlighter.Rife2TemplateHighlighterXml;

import javax.swing.*;

public class Rife2FileTypeXml extends Rife2FileType {
    public static final LanguageFileType INSTANCE = new Rife2FileTypeXml();

    private Rife2FileTypeXml() {
        super(Rife2LanguageXml.INSTANCE);

        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, ((project, fileType, virtualFile, colors) -> new Rife2TemplateHighlighterXml(project, virtualFile, colors)));
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "xml";

    @NotNull
    @Override
    public String getName() {
        return "RIFE2XML";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RIFE2 XML template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Rife2Icons.FILE_XML;
    }

    protected LanguageFileType getAssociatedFileType() {
        return Rife2LanguageXml.getDefaultTemplateLang();
    }
}
