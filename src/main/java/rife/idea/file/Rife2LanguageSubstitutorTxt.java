/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutor;
import com.intellij.testFramework.LightVirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rife.idea.Rife2LanguageTxt;

public class Rife2LanguageSubstitutorTxt extends LanguageSubstitutor {
    @Nullable
    @Override
    public Language getLanguage(@NotNull VirtualFile file, @NotNull Project project) {
        if (file instanceof LightVirtualFile) {
            return null;
        }

        return FileTypeRegistry.getInstance().isFileOfType(file, PlainTextFileType.INSTANCE) ? Rife2LanguageTxt.INSTANCE : null;
    }
}