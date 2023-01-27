/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.parser;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.antlr.intellij.adaptor.lexer.*;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;
import rife.idea.Rife2Language;
import rife.idea.psi.Rife2File;
import rife.template.antlr.TemplateLexer;
import rife.template.antlr.TemplateParser;

public class Rife2ParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE =
        new IFileElementType(Rife2Language.INSTANCE);

    public static TokenIElementType TEXT;

    static {
        PSIElementTypeFactory.defineLanguageIElementTypes(Rife2Language.INSTANCE,
            TemplateParser.tokenNames,
            TemplateParser.ruleNames);
        var tokenIElementTypes =
            PSIElementTypeFactory.getTokenIElementTypes(Rife2Language.INSTANCE);
        TEXT = tokenIElementTypes.get(TemplateLexer.TEXT);
    }

    public static final TokenSet COMMENTS =
        PSIElementTypeFactory.createTokenSet(
            Rife2Language.INSTANCE);

    public static final TokenSet STRINGS =
        PSIElementTypeFactory.createTokenSet(
            Rife2Language.INSTANCE,
            TemplateLexer.TTagName_I,
            TemplateLexer.TComment_C,
            TemplateLexer.CTagName_I,
            TemplateLexer.CComment_C,
            TemplateLexer.TTagName,
            TemplateLexer.CTagName);

    public static final TokenSet TAGS =
        PSIElementTypeFactory.createTokenSet(
            Rife2Language.INSTANCE,
            TemplateLexer.CSTART_I,
            TemplateLexer.CSTART_C,
            TemplateLexer.CSTART_B,
            TemplateLexer.CSTART_BA,
            TemplateLexer.CSTART_BV,
            TemplateLexer.CSTART_V,
            TemplateLexer.CCLOSE_C,
            TemplateLexer.CCLOSE_B,
            TemplateLexer.CCLOSE_BA,
            TemplateLexer.CCLOSE_BV,
            TemplateLexer.CCLOSE_V,
            TemplateLexer.CSTERM_I,
            TemplateLexer.CSTERM,
            TemplateLexer.CENDI_C,
            TemplateLexer.CENDI,
            TemplateLexer.TSTART_I,
            TemplateLexer.TSTART_C,
            TemplateLexer.TSTART_B,
            TemplateLexer.TSTART_BA,
            TemplateLexer.TSTART_BV,
            TemplateLexer.TSTART_V,
            TemplateLexer.TCLOSE_C,
            TemplateLexer.TCLOSE_B,
            TemplateLexer.TCLOSE_BA,
            TemplateLexer.TCLOSE_BV,
            TemplateLexer.TCLOSE_V,
            TemplateLexer.TSTERM_I,
            TemplateLexer.TSTERM,
            TemplateLexer.TENDI_C,
            TemplateLexer.TENDI,
            TemplateLexer.CS_I,
            TemplateLexer.TS_I,
            TemplateLexer.CS,
            TemplateLexer.TS);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new Rife2Lexer();
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        final var parser = new TemplateParser(null);
        return new ANTLRParserAdaptor(Rife2Language.INSTANCE, parser) {
            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                return ((TemplateParser) parser).document();
            }
        };
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    /**
     * What is the IFileElementType of the root parse tree node? It
     * is called from {@link #createFile(FileViewProvider)} at least.
     */
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    /**
     * Create the root of your PSI tree (a PsiFile).
     * <p>
     * From IntelliJ IDEA Architectural Overview:
     * "A PSI (Program Structure Interface) file is the root of a structure
     * representing the contents of a file as a hierarchy of elements
     * in a particular programming language."
     * <p>
     * PsiFile is to be distinguished from a FileASTNode, which is a parse
     * tree node that eventually becomes a PsiFile. From PsiFile, we can get
     * it back via: {@link PsiFile#getNode}.
     */
    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new Rife2File(viewProvider);
    }

    /**
     * Convert from *NON-LEAF* parse node (AST they call it)
     * to PSI node. Leaves are created in the AST factory.
     * Rename re-factoring can cause this to be
     * called on a TokenIElementType since we want to rename ID nodes.
     * In that case, this method is called to create the root node
     * but with ID type. Kind of strange, but we can simply create a
     * ASTWrapperPsiElement to make everything work correctly.
     * <p>
     * RuleIElementType.  Ah! It's that ID is the root
     * IElementType requested to parse, which means that the root
     * node returned from parsetree->PSI conversion.  But, it
     * must be a CompositeElement! The adaptor calls
     * rootMarker.done(root) to finish off the PSI conversion.
     * See {@link ANTLRParserAdaptor#parse(IElementType root,
     * PsiBuilder)}
     * <p>
     * If you don't care to distinguish PSI nodes by type, it is
     * sufficient to create a {@link ANTLRPsiNode} around
     * the parse tree node
     */
    @NotNull
    public PsiElement createElement(ASTNode node) {
        var elType = node.getElementType();
        if (elType instanceof TokenIElementType) {
            return new ANTLRPsiNode(node);
        }
        if (!(elType instanceof RuleIElementType)) {
            return new ANTLRPsiNode(node);
        }
        var ruleElType = (RuleIElementType) elType;
        switch (ruleElType.getRuleIndex()) {
//            case TemplateParser.RULE_function :
//                return new FunctionSubtree(node, elType);
//            case TemplateParser.RULE_vardef :
//                return new VardefSubtree(node, elType);
//            case TemplateParser.RULE_formal_arg :
//                return new ArgdefSubtree(node, elType);
//            case TemplateParser.RULE_block :
//                return new BlockSubtree(node);
//            case TemplateParser.RULE_call_expr :
//                return new CallSubtree(node);
            default:
                return new ANTLRPsiNode(node);
        }
    }
}
