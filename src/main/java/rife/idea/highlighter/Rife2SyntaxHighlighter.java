/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class Rife2SyntaxHighlighter extends SyntaxHighlighterBase {
    public static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        var key = ATTRIBUTES.get(tokenType);

        return (key != null) ? pack(key) : new TextAttributesKey[0];
    }
}
