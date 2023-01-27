/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import rife.idea.Rife2Language;
import rife.template.TemplateConfig;
import rife.template.antlr.TemplateLexer;

public class Rife2Lexer extends MergingLexerAdapterBase {
    private static final MergeFunction MERGE_FUNCTION = new MergeFunction() {
        @Override
        public IElementType merge(IElementType type, Lexer originalLexer) {
//            if (type != T_COMMENT_OPEN) {
//                return type;
//            }
//
//            if (originalLexer.getTokenType() == T_COMMENT_TEXT) {
//                originalLexer.advance();
//            }
//
//            if (originalLexer.getTokenType() == T_COMMENT_CLOSE) {
//                originalLexer.advance();
//                return COMMENT_BLOCK;
//            }
//
//            if (originalLexer.getTokenType() == null) {
//                return T_UNCLOSED_COMMENT;
//            }
//
//            if (originalLexer.getTokenType() == T_UNCLOSED_COMMENT) {
//                originalLexer.advance();
//                return T_UNCLOSED_COMMENT;
//            }

            return type;
        }
    };

    public Rife2Lexer() {
        super(createXmlLexer());
    }

    public static Lexer createXmlLexer() {
        var lexer = new TemplateLexer(null);
        lexer.tc = TemplateConfig.XML;
        return new ANTLRLexerAdaptor(Rife2Language.INSTANCE, lexer);
    }

    @Override
    public MergeFunction getMergeFunction() {
        return MERGE_FUNCTION;
    }
}
