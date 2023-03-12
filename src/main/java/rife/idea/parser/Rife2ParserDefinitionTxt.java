/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.*;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageTxt;
import rife.idea.psi.Rife2FileTxt;
import rife.template.antlr.TemplateLexer;
import rife.template.antlr.TemplateParser;

public class Rife2ParserDefinitionTxt extends Rife2ParserDefinition {
    public static final IFileElementType FILE =
        new IFileElementType(Rife2LanguageTxt.INSTANCE);

    public static TokenIElementType
        TSTART_I, CSTART_I, TSTART_C, CSTART_C, TCLOSE_V, TSTART_V,
        CCLOSE_V, CSTART_V, TCLOSE_B, TSTART_B, CCLOSE_B, CSTART_B,
        TCLOSE_BV, TSTART_BV, CCLOSE_BV, CSTART_BV, TCLOSE_BA,
        TSTART_BA, CCLOSE_BA, CSTART_BA, TEXT, ERRCHAR, TSTERM_I,
        TS_I, TTagName_I, TERRCHAR_I, CSTERM_I, CS_I, CTagName_I,
        CERRCHAR_I, TENDI_C, TSTERM_C, TS_C, TComment_C, TERRCHAR_C,
        TCLOSE_C, TTEXT_C, CENDI_C, CSTERM_C, CS_C, CComment_C,
        CERRCHAR_C, CCLOSE_C, CTEXT_C, TENDI_V, TSTERM_V, TS_V,
        TTagName_V, TERRCHAR_V, CENDI_V, CSTERM_V, CS_V, CTagName_V,
        CERRCHAR_V, TENDI_B, TSTERM_B, TS_B, TTagName_B, TERRCHAR_B,
        CENDI_B, CSTERM_B, CS_B, CTagName_B, CERRCHAR_B;

    public static TokenSet COMMENTS;
    public static TokenSet COMMENTED;
    public static TokenSet STRINGS;
    public static TokenSet NAMES_INCLUDE;
    public static TokenSet NAMES_COMMENT;
    public static TokenSet NAMES_BLOCK;
    public static TokenSet NAMES_VALUE;
    public static TokenSet TAGS_INCLUDE;
    public static TokenSet TAGS_COMMENT;
    public static TokenSet TAGS_BLOCK;
    public static TokenSet TAGS_VALUE;

    static {
        setupLanguageDefinition();
    }

