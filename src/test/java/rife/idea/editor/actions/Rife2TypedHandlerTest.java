package rife.idea.editor.actions;

public class Rife2TypedHandlerTest extends Rife2ActionHandlerTest {
    public void testFirstCharTypedCompactXml() {
        doCharTestXml('{', "<caret>", "{<caret>}");
    }

    public void testFirstCharTypedCompactTxt() {
        doCharTestTxt('{', "<caret>", "{<caret>}");
    }

    public void testSecondCharTypedCompactXml() {
        doCharTestXml('x', "{<caret>}", "{x<caret>}");
        doCharTestXml('{', "{<caret>}", "{{<caret>}}");
    }

    public void testSecondCharTypedCompactTxt() {
        doCharTestTxt('x', "{<caret>}", "{x<caret>}");
        doCharTestTxt('{', "{<caret>}", "{{<caret>}}");
    }

    public void testThirdCharTypedCompactXml() {
        doCharTestXml('{', "{{<caret>}}", "{{{<caret>}}");
    }

    public void testThirdCharTypedCompactTxt() {
        doCharTestTxt('{', "{{<caret>}}", "{{{<caret>}}");
    }

    public void testFirstCharTypedXml() {
        doCharTestXml('<', "<caret>", "<<caret>");
    }

    public void testFirstCharTypedTxt() {
        doCharTestTxt('<', "<caret>", "<<caret>");
    }

    public void testFirstCharTypedJson() {
        doCharTestJson('<', "<caret>", "<<caret>");
    }

    public void testSecondCharTypedXml() {
        doCharTestXml('x', "<<caret>", "<x<caret>");
        doCharTestXml('!', "<<caret>", "<!--<caret>-->");
    }

    public void testSecondCharTypedTxt() {
        doCharTestTxt('x', "<<caret>", "<x<caret>");
        doCharTestTxt('!', "<<caret>", "<!<caret>>");
    }

    public void testSecondCharTypedJson() {
        doCharTestJson('x', "<<caret>", "<x<caret>");
        doCharTestJson('!', "<<caret>", "<!<caret>>");
    }

    public void testThirdCharTypedXml() {
        doCharTestXml('-', "<!--<caret>-->", "<!---<caret>-->");
    }

    public void testThirdCharTypedTxt() {
        doCharTestTxt('-', "<!<caret>>", "<!-<caret>>");
    }

    public void testThirdCharTypedJson() {
        doCharTestJson('-', "<!<caret>>", "<!-<caret>>");
    }
}
