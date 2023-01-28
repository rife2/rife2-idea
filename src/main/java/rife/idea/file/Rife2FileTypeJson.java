/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageJson;
import rife.idea.highlighter.Rife2TemplateHighlighterHtml;
import rife.idea.highlighter.Rife2TemplateHighlighterJson;

import javax.swing.*;

public class Rife2FileTypeJson extends Rife2FileType {
    public static final LanguageFileType INSTANCE = new Rife2FileTypeJson();

    private Rife2FileTypeJson() {
        super(Rife2LanguageJson.INSTANCE);

        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, ((project, fileType, virtualFile, colors) -> new Rife2TemplateHighlighterJson(project, virtualFile, colors)));
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "json";

    @NotNull
    @Override
    public String getName() {
        return "RIFE2JSON";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RIFE2 JSON template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Rife2Icons.FILE_JSON;
    }
}
