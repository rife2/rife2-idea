/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import rife.idea.Rife2LanguageTxt;

public class Rife2LexerTxt extends Rife2Lexer {
    public Rife2LexerTxt() {
        super(createTxtLexer(Rife2LanguageTxt.INSTANCE));
    }
}