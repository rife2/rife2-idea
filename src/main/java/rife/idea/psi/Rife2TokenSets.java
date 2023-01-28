/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.psi.tree.TokenSet;
import rife.idea.parser.*;

public class Rife2TokenSets {
    public static final TokenSet HTML_NAMES_INCLUDE = Rife2ParserDefinitionHtml.NAMES_INCLUDE;
    public static final TokenSet HTML_NAMES_COMMENT = Rife2ParserDefinitionHtml.NAMES_COMMENT;
    public static final TokenSet HTML_NAMES_BLOCK = Rife2ParserDefinitionHtml.NAMES_BLOCK;
    public static final TokenSet HTML_NAMES_VALUE = Rife2ParserDefinitionHtml.NAMES_VALUE;
    public static final TokenSet HTML_TAGS_INCLUDE = Rife2ParserDefinitionHtml.TAGS_INCLUDE;
    public static final TokenSet HTML_TAGS_COMMENT = Rife2ParserDefinitionHtml.TAGS_COMMENT;
    public static final TokenSet HTML_TAGS_BLOCK = Rife2ParserDefinitionHtml.TAGS_BLOCK;
    public static final TokenSet HTML_TAGS_VALUE = Rife2ParserDefinitionHtml.TAGS_VALUE;
    public static final TokenSet HTML_COMMENTED = Rife2ParserDefinitionHtml.COMMENTED;

    public static final TokenSet JSON_NAMES_INCLUDE = Rife2ParserDefinitionJson.NAMES_INCLUDE;
    public static final TokenSet JSON_NAMES_COMMENT = Rife2ParserDefinitionJson.NAMES_COMMENT;
    public static final TokenSet JSON_NAMES_BLOCK = Rife2ParserDefinitionJson.NAMES_BLOCK;
    public static final TokenSet JSON_NAMES_VALUE = Rife2ParserDefinitionJson.NAMES_VALUE;
    public static final TokenSet JSON_TAGS_INCLUDE = Rife2ParserDefinitionJson.TAGS_INCLUDE;
    public static final TokenSet JSON_TAGS_COMMENT = Rife2ParserDefinitionJson.TAGS_COMMENT;
    public static final TokenSet JSON_TAGS_BLOCK = Rife2ParserDefinitionJson.TAGS_BLOCK;
    public static final TokenSet JSON_TAGS_VALUE = Rife2ParserDefinitionJson.TAGS_VALUE;
    public static final TokenSet JSON_COMMENTED = Rife2ParserDefinitionJson.COMMENTED;

    public static final TokenSet SVG_NAMES_INCLUDE = Rife2ParserDefinitionSvg.NAMES_INCLUDE;
    public static final TokenSet SVG_NAMES_COMMENT = Rife2ParserDefinitionSvg.NAMES_COMMENT;
    public static final TokenSet SVG_NAMES_BLOCK = Rife2ParserDefinitionSvg.NAMES_BLOCK;
    public static final TokenSet SVG_NAMES_VALUE = Rife2ParserDefinitionSvg.NAMES_VALUE;
    public static final TokenSet SVG_TAGS_INCLUDE = Rife2ParserDefinitionSvg.TAGS_INCLUDE;
    public static final TokenSet SVG_TAGS_COMMENT = Rife2ParserDefinitionSvg.TAGS_COMMENT;
    public static final TokenSet SVG_TAGS_BLOCK = Rife2ParserDefinitionSvg.TAGS_BLOCK;
    public static final TokenSet SVG_TAGS_VALUE = Rife2ParserDefinitionSvg.TAGS_VALUE;
    public static final TokenSet SVG_COMMENTED = Rife2ParserDefinitionSvg.COMMENTED;

    public static final TokenSet TXT_NAMES_INCLUDE = Rife2ParserDefinitionTxt.NAMES_INCLUDE;
    public static final TokenSet TXT_NAMES_COMMENT = Rife2ParserDefinitionTxt.NAMES_COMMENT;
    public static final TokenSet TXT_NAMES_BLOCK = Rife2ParserDefinitionTxt.NAMES_BLOCK;
    public static final TokenSet TXT_NAMES_VALUE = Rife2ParserDefinitionTxt.NAMES_VALUE;
    public static final TokenSet TXT_TAGS_INCLUDE = Rife2ParserDefinitionTxt.TAGS_INCLUDE;
    public static final TokenSet TXT_TAGS_COMMENT = Rife2ParserDefinitionTxt.TAGS_COMMENT;
    public static final TokenSet TXT_TAGS_BLOCK = Rife2ParserDefinitionTxt.TAGS_BLOCK;
    public static final TokenSet TXT_TAGS_VALUE = Rife2ParserDefinitionTxt.TAGS_VALUE;
    public static final TokenSet TXT_COMMENTED = Rife2ParserDefinitionTxt.COMMENTED;

    public static final TokenSet XML_NAMES_INCLUDE = Rife2ParserDefinitionXml.NAMES_INCLUDE;
    public static final TokenSet XML_NAMES_COMMENT = Rife2ParserDefinitionXml.NAMES_COMMENT;
    public static final TokenSet XML_NAMES_BLOCK = Rife2ParserDefinitionXml.NAMES_BLOCK;
    public static final TokenSet XML_NAMES_VALUE = Rife2ParserDefinitionXml.NAMES_VALUE;
    public static final TokenSet XML_TAGS_INCLUDE = Rife2ParserDefinitionXml.TAGS_INCLUDE;
    public static final TokenSet XML_TAGS_COMMENT = Rife2ParserDefinitionXml.TAGS_COMMENT;
    public static final TokenSet XML_TAGS_BLOCK = Rife2ParserDefinitionXml.TAGS_BLOCK;
    public static final TokenSet XML_TAGS_VALUE = Rife2ParserDefinitionXml.TAGS_VALUE;
    public static final TokenSet XML_COMMENTED = Rife2ParserDefinitionXml.COMMENTED;
}
