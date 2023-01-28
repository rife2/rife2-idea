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
}
