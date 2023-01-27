package rife.idea.editor.actions;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2Language;
import rife.idea.file.Rife2FileType;

public class Rife2TypedHandler extends TypedHandlerDelegate {
    @NotNull
    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        var offset = editor.getCaretModel().getOffset();
        var provider = file.getViewProvider();

        if (!provider.getBaseLanguage().isKindOf(Rife2Language.INSTANCE)) {
            return Result.CONTINUE;
        }

        if (offset < 1 || offset > editor.getDocument().getTextLength()) {
            return Result.CONTINUE;
        }

        if (file.getName().endsWith(Rife2FileType.DEFAULT_EXTENSION)) {
            if (c == '{') {
                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

                var previous_chars = "";
                if (offset >= 3) {
                    previous_chars = editor.getDocument().getText(new TextRange(offset - 3, offset));
                }
                if (!previous_chars.equals("{{{") &&
                    (file.getLanguage().equals(HTMLLanguage.INSTANCE) ||
                     file.getLanguage().equals(Rife2Language.INSTANCE))) {
                    editor.getDocument().insertString(offset, "}");
                    editor.getCaretModel().moveToOffset(offset);
                }
            }
            if (c == '!') {
                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

                var previous_chars = editor.getDocument().getText(new TextRange(offset - 2, offset));
                if (previous_chars.equals("<!") &&
                    (file.getLanguage().equals(HTMLLanguage.INSTANCE) ||
                     file.getLanguage().equals(Rife2Language.INSTANCE))) {
                    editor.getDocument().insertString(offset, "---->");
                    editor.getCaretModel().moveToOffset(offset+2);
                }
            }
        }

        return Result.CONTINUE;
    }
}
