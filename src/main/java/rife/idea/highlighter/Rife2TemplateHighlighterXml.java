/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.highlighter;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rife.idea.Rife2LanguageXml;
import rife.idea.parser.Rife2ParserDefinitionXml;

public class Rife2TemplateHighlighterXml extends LayeredLexerEditorHighlighter {
    public Rife2TemplateHighlighterXml(@Nullable Project project, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme colors) {
        // create the main highlighter
        super(new Rife2SyntaxHighlighterXml(), colors);

        FileType type = null;
        if (project == null || virtualFile == null) {
            type = FileTypes.PLAIN_TEXT;
        } else {
            var language = TemplateDataLanguageMappings.getInstance(project).getMapping(virtualFile);
            if (language != null) {
                type = language.getAssociatedFileType();
            }
            if (type == null) {
                type = Rife2LanguageXml.getDefaultTemplateLang();
            }
        }

        var outerHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(type, project, virtualFile);
        registerLayer(Rife2ParserDefinitionXml.TEXT, new LayerDescriptor(outerHighlighter, ""));
    }
}
