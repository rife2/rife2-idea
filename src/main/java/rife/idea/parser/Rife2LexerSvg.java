/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import rife.idea.Rife2LanguageSvg;

public class Rife2LexerSvg extends Rife2Lexer {
    public Rife2LexerSvg() {
        super(createXmlLexer(Rife2LanguageSvg.INSTANCE));
    }
}