/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageSvg;
import rife.idea.file.Rife2FileTypeSvg;

public class Rife2FileSvg extends PsiFileBase {
    public Rife2FileSvg(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Rife2LanguageSvg.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return Rife2FileTypeSvg.INSTANCE;
    }

    @Override
    public @NotNull String toString() {
        return "RIFE2 SVG File:" + getName();
    }
}
