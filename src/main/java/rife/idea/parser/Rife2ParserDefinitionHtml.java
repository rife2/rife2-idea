/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.antlr.intellij.adaptor.lexer.*;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageHtml;
import rife.idea.psi.Rife2FileHtml;
import rife.template.antlr.TemplateLexer;
import rife.template.antlr.TemplateParser;

public class Rife2ParserDefinitionHtml extends Rife2ParserDefinition {
    public static final IFileElementType FILE =
        new IFileElementType(Rife2LanguageHtml.INSTANCE);

    public static TokenIElementType TEXT;
    public static TokenIElementType CTagName_V;
    public static TokenIElementType CS_V;
    public static TokenIElementType TTagName_V;
    public static TokenIElementType TS_V;

    static {
        PSIElementTypeFactory.defineLanguageIElementTypes(Rife2LanguageHtml.INSTANCE,
            TemplateParser.tokenNames,
            TemplateParser.ruleNames);
        var tokenIElementTypes =
            PSIElementTypeFactory.getTokenIElementTypes(Rife2LanguageHtml.INSTANCE);

        TEXT = tokenIElementTypes.get(TemplateLexer.TEXT);
        CTagName_V = tokenIElementTypes.get(TemplateLexer.CTagName_V);
        CS_V = tokenIElementTypes.get(TemplateLexer.CS_V);
        TTagName_V = tokenIElementTypes.get(TemplateLexer.TTagName_V);
        TS_V = tokenIElementTypes.get(TemplateLexer.TS_V);
    }

    public static final TokenSet COMMENTED =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TTEXT_C,
            TemplateLexer.CTEXT_C);

    public static final TokenSet STRINGS =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TTagName_I,
            TemplateLexer.TComment_C,
            TemplateLexer.CTagName_I,
            TemplateLexer.CComment_C,
            TemplateLexer.TTagName_V,
            TemplateLexer.CTagName_V,
            TemplateLexer.TTagName_B,
            TemplateLexer.CTagName_B);

    public static final TokenSet NAMES_INCLUDE =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TTagName_I,
            TemplateLexer.CTagName_I);

    public static final TokenSet NAMES_COMMENT =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TComment_C,
            TemplateLexer.CComment_C);

    public static final TokenSet NAMES_BLOCK =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TTagName_B,
            TemplateLexer.CTagName_B);

    public static final TokenSet NAMES_VALUE =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.TTagName_V,
            TemplateLexer.CTagName_V);

    public static final TokenSet TAGS_INCLUDE =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.CSTART_I,
            TemplateLexer.CSTERM_I,
            TemplateLexer.TSTART_I,
            TemplateLexer.TSTERM_I,
            TemplateLexer.CS_I,
            TemplateLexer.TS_I);

    public static final TokenSet TAGS_COMMENT =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.CSTART_C,
            TemplateLexer.CCLOSE_C,
            TemplateLexer.CSTERM_C,
            TemplateLexer.CENDI_C,
            TemplateLexer.TSTART_C,
            TemplateLexer.TCLOSE_C,
            TemplateLexer.TSTERM_C,
            TemplateLexer.TENDI_C,
            TemplateLexer.CS_C,
            TemplateLexer.TS_C);

    public static final TokenSet TAGS_BLOCK =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.CSTART_B,
            TemplateLexer.CSTART_BA,
            TemplateLexer.CSTART_BV,
            TemplateLexer.CCLOSE_B,
            TemplateLexer.CCLOSE_BA,
            TemplateLexer.CCLOSE_BV,
            TemplateLexer.CSTERM_B,
            TemplateLexer.CENDI_B,
            TemplateLexer.TSTART_B,
            TemplateLexer.TSTART_BA,
            TemplateLexer.TSTART_BV,
            TemplateLexer.TCLOSE_B,
            TemplateLexer.TCLOSE_BA,
            TemplateLexer.TCLOSE_BV,
            TemplateLexer.TSTERM_B,
            TemplateLexer.TENDI_B,
            TemplateLexer.CS_B,
            TemplateLexer.TS_B);

    public static final TokenSet TAGS_VALUE =
        PSIElementTypeFactory.createTokenSet(
            Rife2LanguageHtml.INSTANCE,
            TemplateLexer.CSTART_V,
            TemplateLexer.CCLOSE_V,
            TemplateLexer.CSTERM_V,
            TemplateLexer.CENDI_V,
            TemplateLexer.TSTART_V,
            TemplateLexer.TCLOSE_V,
            TemplateLexer.TSTERM_V,
            TemplateLexer.TENDI_V,
            TemplateLexer.CS_V,
            TemplateLexer.TS_V);

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTED;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new Rife2LexerHtml();
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        final var parser = new TemplateParser(null);
        return new ANTLRParserAdaptor(Rife2LanguageHtml.INSTANCE, parser) {
            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                return ((TemplateParser) parser).document();
            }
        };
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new Rife2FileHtml(viewProvider);
    }
}
