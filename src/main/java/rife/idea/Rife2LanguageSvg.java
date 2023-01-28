/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea;

import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.*;

public class Rife2LanguageSvg extends Language implements TemplateLanguage, InjectableLanguage {
    public static final Rife2LanguageSvg INSTANCE = new Rife2LanguageSvg();

    @SuppressWarnings("SameReturnValue") // ideally this would be public static, but the static inits in the tests get cranky when we do that
    public static LanguageFileType getDefaultTemplateLang() {
        return XmlFileType.INSTANCE;
    }

    public Rife2LanguageSvg() {
        super("RIFE2SVG", "text/x-rife2-svg");
    }

    public Rife2LanguageSvg(@Nullable Language baseLanguage, @NotNull @NonNls final String ID, @NonNls final String @NotNull ... mimeTypes) {
        super(baseLanguage, ID, mimeTypes);
    }
}