    public static void setupLanguageDefinition() {
        PSIElementTypeFactory.defineLanguageIElementTypes(Rife2LanguageTxt.INSTANCE,
            TemplateParser.tokenNames,
            TemplateParser.ruleNames);
        var tokenIElementTypes =
            PSIElementTypeFactory.getTokenIElementTypes(Rife2LanguageTxt.INSTANCE);

        TSTART_I = tokenIElementTypes.get(TemplateLexer.TSTART_I);
        CSTART_I = tokenIElementTypes.get(TemplateLexer.CSTART_I);
        TSTART_C = tokenIElementTypes.get(TemplateLexer.TSTART_C);
        CSTART_C = tokenIElementTypes.get(TemplateLexer.CSTART_C);
        TCLOSE_V = tokenIElementTypes.get(TemplateLexer.TCLOSE_V);
        TSTART_V = tokenIElementTypes.get(TemplateLexer.TSTART_V);
        CCLOSE_V = tokenIElementTypes.get(TemplateLexer.CCLOSE_V);
        CSTART_V = tokenIElementTypes.get(TemplateLexer.CSTART_V);
        TCLOSE_B = tokenIElementTypes.get(TemplateLexer.TCLOSE_B);
        TSTART_B = tokenIElementTypes.get(TemplateLexer.TSTART_B);
        CCLOSE_B = tokenIElementTypes.get(TemplateLexer.CCLOSE_B);
        CSTART_B = tokenIElementTypes.get(TemplateLexer.CSTART_B);
        TCLOSE_BV = tokenIElementTypes.get(TemplateLexer.TCLOSE_BV);
        TSTART_BV = tokenIElementTypes.get(TemplateLexer.TSTART_BV);
        CCLOSE_BV = tokenIElementTypes.get(TemplateLexer.CCLOSE_BV);
        CSTART_BV = tokenIElementTypes.get(TemplateLexer.CSTART_BV);
        TCLOSE_BA = tokenIElementTypes.get(TemplateLexer.TCLOSE_BA);
        TSTART_BA = tokenIElementTypes.get(TemplateLexer.TSTART_BA);
        CCLOSE_BA = tokenIElementTypes.get(TemplateLexer.CCLOSE_BA);
        CSTART_BA = tokenIElementTypes.get(TemplateLexer.CSTART_BA);
        TEXT = tokenIElementTypes.get(TemplateLexer.TEXT);
        ERRCHAR = tokenIElementTypes.get(TemplateLexer.ERRCHAR);
        TSTERM_I = tokenIElementTypes.get(TemplateLexer.TSTERM_I);
        TS_I = tokenIElementTypes.get(TemplateLexer.TS_I);
        TTagName_I = tokenIElementTypes.get(TemplateLexer.TTagName_I);
        TERRCHAR_I = tokenIElementTypes.get(TemplateLexer.TERRCHAR_I);
        CSTERM_I = tokenIElementTypes.get(TemplateLexer.CSTERM_I);
        CS_I = tokenIElementTypes.get(TemplateLexer.CS_I);
        CTagName_I = tokenIElementTypes.get(TemplateLexer.CTagName_I);
        CERRCHAR_I = tokenIElementTypes.get(TemplateLexer.CERRCHAR_I);
        TENDI_C = tokenIElementTypes.get(TemplateLexer.TENDI_C);
        TSTERM_C = tokenIElementTypes.get(TemplateLexer.TSTERM_C);
        TS_C = tokenIElementTypes.get(TemplateLexer.TS_C);
        TComment_C = tokenIElementTypes.get(TemplateLexer.TComment_C);
        TERRCHAR_C = tokenIElementTypes.get(TemplateLexer.TERRCHAR_C);
        TCLOSE_C = tokenIElementTypes.get(TemplateLexer.TCLOSE_C);
        TTEXT_C = tokenIElementTypes.get(TemplateLexer.TTEXT_C);
        CENDI_C = tokenIElementTypes.get(TemplateLexer.CENDI_C);
        CSTERM_C = tokenIElementTypes.get(TemplateLexer.CSTERM_C);
        CS_C = tokenIElementTypes.get(TemplateLexer.CS_C);
        CComment_C = tokenIElementTypes.get(TemplateLexer.CComment_C);
        CERRCHAR_C = tokenIElementTypes.get(TemplateLexer.CERRCHAR_C);
        CCLOSE_C = tokenIElementTypes.get(TemplateLexer.CCLOSE_C);
        CTEXT_C = tokenIElementTypes.get(TemplateLexer.CTEXT_C);
        TENDI_V = tokenIElementTypes.get(TemplateLexer.TENDI_V);
        TSTERM_V = tokenIElementTypes.get(TemplateLexer.TSTERM_V);
        TS_V = tokenIElementTypes.get(TemplateLexer.TS_V);
        TTagName_V = tokenIElementTypes.get(TemplateLexer.TTagName_V);
        TERRCHAR_V = tokenIElementTypes.get(TemplateLexer.TERRCHAR_V);
        CENDI_V = tokenIElementTypes.get(TemplateLexer.CENDI_V);
        CSTERM_V = tokenIElementTypes.get(TemplateLexer.CSTERM_V);
        CS_V = tokenIElementTypes.get(TemplateLexer.CS_V);
        CTagName_V = tokenIElementTypes.get(TemplateLexer.CTagName_V);
        CERRCHAR_V = tokenIElementTypes.get(TemplateLexer.CERRCHAR_V);
        TENDI_B = tokenIElementTypes.get(TemplateLexer.TENDI_B);
        TSTERM_B = tokenIElementTypes.get(TemplateLexer.TSTERM_B);
        TS_B = tokenIElementTypes.get(TemplateLexer.TS_B);
        TTagName_B = tokenIElementTypes.get(TemplateLexer.TTagName_B);
        TERRCHAR_B = tokenIElementTypes.get(TemplateLexer.TERRCHAR_B);
        CENDI_B = tokenIElementTypes.get(TemplateLexer.CENDI_B);
        CSTERM_B = tokenIElementTypes.get(TemplateLexer.CSTERM_B);
        CS_B = tokenIElementTypes.get(TemplateLexer.CS_B);
        CTagName_B = tokenIElementTypes.get(TemplateLexer.CTagName_B);
        CERRCHAR_B = tokenIElementTypes.get(TemplateLexer.CERRCHAR_B);

        COMMENTS =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTEXT_C,
                TemplateLexer.CTEXT_C,
                TemplateLexer.TComment_C,
                TemplateLexer.CComment_C);

        COMMENTED =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTEXT_C,
                TemplateLexer.CTEXT_C);

        STRINGS =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTagName_I,
                TemplateLexer.TComment_C,
                TemplateLexer.CTagName_I,
                TemplateLexer.CComment_C,
                TemplateLexer.TTagName_V,
                TemplateLexer.CTagName_V,
                TemplateLexer.TTagName_B,
                TemplateLexer.CTagName_B);

        NAMES_INCLUDE =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTagName_I,
                TemplateLexer.CTagName_I);

        NAMES_COMMENT =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TComment_C,
                TemplateLexer.CComment_C);

        NAMES_BLOCK =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTagName_B,
                TemplateLexer.CTagName_B);

        NAMES_VALUE =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.TTagName_V,
                TemplateLexer.CTagName_V);

        TAGS_INCLUDE =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
                TemplateLexer.CSTART_I,
                TemplateLexer.CSTERM_I,
                TemplateLexer.TSTART_I,
                TemplateLexer.TSTERM_I,
                TemplateLexer.CS_I,
                TemplateLexer.TS_I);

        TAGS_COMMENT =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
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

        TAGS_BLOCK =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
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

        TAGS_VALUE =
            PSIElementTypeFactory.createTokenSet(
                Rife2LanguageTxt.INSTANCE,
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
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new Rife2LexerTxt();
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        final var parser = new TemplateParser(null);
        return new ANTLRParserAdaptor(Rife2LanguageTxt.INSTANCE, parser) {
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
        return new Rife2FileTxt(viewProvider);
    }
}
