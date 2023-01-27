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
import com.intellij.psi.tree.OuterLanguageElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rife.idea.Rife2Language;
import rife.idea.parser.Rife2ParserDefinition;

import java.util.Set;

public class Rife2FileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language myBaseLanguage;
    private final Language myTemplateLanguage;
    private static final TemplateDataElementType htmlTemplateDataType;

    public Rife2FileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        this(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file));
    }

    public Rife2FileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled);
        myBaseLanguage = baseLanguage;
        myTemplateLanguage = templateLanguage;
    }

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return myBaseLanguage;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return myTemplateLanguage;
    }

    private static @NotNull Language getTemplateDataLanguage(PsiManager manager, VirtualFile file) {
        var language = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (language == null) {
            language = Rife2Language.getDefaultTemplateLang().getLanguage();
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
        return Set.of(myBaseLanguage, getTemplateDataLanguage());
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new Rife2FileViewProvider(getManager(), fileCopy, false, myBaseLanguage, myTemplateLanguage);
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
            file.setContentElementType(htmlTemplateDataType);
            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        } else {
            return null;
        }
    }

    static {
        htmlTemplateDataType = new TemplateDataElementType(
            "HTML in RIFE2",
            Rife2Language.INSTANCE,
            Rife2ParserDefinition.TEXT,
            new OuterLanguageElementType("OUTER_CONTENT", Rife2Language.INSTANCE)) {
        };
    }
}
