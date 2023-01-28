/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Rife2Highlighter {
    public static final TextAttributesKey NAME_INCLUDE = createTextAttributesKey("NAME INCLUDE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NAME_COMMENT = createTextAttributesKey("NAME COMMENT", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NAME_BLOCK = createTextAttributesKey("NAME BLOCK", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NAME_VALUE = createTextAttributesKey("NAME VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TAG_INCLUDE = createTextAttributesKey("TAG INCLUDE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TAG_COMMENT = createTextAttributesKey("TAG COMMENT", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TAG_BLOCK = createTextAttributesKey("TAG BLOCK", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TAG_VALUE = createTextAttributesKey("TAG VALUE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENTED = createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
}
