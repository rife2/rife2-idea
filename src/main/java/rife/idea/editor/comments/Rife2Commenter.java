/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.editor.comments;

import com.intellij.codeInsight.generation.CommenterWithLineSuffix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Rife2Commenter implements CommenterWithLineSuffix {
    @Override
    @Nullable
    public String getLineCommentPrefix() {
        return "<!--c-->";
    }

    @Override
    @NotNull
    public String getLineCommentSuffix() {
        return "<!--/c-->";
    }

    @Override
    @Nullable
    public String getBlockCommentPrefix() {
        return "<!--c-->";
    }

    @Override
    @Nullable
    public String getBlockCommentSuffix() {
        return "<!--/c-->";
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}
