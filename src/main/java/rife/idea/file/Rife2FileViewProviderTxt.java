/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiManager;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.OuterLanguageElementType;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageTxt;
import rife.idea.parser.Rife2ParserDefinitionTxt;

public class Rife2FileViewProviderTxt extends Rife2FileViewProvider {
    private static final TemplateDataElementType txtTemplateDataType;

    public Rife2FileViewProviderTxt(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file, Rife2LanguageTxt.getDefaultTemplateLang().getLanguage()));
    }

    public Rife2FileViewProviderTxt(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, templateLanguage);
    }

    protected TemplateDataElementType getTemplateDataType() {
        return txtTemplateDataType;
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new Rife2FileViewProviderTxt(getManager(), fileCopy, false, baseLanguage_, templateLanguage_);
    }

    static {
        txtTemplateDataType = new TemplateDataElementType(
            "TXT in RIFE2",
            Rife2LanguageTxt.INSTANCE,
            Rife2ParserDefinitionTxt.TEXT,
            new OuterLanguageElementType("OUTER_CONTENT", Rife2LanguageTxt.INSTANCE)) {
        };
    }
}
