/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageTxt;

public class Rife2FileViewProviderFactoryTxt implements FileViewProviderFactory {
    @NotNull
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile file,
                                                   Language language,
                                                   @NotNull PsiManager manager,
                                                   boolean eventSystemEnabled) {
        assert language.isKindOf(Rife2LanguageTxt.INSTANCE);
        return new Rife2FileViewProviderTxt(manager, file, eventSystemEnabled, language);
    }
}
