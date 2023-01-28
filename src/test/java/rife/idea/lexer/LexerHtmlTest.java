package rife.idea.lexer;

import org.junit.Test;
import rife.idea.parser.Rife2LexerHtml;

import static rife.idea.parser.Rife2ParserDefinitionHtml.*;

public class LexerHtmlTest extends LexerTest {
    public LexerHtmlTest() {
        super(new Rife2LexerHtml());
    }

    @Test
    public void regular_includes() {
        givenInput("<!--i name/-->");
        thenTokensAre(
            TSTART_I, "<!--i",
            TS_I, " ",
            TTagName_I, "name",
            TSTERM_I, "/-->"
        );
    }

    @Test
    public void compact_includes() {
        givenInput("{{i name/}}");
        thenTokensAre(
            CSTART_I, "{{i",
            CS_I, " ",
            CTagName_I, "name",
            CSTERM_I, "/}}"
        );
    }

    @Test
    public void regular_short_comments() {
        givenInput("<!--c comment/-->");
        thenTokensAre(
            TSTART_C, "<!--c",
            TS_C, " ",
            TComment_C, "comment",
            TSTERM_C, "/-->"
        );
    }

    @Test
    public void regular_long_comments() {
        givenInput("<!--c comment-->commented<!--/c-->");
        thenTokensAre(
            TSTART_C, "<!--c",
            TS_C, " ",
            TComment_C, "comment",
            TENDI_C, "-->",
            TTEXT_C, "commented",
            TCLOSE_C, "<!--/c-->"
        );
    }

    @Test
    public void compact_short_comments() {
        givenInput("{{c comment/}}");
        thenTokensAre(
            CSTART_C, "{{c",
            CS_C, " ",
            CComment_C, "comment",
            CSTERM_C, "/}}"
        );
    }

    @Test
    public void compact_long_comments() {
        givenInput("{{c comment}}commented{{/c}}");
        thenTokensAre(
            CSTART_C, "{{c",
            CS_C, " ",
            CComment_C, "comment",
            CENDI_C, "}}",
            CTEXT_C, "commented",
            CCLOSE_C, "{{/c}}"
        );
    }

    @Test
    public void regular_short_comments_noname() {
        givenInput("<!--c/-->");
        thenTokensAre(
            TSTART_C, "<!--c",
            TSTERM_C, "/-->"
        );
    }

    @Test
    public void regular_long_comments_noname() {
        givenInput("<!--c-->commented<!--/c-->");
        thenTokensAre(
            TSTART_C, "<!--c",
            TENDI_C, "-->",
            TTEXT_C, "commented",
            TCLOSE_C, "<!--/c-->"
        );
    }

    @Test
    public void compact_short_comments_noname() {
        givenInput("{{c/}}");
        thenTokensAre(
            CSTART_C, "{{c",
            CSTERM_C, "/}}"
        );
    }

    @Test
    public void compact_long_comments_noname() {
        givenInput("{{c}}commented{{/c}}");
        thenTokensAre(
            CSTART_C, "{{c",
            CENDI_C, "}}",
            CTEXT_C, "commented",
            CCLOSE_C, "{{/c}}"
        );
    }

    @Test
    public void regular_short_values() {
        givenInput("<!--v name/-->");
        thenTokensAre(
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "name",
            TSTERM_V, "/-->"
        );
    }

    @Test
    public void regular_long_values() {
        givenInput("<!--v name-->default<!--/v-->");
        thenTokensAre(
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "name",
            TENDI_V, "-->",
            TEXT, "default",
            TCLOSE_V, "<!--/v-->"
        );
    }

    @Test
    public void compact_short_values() {
        givenInput("{{v name/}}");
        thenTokensAre(
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "name",
            CSTERM_V, "/}}"
        );
    }

    @Test
    public void compact_long_values() {
        givenInput("{{v name}}default{{/v}}");
        thenTokensAre(
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "name",
            CENDI_V, "}}",
            TEXT, "default",
            CCLOSE_V, "{{/v}}"
        );
    }

    @Test
    public void regular_blocks() {
        givenInput("<!--b name-->content<!--/b-->");
        thenTokensAre(
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content",
            TCLOSE_B, "<!--/b-->"
        );
    }

    @Test
    public void compact_blocks() {
        givenInput("{{b name}}content{{/b}}");
        thenTokensAre(
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content",
            CCLOSE_B, "{{/b}}"
        );
    }

    @Test
    public void regular_blockvalues() {
        givenInput("<!--bv name-->content<!--/bv-->");
        thenTokensAre(
            TSTART_BV, "<!--bv",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content",
            TCLOSE_BV, "<!--/bv-->"
        );
    }

    @Test
    public void compact_blockvalues() {
        givenInput("{{bv name}}content{{/bv}}");
        thenTokensAre(
            CSTART_BV, "{{bv",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content",
            CCLOSE_BV, "{{/bv}}"
        );
    }

    @Test
    public void regular_blockappends() {
        givenInput("<!--ba name-->content<!--/ba-->");
        thenTokensAre(
            TSTART_BA, "<!--ba",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content",
            TCLOSE_BA, "<!--/ba-->"
        );
    }

    @Test
    public void compact_blockappends() {
        givenInput("{{ba name}}content{{/ba}}");
        thenTokensAre(
            CSTART_BA, "{{ba",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content",
            CCLOSE_BA, "{{/ba}}"
        );
    }

