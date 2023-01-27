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
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rife.idea.parser.Rife2ParserDefinition;

import java.util.List;

public class Rife2Block extends TemplateLanguageBlock {
    public Rife2Block(@NotNull ASTNode node,
                      @Nullable Wrap wrap,
                      @Nullable Alignment alignment,
                      @NotNull TemplateLanguageBlockFactory blockFactory,
                      @NotNull CodeStyleSettings settings,
                      @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                      HtmlPolicy policy) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren);
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        return Rife2ParserDefinition.TEXT;
    }
}
