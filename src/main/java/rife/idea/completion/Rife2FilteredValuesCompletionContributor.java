package rife.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import org.jetbrains.annotations.NotNull;
import rife.idea.parser.*;

import java.util.ArrayList;
import java.util.List;

public class Rife2FilteredValuesCompletionContributor extends CompletionContributor {
    final static List<LookupElementBuilder> FILTERED_VALUES = new ArrayList<>();

    static {
        FILTERED_VALUES.add(LookupElementBuilder.create("attribute:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("auth:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("context:contId"));
        FILTERED_VALUES.add(LookupElementBuilder.create("context:paramContId"));
        FILTERED_VALUES.add(LookupElementBuilder.create("context:paramRandom"));
        FILTERED_VALUES.add(LookupElementBuilder.create("context:pathInfo"));
        FILTERED_VALUES.add(LookupElementBuilder.create("cookie:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:checkbox:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:display:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:email:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:hidden:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:input:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:radio:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:secret:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:select:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:textarea:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("form:url:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("l10n:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("lang:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("param:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("property:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("render:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("route:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("route:action:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("route:inputs:"));
        FILTERED_VALUES.add(LookupElementBuilder.create("server:rootUrl"));
        FILTERED_VALUES.add(LookupElementBuilder.create("webapp:rootUrl"));
    }

    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        if (parameters.getCompletionType().equals(CompletionType.BASIC) &&
            !parameters.isAutoPopup()) {
            if (PlatformPatterns.psiElement(Rife2ParserDefinitionHtml.CTagName_V).accepts(parameters.getPosition()) &&
                PlatformPatterns.psiElement(Rife2ParserDefinitionHtml.CS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionHtml.TTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionHtml.TS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionJson.CTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionJson.CS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionJson.TTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionJson.TS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionSvg.CTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionSvg.CS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionTxt.TTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionTxt.TS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            } else if (PlatformPatterns.psiElement(Rife2ParserDefinitionSvg.TTagName_V).accepts(parameters.getPosition()) &&
                       PlatformPatterns.psiElement(Rife2ParserDefinitionSvg.TS_V).accepts(parameters.getPosition().getPrevSibling())) {
                result.addAllElements(FILTERED_VALUES);
            }
        }
    }
}
