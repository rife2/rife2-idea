/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class Rife2FormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {
    @Override
    public TemplateLanguageBlock createTemplateLanguageBlock(@NotNull ASTNode node,
                                                             @Nullable Wrap wrap,
                                                             @Nullable Alignment alignment,
                                                             @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                             @NotNull CodeStyleSettings codeStyleSettings) {
        return new Rife2Block(getTemplateTextElementType(), node, wrap, alignment, this, codeStyleSettings, foreignChildren);
    }

    protected abstract IElementType getTemplateTextElementType();

    /**
     * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel}
     * since after we delegate to some templated languages, those languages (xml/html for sure, potentially others)
     * delegate right back to us to format the HbTokenTypes.OUTER_ELEMENT_TYPE token we tell them to ignore,
     * causing a stack-overflowing loop of polite format-delegation.
     */
    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        return new SimpleTemplateLanguageFormattingModelBuilder().createModel(formattingContext);
    }

    /**
     * Do format my model!
     *
     * @return false all the time to tell the {@link TemplateLanguageFormattingModelBuilder}
     * to not-not format our model (i.e. yes please!  Format away!)
     */
    @Override
    public boolean dontFormatMyModel() {
        return false;
    }
}
