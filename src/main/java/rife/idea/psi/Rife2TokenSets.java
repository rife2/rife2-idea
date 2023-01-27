package rife.idea.psi;

import com.intellij.psi.tree.TokenSet;
import rife.idea.parser.Rife2ParserDefinition;

public class Rife2TokenSets {
    public static final TokenSet NAMES = Rife2ParserDefinition.STRINGS;

    public static final TokenSet TAGS = Rife2ParserDefinition.TAGS;
}
