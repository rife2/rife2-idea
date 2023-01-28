/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.lang.*;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public abstract class Rife2FileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    protected final Language baseLanguage_;
    protected final Language templateLanguage_;

    public Rife2FileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled);
        baseLanguage_ = baseLanguage;
        templateLanguage_ = templateLanguage;
    }

    protected abstract TemplateDataElementType getTemplateDataType();

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return baseLanguage_;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return templateLanguage_;
    }

    protected static @NotNull Language getTemplateDataLanguage(PsiManager manager, VirtualFile file, Language rifeLanguage) {
        var language = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (language == null) {
            language = rifeLanguage;
        }

        var substituteLanguage = LanguageSubstitutors.getInstance().substituteLanguage(language, file, manager.getProject());

        if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLanguage)) {
            language = substituteLanguage;
        }

        return language;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return Set.of(baseLanguage_, getTemplateDataLanguage());
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language language) {
        var parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);

        if (parserDefinition == null) {
            return null;
        }

        if (language.is(getTemplateDataLanguage())) {
            var file = (PsiFileImpl) parserDefinition.createFile(this);
            file.setContentElementType(getTemplateDataType());
            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        } else {
            return null;
        }
    }
}
