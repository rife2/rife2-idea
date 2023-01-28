/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.lexer.Lexer;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageJson;
import rife.idea.parser.Rife2LexerJson;
import rife.idea.psi.Rife2TokenSets;

public class Rife2SyntaxHighlighterJson extends Rife2SyntaxHighlighter {
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return Rife2LexerJson.createTxtLexer(Rife2LanguageJson.INSTANCE);
    }

    static {
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_NAMES_INCLUDE, Rife2Highlighter.NAME_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_NAMES_COMMENT, Rife2Highlighter.NAME_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_NAMES_BLOCK, Rife2Highlighter.NAME_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_NAMES_VALUE, Rife2Highlighter.NAME_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_TAGS_INCLUDE, Rife2Highlighter.TAG_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_TAGS_COMMENT, Rife2Highlighter.TAG_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_TAGS_BLOCK, Rife2Highlighter.TAG_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_TAGS_VALUE, Rife2Highlighter.TAG_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.JSON_COMMENTED, Rife2Highlighter.COMMENTED);
    }
}
