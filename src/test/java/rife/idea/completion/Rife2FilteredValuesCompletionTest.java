package rife.idea.completion;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.util.containers.ContainerUtil;
import rife.idea.file.*;

public class Rife2FilteredValuesCompletionTest extends BasePlatformTestCase {
    public void doBasicTestXml(String text, String... expected) {
        myFixture.configureByText(Rife2FileTypeHtml.INSTANCE, text);
        var result1 = myFixture.complete(CompletionType.BASIC);
        assertContainsElements(ContainerUtil.map(result1, LookupElement::getLookupString), expected);

        myFixture.configureByText(Rife2FileTypeSvg.INSTANCE, text);
        var result2 = myFixture.complete(CompletionType.BASIC);
        assertContainsElements(ContainerUtil.map(result2, LookupElement::getLookupString), expected);

        myFixture.configureByText(Rife2FileTypeXml.INSTANCE, text);
        var result3 = myFixture.complete(CompletionType.BASIC);
        assertContainsElements(ContainerUtil.map(result3, LookupElement::getLookupString), expected);
    }

    public void doBasicTestTxt(String text, String... expected) {
        myFixture.configureByText(Rife2FileTypeJson.INSTANCE, text);
        var result1 = myFixture.complete(CompletionType.BASIC);
        assertContainsElements(ContainerUtil.map(result1, LookupElement::getLookupString), expected);

        myFixture.configureByText(Rife2FileTypeTxt.INSTANCE, text);
        var result2 = myFixture.complete(CompletionType.BASIC);
        assertContainsElements(ContainerUtil.map(result2, LookupElement::getLookupString), expected);
    }

    public void testMissingWhitespaceXml() {
        doBasicTestXml("<!--v<caret>");
    }

    public void testMissingWhitespaceTxt() {
        doBasicTestTxt("<!v<caret>");
    }

    public void testMissingWhitespaceCompactXml() {
        doBasicTestXml("{{v<caret>");
    }

    public void testMissingWhitespaceCompactTxt() {
        doBasicTestTxt("{{v<caret>");
    }

    public void testSimpleXml() {
        doBasicTestXml("<!--v <caret>",
            "attribute:",
            "auth:",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:",
            "l10n:",
            "lang:",
            "param:",
            "property:",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:",
            "server:rootUrl",
            "webapp:rootUrl");
    }

    public void testSimpleTxt() {
        doBasicTestTxt("<!v <caret>",
            "attribute:",
            "auth:",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:",
            "l10n:",
            "lang:",
            "param:",
            "property:",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:",
            "server:rootUrl",
            "webapp:rootUrl");
    }

    public void testSimpleCompactXml() {
        doBasicTestXml("{{v <caret>",
            "attribute:",
            "auth:",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:",
            "l10n:",
            "lang:",
            "param:",
            "property:",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:",
            "server:rootUrl",
            "webapp:rootUrl");
    }

    public void testSimpleCompactTxt() {
        doBasicTestTxt("{{v <caret>",
            "attribute:",
            "auth:",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:",
            "l10n:",
            "lang:",
            "param:",
            "property:",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:",
            "server:rootUrl",
            "webapp:rootUrl");
    }

