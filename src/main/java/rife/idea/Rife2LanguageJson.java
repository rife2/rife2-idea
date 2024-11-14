/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea;

import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.*;

public class Rife2LanguageJson extends Language implements TemplateLanguage, InjectableLanguage {
    @NotNull
    public static final Rife2LanguageJson INSTANCE = new Rife2LanguageJson();

    public static LanguageFileType getDefaultTemplateLang() {
        return (LanguageFileType) FileTypeRegistry.getInstance().findFileTypeByName("JSON");
    }

    private Rife2LanguageJson() {
        super("RIFE2JSON", "text/x-rife2-json");
    }
}
