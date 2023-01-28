/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.templateLanguages.*;
import com.intellij.psi.tree.OuterLanguageElementType;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageHtml;
import rife.idea.parser.Rife2ParserDefinitionHtml;

public class Rife2FileViewProviderHtml extends Rife2FileViewProvider {
    private static final TemplateDataElementType htmlTemplateDataType;

    public Rife2FileViewProviderHtml(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file, Rife2LanguageHtml.getDefaultTemplateLang().getLanguage()));
    }

    public Rife2FileViewProviderHtml(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, templateLanguage);
    }

    protected TemplateDataElementType getTemplateDataType() {
        return htmlTemplateDataType;
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new Rife2FileViewProviderHtml(getManager(), fileCopy, false, baseLanguage_, templateLanguage_);
    }

    static {
        htmlTemplateDataType = new TemplateDataElementType(
            "HTML in RIFE2",
            Rife2LanguageHtml.INSTANCE,
            Rife2ParserDefinitionHtml.TEXT,
            new OuterLanguageElementType("OUTER_CONTENT", Rife2LanguageHtml.INSTANCE)) {
        };
    }
}
