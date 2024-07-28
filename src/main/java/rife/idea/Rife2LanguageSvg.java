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
    @NotNull
    public static final Rife2LanguageSvg INSTANCE = new Rife2LanguageSvg();

    public static LanguageFileType getDefaultTemplateLang() {
        return XmlFileType.INSTANCE;
    }

    private Rife2LanguageSvg() {
        super("RIFE2SVG", "text/x-rife2-svg");
    }
}
