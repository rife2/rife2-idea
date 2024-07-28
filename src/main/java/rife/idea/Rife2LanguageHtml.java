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
import org.jetbrains.annotations.NotNull;

public class Rife2LanguageHtml extends Language implements TemplateLanguage, InjectableLanguage {
    @NotNull
    public static final Rife2LanguageHtml INSTANCE = new Rife2LanguageHtml();

    public static LanguageFileType getDefaultTemplateLang() {
        return HtmlFileType.INSTANCE;
    }

    private Rife2LanguageHtml() {
        super("RIFE2HTML", "text/x-rife2-html");
    }
}
