/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageJson;
import rife.idea.file.Rife2FileTypeJson;

public class Rife2FileJson extends PsiFileBase {
    public Rife2FileJson(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Rife2LanguageJson.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return Rife2FileTypeJson.INSTANCE;
    }

    @Override
    public @NotNull String toString() {
        return "RIFE2 JSON File:" + getName();
    }
}
