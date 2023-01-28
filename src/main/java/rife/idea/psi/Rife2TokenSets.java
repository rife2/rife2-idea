/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.psi.tree.TokenSet;
import rife.idea.parser.Rife2ParserDefinitionHtml;

public class Rife2TokenSets {
    public static final TokenSet NAMES_INCLUDE = Rife2ParserDefinitionHtml.NAMES_INCLUDE;
    public static final TokenSet NAMES_COMMENT = Rife2ParserDefinitionHtml.NAMES_COMMENT;
    public static final TokenSet NAMES_BLOCK = Rife2ParserDefinitionHtml.NAMES_BLOCK;
    public static final TokenSet NAMES_VALUE = Rife2ParserDefinitionHtml.NAMES_VALUE;
    public static final TokenSet TAGS_INCLUDE = Rife2ParserDefinitionHtml.TAGS_INCLUDE;
    public static final TokenSet TAGS_COMMENT = Rife2ParserDefinitionHtml.TAGS_COMMENT;
    public static final TokenSet TAGS_BLOCK = Rife2ParserDefinitionHtml.TAGS_BLOCK;
    public static final TokenSet TAGS_VALUE = Rife2ParserDefinitionHtml.TAGS_VALUE;
    public static final TokenSet COMMENTED = Rife2ParserDefinitionHtml.COMMENTED;
}
