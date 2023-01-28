/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Rife2LanguageHtml extends Language implements TemplateLanguage, InjectableLanguage {
    public static final Rife2LanguageHtml INSTANCE = new Rife2LanguageHtml();

    @SuppressWarnings("SameReturnValue") // ideally this would be public static, but the static inits in the tests get cranky when we do that
    public static LanguageFileType getDefaultTemplateLang() {
        return HtmlFileType.INSTANCE;
    }

    public Rife2LanguageHtml() {
        super("RIFE2HTML", "text/x-rife2-html");
    }

    public Rife2LanguageHtml(@Nullable Language baseLanguage, @NotNull @NonNls final String ID, @NonNls final String @NotNull ... mimeTypes) {
        super(baseLanguage, ID, mimeTypes);
    }
}
