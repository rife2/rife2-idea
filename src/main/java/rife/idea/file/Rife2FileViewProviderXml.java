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
import rife.idea.Rife2LanguageXml;
import rife.idea.parser.Rife2ParserDefinitionXml;

public class Rife2FileViewProviderXml extends Rife2FileViewProvider {
    private static final TemplateDataElementType xmlTemplateDataType;

    public Rife2FileViewProviderXml(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file, Rife2LanguageXml.getDefaultTemplateLang().getLanguage()));
    }

    public Rife2FileViewProviderXml(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, templateLanguage);
    }

    protected TemplateDataElementType getTemplateDataType() {
        return xmlTemplateDataType;
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new Rife2FileViewProviderXml(getManager(), fileCopy, false, baseLanguage_, templateLanguage_);
    }

    static {
        xmlTemplateDataType = new TemplateDataElementType(
            "XML in RIFE2",
            Rife2LanguageXml.INSTANCE,
            Rife2ParserDefinitionXml.TEXT,
            new OuterLanguageElementType("OUTER_CONTENT", Rife2LanguageXml.INSTANCE)) {
        };
    }
}
