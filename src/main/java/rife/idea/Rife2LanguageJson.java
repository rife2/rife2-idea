/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea;

import com.intellij.json.JsonFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.*;

public class Rife2LanguageJson extends Language implements TemplateLanguage, InjectableLanguage {
    public static final Rife2LanguageJson INSTANCE = new Rife2LanguageJson();

    @SuppressWarnings("SameReturnValue") // ideally this would be public static, but the static inits in the tests get cranky when we do that
    public static LanguageFileType getDefaultTemplateLang() {
        return JsonFileType.INSTANCE;
    }

    public Rife2LanguageJson() {
        super("RIFE2JSON", "text/x-rife2-json");
    }

    public Rife2LanguageJson(@Nullable Language baseLanguage, @NotNull @NonNls final String ID, @NonNls final String ... mimeTypes) {
        super(baseLanguage, ID, mimeTypes);
    }
}
