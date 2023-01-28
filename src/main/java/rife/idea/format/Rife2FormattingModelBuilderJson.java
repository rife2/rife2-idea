/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.format;

import com.intellij.psi.tree.IElementType;
import rife.idea.parser.Rife2ParserDefinitionJson;

public class Rife2FormattingModelBuilderJson extends Rife2FormattingModelBuilder {
    @Override
    protected IElementType getTemplateTextElementType() {
        return Rife2ParserDefinitionJson.TEXT;
    }
}
