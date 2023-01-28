/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.editor.actions;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2LanguageHtml;
import rife.idea.file.Rife2FileTypeHtml;

public class Rife2TypedHandler extends TypedHandlerDelegate {
    @NotNull
    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        var offset = editor.getCaretModel().getOffset();
        var provider = file.getViewProvider();

        if (!provider.getBaseLanguage().isKindOf(Rife2LanguageHtml.INSTANCE)) {
            return Result.CONTINUE;
        }

        if (offset < 1 || offset > editor.getDocument().getTextLength()) {
            return Result.CONTINUE;
        }

        if (file.getName().endsWith(Rife2FileTypeHtml.DEFAULT_EXTENSION)) {
            charTypedCompact(c, project, editor, file, offset);
            charTypedXml(c, project, editor, file, offset);
        }

        return Result.CONTINUE;
    }

    private static void charTypedXml(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, int offset) {
        if (c == '!') {
            PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

            var previous_chars = editor.getDocument().getText(new TextRange(offset - 2, offset));
            if (previous_chars.equals("<!") &&
                (file.getLanguage().equals(HTMLLanguage.INSTANCE) ||
                 file.getLanguage().equals(Rife2LanguageHtml.INSTANCE))) {
                editor.getDocument().insertString(offset, "---->");
                editor.getCaretModel().moveToOffset(offset + 2);
            }
        }
    }

    private static void charTypedCompact(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, int offset) {
        if (c == '{') {
            PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

            var previous_chars = "";
            if (offset >= 3) {
                previous_chars = editor.getDocument().getText(new TextRange(offset - 3, offset));
            }
            if (!previous_chars.equals("{{{") &&
                (file.getLanguage().equals(HTMLLanguage.INSTANCE) ||
                 file.getLanguage().equals(Rife2LanguageHtml.INSTANCE))) {
                editor.getDocument().insertString(offset, "}");
                editor.getCaretModel().moveToOffset(offset);
            }
        }
    }
}
