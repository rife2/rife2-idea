/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2Language;
import rife.idea.file.Rife2FileType;

public class Rife2File extends PsiFileBase {
    public Rife2File(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Rife2Language.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return Rife2FileType.INSTANCE;
    }

    @Override
    public @NotNull String toString() {
        return "RIFE2 File:" + getName();
    }
}
