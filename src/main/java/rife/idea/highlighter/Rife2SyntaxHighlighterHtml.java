/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageHtml;
import rife.idea.parser.Rife2LexerHtml;
import rife.idea.psi.Rife2TokenSets;

import java.util.HashMap;
import java.util.Map;

public class Rife2SyntaxHighlighterHtml extends Rife2SyntaxHighlighter {
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return Rife2LexerHtml.createXmlLexer(Rife2LanguageHtml.INSTANCE);
    }

    static {
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_NAMES_INCLUDE, Rife2Highlighter.NAME_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_NAMES_COMMENT, Rife2Highlighter.NAME_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_NAMES_BLOCK, Rife2Highlighter.NAME_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_NAMES_VALUE, Rife2Highlighter.NAME_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_TAGS_INCLUDE, Rife2Highlighter.TAG_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_TAGS_COMMENT, Rife2Highlighter.TAG_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_TAGS_BLOCK, Rife2Highlighter.TAG_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_TAGS_VALUE, Rife2Highlighter.TAG_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.HTML_COMMENTED, Rife2Highlighter.COMMENTED);
    }
}
