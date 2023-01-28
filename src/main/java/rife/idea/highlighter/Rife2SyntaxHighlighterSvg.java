/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.lexer.Lexer;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageSvg;
import rife.idea.parser.Rife2LexerSvg;
import rife.idea.psi.Rife2TokenSets;

public class Rife2SyntaxHighlighterSvg extends Rife2SyntaxHighlighter {
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return Rife2LexerSvg.createXmlLexer(Rife2LanguageSvg.INSTANCE);
    }

    static {
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_NAMES_INCLUDE, Rife2Highlighter.NAME_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_NAMES_COMMENT, Rife2Highlighter.NAME_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_NAMES_BLOCK, Rife2Highlighter.NAME_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_NAMES_VALUE, Rife2Highlighter.NAME_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_TAGS_INCLUDE, Rife2Highlighter.TAG_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_TAGS_COMMENT, Rife2Highlighter.TAG_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_TAGS_BLOCK, Rife2Highlighter.TAG_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_TAGS_VALUE, Rife2Highlighter.TAG_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.SVG_COMMENTED, Rife2Highlighter.COMMENTED);
    }
}
