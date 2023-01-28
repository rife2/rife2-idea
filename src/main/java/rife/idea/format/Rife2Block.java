/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Rife2Block extends TemplateLanguageBlock {
    final private IElementType textElementType_;

    public Rife2Block(@NotNull IElementType textElementType,
                      @NotNull ASTNode node,
                      @Nullable Wrap wrap,
                      @Nullable Alignment alignment,
                      @NotNull TemplateLanguageBlockFactory blockFactory,
                      @NotNull CodeStyleSettings settings,
                      @Nullable List<DataLanguageBlockWrapper> foreignChildren) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren);
        textElementType_ = textElementType;
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        return textElementType_;
    }
}