    public void testCompleteTagsWithAXml() {
        doBasicTestXml("<!--v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithATxt() {
        doBasicTestTxt("<!v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithACompactXml() {
        doBasicTestXml("{{v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithACompactTxt() {
        doBasicTestTxt("{{v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithBXml() {
        doBasicTestXml("<!--v b<caret>");
    }

    public void testCompleteTagsWithBTxt() {
        doBasicTestTxt("<!v b<caret>");
    }

    public void testCompleteTagsWithBCompactXml() {
        doBasicTestXml("{{v b<caret>");
    }

    public void testCompleteTagsWithBCompactTxt() {
        doBasicTestTxt("{{v b<caret>");
    }

    public void testCompleteTagsWithCXml() {
        doBasicTestXml("<!--v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithCTxt() {
        doBasicTestTxt("<!v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithCCompactXml() {
        doBasicTestXml("{{v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithCCompactTxt() {
        doBasicTestTxt("{{v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithDXml() {
        doBasicTestXml("<!--v d<caret>");
    }

    public void testCompleteTagsWithDTxt() {
        doBasicTestTxt("<!v d<caret>");
    }

    public void testCompleteTagsWithDCompactXml() {
        doBasicTestXml("{{v d<caret>");
    }

    public void testCompleteTagsWithDCompactTxt() {
        doBasicTestTxt("{{v d<caret>");
    }

    public void testCompleteTagsWithEXml() {
        doBasicTestXml("<!--v e<caret>");
    }

    public void testCompleteTagsWithETxt() {
        doBasicTestTxt("<!v e<caret>");
    }

    public void testCompleteTagsWithECompactXml() {
        doBasicTestXml("{{v e<caret>");
    }

    public void testCompleteTagsWithECompactTxt() {
        doBasicTestTxt("{{v e<caret>");
    }

    public void testCompleteTagsWithFXml() {
        doBasicTestXml("<!--v f<caret>",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:");
    }

    public void testCompleteTagsWithFTxt() {
        doBasicTestTxt("<!v f<caret>",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:");
    }

    public void testCompleteTagsWithFCompactXml() {
        doBasicTestXml("{{v f<caret>",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:");
    }

    public void testCompleteTagsWithFCompactTxt() {
        doBasicTestTxt("{{v f<caret>",
            "form:checkbox:",
            "form:display:",
            "form:email:",
            "form:hidden:",
            "form:input:",
            "form:radio:",
            "form:secret:",
            "form:select:",
            "form:textarea:",
            "form:url:");
    }

    public void testCompleteTagsWithGXml() {
        doBasicTestXml("<!--v g<caret>");
    }

    public void testCompleteTagsWithGTxt() {
        doBasicTestTxt("<!v g<caret>");
    }

    public void testCompleteTagsWithGCompactXml() {
        doBasicTestXml("{{v g<caret>");
    }

    public void testCompleteTagsWithGCompactTxt() {
        doBasicTestTxt("{{v g<caret>");
    }

    public void testCompleteTagsWithHXml() {
        doBasicTestXml("<!--v h<caret>");
    }

    public void testCompleteTagsWithHTxt() {
        doBasicTestTxt("<!v h<caret>");
    }

    public void testCompleteTagsWithHCompactXml() {
        doBasicTestXml("{{v h<caret>");
    }

    public void testCompleteTagsWithHCompactTxt() {
        doBasicTestTxt("{{v h<caret>");
    }

    public void testCompleteTagsWithIXml() {
        doBasicTestXml("<!--v i<caret>");
    }

    public void testCompleteTagsWithITxt() {
        doBasicTestTxt("<!v i<caret>");
    }

    public void testCompleteTagsWithICompactXml() {
        doBasicTestXml("{{v i<caret>");
    }

    public void testCompleteTagsWithICompactTxt() {
        doBasicTestTxt("{{v i<caret>");
    }

    public void testCompleteTagsWithJXml() {
        doBasicTestXml("<!--v j<caret>");
    }

    public void testCompleteTagsWithJTxt() {
        doBasicTestTxt("<!v j<caret>");
    }

    public void testCompleteTagsWithJCompactXml() {
        doBasicTestXml("{{v j<caret>");
    }

    public void testCompleteTagsWithJCompactTxt() {
        doBasicTestTxt("{{v j<caret>");
    }

    public void testCompleteTagsWithKXml() {
        doBasicTestXml("<!--v k<caret>");
    }

    public void testCompleteTagsWithKTxt() {
        doBasicTestTxt("<!v k<caret>");
    }

    public void testCompleteTagsWithKCompactXml() {
        doBasicTestXml("{{v k<caret>");
    }

    public void testCompleteTagsWithKCompactTxt() {
        doBasicTestTxt("{{v k<caret>");
    }

    public void testCompleteTagsWithLXml() {
        doBasicTestXml("<!--v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithLTxt() {
        doBasicTestTxt("<!v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithLCompactXml() {
        doBasicTestXml("{{v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithLCompactTxt() {
        doBasicTestTxt("{{v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithMXml() {
        doBasicTestXml("<!--v m<caret>");
    }

    public void testCompleteTagsWithMTxt() {
        doBasicTestTxt("<!v m<caret>");
    }

    public void testCompleteTagsWithMCompactXml() {
        doBasicTestXml("{{v m<caret>");
    }

    public void testCompleteTagsWithMCompactTxt() {
        doBasicTestTxt("{{v m<caret>");
    }

    public void testCompleteTagsWithNXml() {
        doBasicTestXml("<!--v n<caret>");
    }

    public void testCompleteTagsWithNTxt() {
        doBasicTestTxt("<!v n<caret>");
    }

    public void testCompleteTagsWithNCompactXml() {
        doBasicTestXml("{{v n<caret>");
    }

    public void testCompleteTagsWithNCompactTxt() {
        doBasicTestTxt("{{v n<caret>");
    }

    public void testCompleteTagsWithOXml() {
        doBasicTestXml("<!--v o<caret>");
    }

    public void testCompleteTagsWithOTxt() {
        doBasicTestTxt("<!v o<caret>");
    }

    public void testCompleteTagsWithOCompactXml() {
        doBasicTestXml("{{v o<caret>");
    }

    public void testCompleteTagsWithOCompactTxt() {
        doBasicTestTxt("{{v o<caret>");
    }

    public void testCompleteTagsWithPXml() {
        doBasicTestXml("<!--v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithPTxt() {
        doBasicTestTxt("<!v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithPCompactXml() {
        doBasicTestXml("{{v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithPCompactTxt() {
        doBasicTestTxt("{{v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithQXml() {
        doBasicTestXml("<!--v q<caret>");
    }

    public void testCompleteTagsWithQTxt() {
        doBasicTestTxt("<!v q<caret>");
    }

    public void testCompleteTagsWithQCompactXml() {
        doBasicTestXml("{{v q<caret>");
    }

    public void testCompleteTagsWithQCompactTxt() {
        doBasicTestTxt("{{v q<caret>");
    }

    public void testCompleteTagsWithRXml() {
        doBasicTestXml("<!--v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithRTxt() {
        doBasicTestTxt("<!v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithRCompactXml() {
        doBasicTestXml("{{v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithRCompactTxt() {
        doBasicTestTxt("{{v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithSXml() {
        doBasicTestXml("<!--v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithSTxt() {
        doBasicTestTxt("<!v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithSCompactXml() {
        doBasicTestXml("{{v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithSCompactTxt() {
        doBasicTestTxt("{{v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithTXml() {
        doBasicTestXml("<!--v t<caret>");
    }

    public void testCompleteTagsWithTTxt() {
        doBasicTestTxt("<!v t<caret>");
    }

    public void testCompleteTagsWithTCompactXml() {
        doBasicTestXml("{{v t<caret>");
    }

    public void testCompleteTagsWithTCompactTxt() {
        doBasicTestTxt("{{v t<caret>");
    }

    public void testCompleteTagsWithUXml() {
        doBasicTestXml("<!--v u<caret>");
    }

    public void testCompleteTagsWithUTxt() {
        doBasicTestTxt("<!v u<caret>");
    }

    public void testCompleteTagsWithUCompactXml() {
        doBasicTestXml("{{v u<caret>");
    }

    public void testCompleteTagsWithUCompactTxt() {
        doBasicTestTxt("{{v u<caret>");
    }

    public void testCompleteTagsWithVXml() {
        doBasicTestXml("<!--v v<caret>");
    }

    public void testCompleteTagsWithVTxt() {
        doBasicTestTxt("<!v v<caret>");
    }

    public void testCompleteTagsWithVCompactXml() {
        doBasicTestXml("{{v v<caret>");
    }

    public void testCompleteTagsWithVCompactTxt() {
        doBasicTestTxt("{{v v<caret>");
    }

    // TODO : not sure why this is failing
//    public void testCompleteTagsWithWXml() {
//        doBasicTestXml("<!--v w<caret>",
//            "webapp:rootUrl");
//    }
//
//    public void testCompleteTagsWithWCompactXml() {
//        doBasicTestXml("{{v w<caret>",
//            "webapp:rootUrl");
//    }

    public void testCompleteTagsWithXXml() {
        doBasicTestXml("<!--v x<caret>");
    }
    public void testCompleteTagsWithXTxt() {
        doBasicTestTxt("<!v x<caret>");
    }

    public void testCompleteTagsWithXCompactXml() {
        doBasicTestXml("{{v x<caret>");
    }

    public void testCompleteTagsWithXCompactTxt() {
        doBasicTestTxt("{{v x<caret>");
    }

    public void testCompleteTagsWithYXml() {
        doBasicTestXml("<!--v y<caret>");
    }

    public void testCompleteTagsWithYTxt() {
        doBasicTestTxt("<v y<caret>");
    }

    public void testCompleteTagsWithYCompactXml() {
        doBasicTestXml("{{v y<caret>");
    }

    public void testCompleteTagsWithYCompactTxt() {
        doBasicTestTxt("{{v y<caret>");
    }

    public void testCompleteTagsWithZXml() {
        doBasicTestXml("<!--v z<caret>");
    }

    public void testCompleteTagsWithZTxt() {
        doBasicTestTxt("<!v z<caret>");
    }

    public void testCompleteTagsWithZCompactXml() {
        doBasicTestXml("{{v z<caret>");
    }

    public void testCompleteTagsWithZCompactTxt() {
        doBasicTestTxt("{{v z<caret>");
    }
}
