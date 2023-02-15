/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.file;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.NonEmptyInputValidator;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import static com.intellij.util.PlatformIcons.CLASS_ICON;

public class CreateRife2FileAction extends CreateFileFromTemplateAction implements DumbAware {
    public CreateRife2FileAction() {
        super("RIFE2 File", "Create a new RIFE2 file", Rife2Icons.FILE);
    }

    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory directory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder
            .setTitle("New RIFE2 File")
            .addKind("Element", CLASS_ICON, "RIFE2 Element.java")
            .addKind("Router", CLASS_ICON, "RIFE2 Router.java")
            .addKind("Site", CLASS_ICON, "RIFE2 Site.java")
            .setValidator(new NonEmptyInputValidator());
    }

    @Override
    protected String getActionName(PsiDirectory directory, @NonNls @NotNull String newName, @NonNls String templateName) {
        return "RIFE2 File";
    }
}
