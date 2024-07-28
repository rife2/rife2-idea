/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea;

import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.*;

public class Rife2LanguageTxt extends Language implements TemplateLanguage, InjectableLanguage {
    @NotNull
    public static final Rife2LanguageTxt INSTANCE = new Rife2LanguageTxt();

    public static LanguageFileType getDefaultTemplateLang() {
        return PlainTextFileType.INSTANCE;
    }

    private Rife2LanguageTxt() {
        super("RIFE2TXT", "text/x-rife2-txt");
    }
}
