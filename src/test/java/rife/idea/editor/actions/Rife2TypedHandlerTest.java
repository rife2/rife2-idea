package rife.idea.editor.actions;

public class Rife2TypedHandlerTest extends Rife2ActionHandlerTest {
    public void testFirstCharTypedCompact() {
        doCharTest('{', "<caret>", "{<caret>}");
    }

    public void testSecondCharTypedCompact() {
        doCharTest('x', "{<caret>}", "{x<caret>}");
        doCharTest('{', "{<caret>}", "{{<caret>}}");
    }

    public void testThirdCharTypedCompact() {
        doCharTest('{', "{{<caret>}}", "{{{<caret>}}");
    }

    public void testFirstCharTyped() {
        doCharTest('<', "<caret>", "<<caret>");
    }

    public void testSecondCharTyped() {
        doCharTest('x', "<<caret>", "<x<caret>");
        doCharTest('!', "<<caret>", "<!--<caret>-->");
    }

    public void testThirdCharTyped() {
        doCharTest('-', "<!--<caret>-->", "<!---<caret>-->");
    }
}
