/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.psi;

import com.intellij.psi.tree.TokenSet;
import rife.idea.parser.Rife2ParserDefinition;

public class Rife2TokenSets {
    public static final TokenSet NAMES = Rife2ParserDefinition.STRINGS;

    public static final TokenSet TAGS = Rife2ParserDefinition.TAGS;
}
