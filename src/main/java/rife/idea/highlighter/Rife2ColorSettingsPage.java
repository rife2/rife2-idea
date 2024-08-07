/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.codeHighlighting.RainbowHighlighter;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageHtml;
import rife.idea.file.Rife2Icons;

import javax.swing.*;
import java.util.Map;

public class Rife2ColorSettingsPage implements ColorSettingsPage {
    private static final SyntaxHighlighter SYNTAX_HIGHLIGHTER;
    private static final AttributesDescriptor[] DESCRIPTORS;

    @Override
    public @Nullable Icon getIcon() {
        return Rife2Icons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return SYNTAX_HIGHLIGHTER;
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "<!--v shortValue/-->\n" +
               "<!--v longValue-->default content<!--/v-->\n" +
               "{{v compactShortValue/}}\n" +
               "{{v compactLongValue}}default content{{/v}}\n" +
               "\n" +
               "<!--b block-->block content<!--/b-->\n" +
               "<!--bv block-->block value content<!--/bv-->\n" +
               "<!--ba block-->block append content<!--/ba-->\n" +
               "{{b compactBlock}}block content{{/b}}\n" +
               "{{bv compactBlock}}block value content{{/bv}}\n" +
               "{{ba compactBlock}}block append content{{/ba}}\n" +
               "\n" +
               "<!--i include/-->\n" +
               "{{i compactInclude/}}\n" +
               "\n" +
               "<!--c shortComment/-->\n" +
               "<!--c comment-->the comment<!--/c-->\n" +
               "{{c compactShortComment/}}\n" +
               "{{c compactComment}}the comment{{/c}}";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return ourTags;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "RIFE2";
    }

    @NonNls private static final Map<String, TextAttributesKey> ourTags = RainbowHighlighter.createRainbowHLM();

    static {
        SYNTAX_HIGHLIGHTER = SyntaxHighlighterFactory.getSyntaxHighlighter(Rife2LanguageHtml.INSTANCE, null, null);
        DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Commented", Rife2Highlighter.COMMENTED),
            new AttributesDescriptor("Name include", Rife2Highlighter.NAME_INCLUDE),
            new AttributesDescriptor("Name comment", Rife2Highlighter.NAME_COMMENT),
            new AttributesDescriptor("Name block", Rife2Highlighter.NAME_BLOCK),
            new AttributesDescriptor("Name value", Rife2Highlighter.NAME_VALUE),
            new AttributesDescriptor("Tag include", Rife2Highlighter.TAG_INCLUDE),
            new AttributesDescriptor("Tag comment", Rife2Highlighter.TAG_COMMENT),
            new AttributesDescriptor("Tag block", Rife2Highlighter.TAG_BLOCK),
            new AttributesDescriptor("Tag value", Rife2Highlighter.TAG_VALUE)
        };

        ourTags.put("outer_language", XmlHighlighterColors.HTML_TAG);
    }
}