    @Test
    public void values_in_regular_blocks() {
        givenInput("<!--b name-->content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "<!--/b-->");
        thenTokensAre(
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            TCLOSE_B, "<!--/b-->"
        );
    }

    @Test
    public void values_in_compact_blocks() {
        givenInput("{{b name}}content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "{{/b}}");
        thenTokensAre(
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            CCLOSE_B, "{{/b}}"
        );
    }

    @Test
    public void values_in_regular_blockvalues() {
        givenInput("<!--bv name-->content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "<!--/bv-->");
        thenTokensAre(
            TSTART_BV, "<!--bv",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            TCLOSE_BV, "<!--/bv-->"
        );
    }

    @Test
    public void values_in_compact_blockvalues() {
        givenInput("{{bv name}}content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "{{/bv}}");
        thenTokensAre(
            CSTART_BV, "{{bv",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            CCLOSE_BV, "{{/bv}}"
        );
    }

    @Test
    public void values_in_regular_blockappends() {
        givenInput("<!--ba name-->content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "<!--/ba-->");
        thenTokensAre(
            TSTART_BA, "<!--ba",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            TCLOSE_BA, "<!--/ba-->"
        );
    }

    @Test
    public void values_in_compact_blockappends() {
        givenInput("{{ba name}}content1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "{{/ba}}");
        thenTokensAre(
            CSTART_BA, "{{ba",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content1 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value1",
            TENDI_V, "-->",
            TEXT, "default1",
            TCLOSE_V, "<!--/v-->",
            TEXT, " content2 ",
            TSTART_V, "<!--v",
            TS_V, " ",
            TTagName_V, "value2",
            TSTERM_V, "/-->",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value3",
            CENDI_V, "}}",
            TEXT, "default3",
            CCLOSE_V, "{{/v}}",
            TEXT, " content3 ",
            CSTART_V, "{{v",
            CS_V, " ",
            CTagName_V, "value4",
            CSTERM_V, "/}}",
            CCLOSE_BA, "{{/ba}}"
        );
    }


    @Test
    public void values_in_regular_long_comments() {
        givenInput("<!--c comment-->commented1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "<!--/c-->");
        thenTokensAre(
            TSTART_C, "<!--c",
            TS_C, " ",
            TComment_C, "comment",
            TENDI_C, "-->",
            TTEXT_C, "commented1 ",
            TTEXT_C, "<!--v",
            TTEXT_C, " value1-->default1",
            TTEXT_C, "<!--/v",
            TTEXT_C, "--> content2 ",
            TTEXT_C, "<!--v",
            TTEXT_C, " value2/-->{{v value3}}default3{{/v}} content3 " +
                     "{{v value4/}}",
            TCLOSE_C, "<!--/c-->"
        );
    }

    @Test
    public void values_in_compact_long_comments() {
        givenInput("{{c comment}}commented1 " +
                   "<!--v value1-->default1<!--/v--> content2 " +
                   "<!--v value2/-->" +
                   "{{v value3}}default3{{/v}} content3 " +
                   "{{v value4/}}" +
                   "{{/c}}");
        thenTokensAre(
            CSTART_C, "{{c",
            CS_C, " ",
            CComment_C, "comment",
            CENDI_C, "}}",
            CTEXT_C, "commented1 " +
                     "<!--v value1-->default1<!--/v--> content2 " +
                     "<!--v value2/-->",
            CTEXT_C, "{{v",
            CTEXT_C, " value3}}default3",
            CTEXT_C, "{{/v",
            CTEXT_C, "}} content3 ",
            CTEXT_C, "{{v",
            CTEXT_C, " value4/}}",
            CCLOSE_C, "{{/c}}"
        );
    }

    @Test
    public void blocks_in_regular_blocks() {
        givenInput("<!--b name-->content1 " +
                   "<!--b block1-->content2<!--/b--> content3 " +
                   "<!--b block2/-->" +
                   "{{b block3}}content4{{/b}} content5 " +
                   "{{b block4/}}" +
                   "<!--/b-->");
        thenTokensAre(
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "name",
            TENDI_B, "-->",
            TEXT, "content1 ",
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "block1",
            TENDI_B, "-->",
            TEXT, "content2",
            TCLOSE_B, "<!--/b-->",
            TEXT, " content3 ",
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "block2",
            TSTERM_B, "/-->",
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "block3",
            CENDI_B, "}}",
            TEXT, "content4",
            CCLOSE_B, "{{/b}}",
            TEXT, " content5 ",
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "block4",
            CSTERM_B, "/}}",
            TCLOSE_B, "<!--/b-->"
        );
    }

    @Test
    public void blocks_in_compact_blocks() {
        givenInput("{{b name}}content1 " +
                   "<!--b block1-->content2<!--/b--> content3 " +
                   "<!--b block2/-->" +
                   "{{b block3}}content4{{/b}} content5 " +
                   "{{b block4/}}" +
                   "{{/b}}");
        thenTokensAre(
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "name",
            CENDI_B, "}}",
            TEXT, "content1 ",
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "block1",
            TENDI_B, "-->",
            TEXT, "content2",
            TCLOSE_B, "<!--/b-->",
            TEXT, " content3 ",
            TSTART_B, "<!--b",
            TS_B, " ",
            TTagName_B, "block2",
            TSTERM_B, "/-->",
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "block3",
            CENDI_B, "}}",
            TEXT, "content4",
            CCLOSE_B, "{{/b}}",
            TEXT, " content5 ",
            CSTART_B, "{{b",
            CS_B, " ",
            CTagName_B, "block4",
            CSTERM_B, "/}}",
            CCLOSE_B, "{{/b}}"
        );
    }
}
