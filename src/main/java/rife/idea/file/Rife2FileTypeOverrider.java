/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.impl.FileTypeOverrider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Rife2FileTypeOverrider implements FileTypeOverrider {
    private final static FileType[] FILE_TYPES = {
        Rife2FileTypeHtml.INSTANCE,
        Rife2FileTypeJson.INSTANCE,
        Rife2FileTypeSvg.INSTANCE,
        Rife2FileTypeTxt.INSTANCE,
        Rife2FileTypeXml.INSTANCE
    };

    @Override
    public @Nullable FileType getOverriddenFileType(@NotNull VirtualFile virtualFile) {
        if (!virtualFile.exists() ||
            !virtualFile.isInLocalFileSystem() ||
            !virtualFile.getPath().contains("/templates/")) {
            return null;
        }

        for (var tile_type : FILE_TYPES) {
            if (tile_type.getDefaultExtension().equals(virtualFile.getExtension())) {
                return tile_type;
            }
        }

        return null;
    }
}
