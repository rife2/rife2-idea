/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import rife.idea.psi.Rife2TokenSets;

import java.util.HashMap;
import java.util.Map;

public abstract class Rife2SyntaxHighlighter extends SyntaxHighlighterBase {
    public static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        var key = ATTRIBUTES.get(tokenType);

        return (key != null) ? pack(key) : new TextAttributesKey[0];
    }

    static {
        fillMap(ATTRIBUTES, Rife2TokenSets.NAMES_INCLUDE, Rife2Highlighter.NAME_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.NAMES_COMMENT, Rife2Highlighter.NAME_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.NAMES_BLOCK, Rife2Highlighter.NAME_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.NAMES_VALUE, Rife2Highlighter.NAME_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.TAGS_INCLUDE, Rife2Highlighter.TAG_INCLUDE);
        fillMap(ATTRIBUTES, Rife2TokenSets.TAGS_COMMENT, Rife2Highlighter.TAG_COMMENT);
        fillMap(ATTRIBUTES, Rife2TokenSets.TAGS_BLOCK, Rife2Highlighter.TAG_BLOCK);
        fillMap(ATTRIBUTES, Rife2TokenSets.TAGS_VALUE, Rife2Highlighter.TAG_VALUE);
        fillMap(ATTRIBUTES, Rife2TokenSets.COMMENTED, Rife2Highlighter.COMMENTED);
    }
}
