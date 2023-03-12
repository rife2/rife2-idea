/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lang.*;
import com.intellij.psi.*;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;

public abstract class Rife2ParserDefinition implements ParserDefinition {
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    public PsiElement createElement(ASTNode node) {
        return new ANTLRPsiNode(node);
    }
}
