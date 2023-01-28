/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.junit.Assert;
import rife.idea.parser.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public abstract class LexerTest {
    static {
        Rife2ParserDefinitionHtml.setupLanguageDefinition();
        Rife2ParserDefinitionJson.setupLanguageDefinition();
        Rife2ParserDefinitionSvg.setupLanguageDefinition();
        Rife2ParserDefinitionTxt.setupLanguageDefinition();
        Rife2ParserDefinitionXml.setupLanguageDefinition();
    }

    private final Lexer lexer;

    public LexerTest(Lexer lexer) {
        this.lexer = lexer;
    }

    protected void givenInput(String string) {
        lexer.start(string);
    }

    protected void thenTokensAre(Object... expectedTokenInfo) {
        var expected = new StringBuilder();
        for (var tokenInfo : expectedTokenInfo) {
            if (tokenInfo instanceof IElementType) {
                appendTokenInfo(expected, (IElementType) tokenInfo);
            } else if (tokenInfo instanceof String) {
                appendTokenInfo(expected, (String) tokenInfo);
            } else {
                throw new IllegalArgumentException("Token info must be either IElementType or String.");
            }
        }

        var actual = new StringBuilder();
        while (lexer.getCurrentPosition().getOffset() < lexer.getBufferEnd() && lexer.getTokenType() != null) {
//            System.out.println(lexer.getCurrentPosition().getOffset());
//            System.out.println(lexer.getTokenType());
//            System.out.println(lexer.getTokenText());
//            System.out.println(lexer.getBufferEnd());
            appendTokenInfo(actual, lexer.getTokenType(), lexer.getTokenText());
            lexer.advance();
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    private void appendTokenInfo(StringBuilder result, IElementType tokenType, String tokenText) {
        appendTokenInfo(result, tokenType);
        appendTokenInfo(result, tokenText);
    }

    private void appendTokenInfo(StringBuilder result, IElementType tokenType) {
        result.append(tokenType).append(": ");
    }

    private void appendTokenInfo(StringBuilder result, String tokenText) {
        result.append(tokenText).append('\n');
    }

    /**
     * Test that lexing a given piece of code will give particular tokens
     *
     * @param text           Sample piece of neon code
     * @param expectedTokens List of tokens expected from lexer
     */
    protected void doTest(@NonNls String text, @NonNls Pair<IElementType, String>[] expectedTokens) {
        doTest(text, expectedTokens, lexer);
    }

    private void doTest(String text, Pair<IElementType, String>[] expectedTokens, Lexer lexer) {
        lexer.start(text);
        var idx = 0;
        while (lexer.getTokenType() != null) {
            if (idx >= expectedTokens.length) fail("Too many tokens from lexer; unexpected " + lexer.getTokenType());

            var expected = expectedTokens[idx++];
            var tokenType = lexer.getTokenType();
            assertEquals("Wrong token", expected.first, tokenType);

            var tokenText = lexer.getBufferSequence().subSequence(lexer.getTokenStart(), lexer.getTokenEnd()).toString();
            assertEquals(expected.second, tokenText);
            lexer.advance();
        }

        if (idx < expectedTokens.length) fail("Not enough tokens from lexer, expected " + expectedTokens.length + " but got only " + idx);
    }
}