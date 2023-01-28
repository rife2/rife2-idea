package rife.idea.editor.actions;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.jetbrains.annotations.NotNull;
import rife.idea.file.*;

public abstract class Rife2ActionHandlerTest extends BasePlatformTestCase {
    private void performWriteAction(final Project project, final Runnable action) {
        ApplicationManager.getApplication().runWriteAction(() -> CommandProcessor.getInstance().executeCommand(project, action, "test command", null));
    }

    private void validateTestStrings(@NotNull String before, @NotNull String expected) {
        if (!before.contains("<caret>") || !expected.contains("<caret>")) {
            throw new IllegalArgumentException("Test strings must contain \"<caret>\" to indicate caret position");
        }
    }

    void doCharTestXml(final char charToType, @NotNull String before, @NotNull String expected) {
        EditorActionManager.getInstance();
        final TypedAction typedAction = TypedAction.getInstance();
        doExecuteActionTestXml(before, expected, () -> typedAction.actionPerformed(myFixture.getEditor(), charToType, ((EditorEx) myFixture.getEditor()).getDataContext()));
    }

    private void doExecuteActionTestXml(@NotNull String before, @NotNull String expected, @NotNull Runnable action) {
        validateTestStrings(before, expected);

        myFixture.configureByText(Rife2FileTypeHtml.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);

        myFixture.configureByText(Rife2FileTypeSvg.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);

        myFixture.configureByText(Rife2FileTypeXml.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);
    }

    void doCharTestJson(final char charToType, @NotNull String before, @NotNull String expected) {
        EditorActionManager.getInstance();
        final TypedAction typedAction = TypedAction.getInstance();
        doExecuteActionTestJson(before, expected, () -> typedAction.actionPerformed(myFixture.getEditor(), charToType, ((EditorEx) myFixture.getEditor()).getDataContext()));
    }

    private void doExecuteActionTestJson(@NotNull String before, @NotNull String expected, @NotNull Runnable action) {
        validateTestStrings(before, expected);

        myFixture.configureByText(Rife2FileTypeJson.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);
    }

    void doCharTestTxt(final char charToType, @NotNull String before, @NotNull String expected) {
        EditorActionManager.getInstance();
        final TypedAction typedAction = TypedAction.getInstance();
        doExecuteActionTestTxt(before, expected, () -> typedAction.actionPerformed(myFixture.getEditor(), charToType, ((EditorEx) myFixture.getEditor()).getDataContext()));
    }

    private void doExecuteActionTestTxt(@NotNull String before, @NotNull String expected, @NotNull Runnable action) {
        validateTestStrings(before, expected);

        myFixture.configureByText(Rife2FileTypeTxt.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);
    }
}
