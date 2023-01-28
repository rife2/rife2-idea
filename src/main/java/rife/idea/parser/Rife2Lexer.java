/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lang.Language;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import rife.idea.Rife2LanguageHtml;
import rife.template.TemplateConfig;
import rife.template.antlr.TemplateLexer;

public abstract class Rife2Lexer extends MergingLexerAdapterBase {
    private static final MergeFunction MERGE_FUNCTION = new MergeFunction() {
        @Override
        public IElementType merge(IElementType type, Lexer originalLexer) {
            return type;
        }
    };

    protected Rife2Lexer(Lexer original) {
        super(original);
    }

    public static Lexer createXmlLexer(Language language) {
        var lexer = new TemplateLexer(null);
        lexer.tc = TemplateConfig.XML;
        return new ANTLRLexerAdaptor(language, lexer);
    }

    @Override
    public MergeFunction getMergeFunction() {
        return MERGE_FUNCTION;
    }
}
