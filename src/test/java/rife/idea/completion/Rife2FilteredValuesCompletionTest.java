package rife.idea.completion;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import rife.idea.file.Rife2FileTypeHtml;

public class Rife2FilteredValuesCompletionTest extends BasePlatformTestCase {
    public void doBasicTest(String text, String... expected) {
        myFixture.configureByText(Rife2FileTypeHtml.INSTANCE, text);
        myFixture.complete(CompletionType.BASIC);
        assertContainsElements(myFixture.getLookupElementStrings(), expected);
    }

    public void testMissingWhitespace() {
        doBasicTest("<!--v<caret>");
    }

    public void testMissingWhitespaceCompact() {
        doBasicTest("{{v<caret>");
    }

    public void testSimple() {
        doBasicTest("<!--v <caret>",
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

    public void testSimpleCompact() {
        doBasicTest("{{v <caret>",
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

    public void testCompleteTagsWithA() {
        doBasicTest("<!--v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithACompact() {
        doBasicTest("{{v a<caret>", "attribute:", "auth:");
    }

    public void testCompleteTagsWithB() {
        doBasicTest("<!--v b<caret>");
    }

    public void testCompleteTagsWithBCompact() {
        doBasicTest("{{v b<caret>");
    }

    public void testCompleteTagsWithC() {
        doBasicTest("<!--v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithCCompact() {
        doBasicTest("{{v c<caret>",
            "context:contId",
            "context:paramContId",
            "context:paramRandom",
            "context:pathInfo",
            "cookie:");
    }

    public void testCompleteTagsWithD() {
        doBasicTest("<!--v d<caret>");
    }

    public void testCompleteTagsWithDCompact() {
        doBasicTest("{{v d<caret>");
    }

    public void testCompleteTagsWithE() {
        doBasicTest("<!--v e<caret>");
    }

    public void testCompleteTagsWithECompact() {
        doBasicTest("{{v e<caret>");
    }

    public void testCompleteTagsWithF() {
        doBasicTest("<!--v f<caret>",
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

    public void testCompleteTagsWithFCompact() {
        doBasicTest("{{v f<caret>",
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

    public void testCompleteTagsWithG() {
        doBasicTest("<!--v g<caret>");
    }

    public void testCompleteTagsWithGCompact() {
        doBasicTest("{{v g<caret>");
    }

    public void testCompleteTagsWithH() {
        doBasicTest("<!--v h<caret>");
    }

    public void testCompleteTagsWithHCompact() {
        doBasicTest("{{v h<caret>");
    }

    public void testCompleteTagsWithI() {
        doBasicTest("<!--v i<caret>");
    }

    public void testCompleteTagsWithICompact() {
        doBasicTest("{{v i<caret>");
    }

    public void testCompleteTagsWithJ() {
        doBasicTest("<!--v j<caret>");
    }

    public void testCompleteTagsWithJCompact() {
        doBasicTest("{{v j<caret>");
    }

    public void testCompleteTagsWithK() {
        doBasicTest("<!--v k<caret>");
    }

    public void testCompleteTagsWithKCompact() {
        doBasicTest("{{v k<caret>");
    }

    public void testCompleteTagsWithL() {
        doBasicTest("<!--v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithLCompact() {
        doBasicTest("{{v l<caret>",
            "l10n:",
            "lang:");
    }

    public void testCompleteTagsWithM() {
        doBasicTest("<!--v m<caret>");
    }

    public void testCompleteTagsWithMCompact() {
        doBasicTest("{{v m<caret>");
    }

    public void testCompleteTagsWithN() {
        doBasicTest("<!--v n<caret>");
    }

    public void testCompleteTagsWithNCompact() {
        doBasicTest("{{v n<caret>");
    }

    public void testCompleteTagsWithO() {
        doBasicTest("<!--v o<caret>");
    }

    public void testCompleteTagsWithOCompact() {
        doBasicTest("{{v o<caret>");
    }

    public void testCompleteTagsWithP() {
        doBasicTest("<!--v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithPCompact() {
        doBasicTest("{{v p<caret>",
            "param:",
            "property:");
    }

    public void testCompleteTagsWithQ() {
        doBasicTest("<!--v q<caret>");
    }

    public void testCompleteTagsWithQCompact() {
        doBasicTest("{{v q<caret>");
    }

    public void testCompleteTagsWithR() {
        doBasicTest("<!--v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithRCompact() {
        doBasicTest("{{v r<caret>",
            "render:",
            "route:",
            "route:action:",
            "route:inputs:");
    }

    public void testCompleteTagsWithS() {
        doBasicTest("<!--v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithSCompact() {
        doBasicTest("{{v s<caret>",
            "server:rootUrl");
    }

    public void testCompleteTagsWithT() {
        doBasicTest("<!--v t<caret>");
    }

    public void testCompleteTagsWithTCompact() {
        doBasicTest("{{v t<caret>");
    }

    public void testCompleteTagsWithU() {
        doBasicTest("<!--v u<caret>");
    }

    public void testCompleteTagsWithUCompact() {
        doBasicTest("{{v u<caret>");
    }

    public void testCompleteTagsWithV() {
        doBasicTest("<!--v v<caret>");
    }

    public void testCompleteTagsWithVCompact() {
        doBasicTest("{{v v<caret>");
    }

    // TODO
//    public void testCompleteTagsWithW() {
//        doBasicTest("<!--v w<caret>",
//            "webapp:rootUrl");
//    }
//
//    public void testCompleteTagsWithWCompact() {
//        doBasicTest("{{v w<caret>",
//            "webapp:rootUrl");
//    }

    public void testCompleteTagsWithX() {
        doBasicTest("<!--v x<caret>");
    }

    public void testCompleteTagsWithXCompact() {
        doBasicTest("{{v x<caret>");
    }

    public void testCompleteTagsWithY() {
        doBasicTest("<!--v y<caret>");
    }

    public void testCompleteTagsWithYCompact() {
        doBasicTest("{{v y<caret>");
    }

    public void testCompleteTagsWithZ() {
        doBasicTest("<!--v z<caret>");
    }

    public void testCompleteTagsWithZCompact() {
        doBasicTest("{{v z<caret>");
    }
}
