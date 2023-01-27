/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Rife2Highlighter {
    public static final TextAttributesKey NAME = createTextAttributesKey("NAME", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TAG = createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD);
}
