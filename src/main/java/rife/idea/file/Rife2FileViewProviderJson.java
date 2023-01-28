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
import rife.idea.Rife2LanguageJson;
import rife.idea.parser.Rife2ParserDefinitionJson;

public class Rife2FileViewProviderJson extends Rife2FileViewProvider {
    private static final TemplateDataElementType jsonTemplateDataType;

    public Rife2FileViewProviderJson(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file, Rife2LanguageJson.getDefaultTemplateLang().getLanguage()));
    }

    public Rife2FileViewProviderJson(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled, baseLanguage, templateLanguage);
    }

    protected TemplateDataElementType getTemplateDataType() {
        return jsonTemplateDataType;
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new Rife2FileViewProviderJson(getManager(), fileCopy, false, baseLanguage_, templateLanguage_);
    }

    static {
        jsonTemplateDataType = new TemplateDataElementType(
            "JSON in RIFE2",
            Rife2LanguageJson.INSTANCE,
            Rife2ParserDefinitionJson.TEXT,
            new OuterLanguageElementType("OUTER_CONTENT", Rife2LanguageJson.INSTANCE)) {
        };
    }
}
