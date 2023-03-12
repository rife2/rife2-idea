/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.liveTemplates;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class XmlContext extends TemplateContextType {
    protected XmlContext() {
        super("XML");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getName().endsWith(".xml");
    }

}
