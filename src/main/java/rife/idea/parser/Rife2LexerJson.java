/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import rife.idea.Rife2LanguageJson;

public class Rife2LexerJson extends Rife2Lexer {
    public Rife2LexerJson() {
        super(createTxtLexer(Rife2LanguageJson.INSTANCE));
    }
}