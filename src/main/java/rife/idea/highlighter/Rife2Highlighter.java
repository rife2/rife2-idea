package rife.idea.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Rife2Highlighter {
    public static final TextAttributesKey NAME = createTextAttributesKey("NAME", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TAG = createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD);
}
