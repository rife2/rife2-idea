parser grammar TemplateParser;
@parser::header {
    package rife.template.antlr;
}

options { tokenVocab=TemplateLexer; }

document        :   blockContent EOF ;

blockContent    :   (blockData|tagI|tagC|tagCLong|tagV|tagVDefault|tagB|tagBV|tagBA)* ;
valueContent    :   (valueData|tagI|tagC|tagCLong|tagB|tagBV|tagBA)*;

tagI        :   TSTART_I TS_I TTagName_I TS_I? TSTERM_I
            |   CSTART_I CS_I CTagName_I TS_I? CSTERM_I
            ;

tagC        :   TSTART_C TS_C? TComment_C? TS_C? TSTERM_C
            |   CSTART_C CS_C? CComment_C? CS_C? CSTERM_C
            ;

tagCLong    :   TSTART_C TS_C? TComment_C? TS_C? TENDI_C TTEXT_C* TCLOSE_C
            |   CSTART_C CS_C? CComment_C? CS_C? CENDI_C CTEXT_C* CCLOSE_C
            ;

tagV        :   TSTART_V TS_V TTagName_V TS_V? TSTERM_V
            |   CSTART_V CS_V CTagName_V CS_V? CSTERM_V
            ;

tagVDefault :   TSTART_V TS_V TTagName_V TS_V? TENDI_V valueContent TCLOSE_V
            |   CSTART_V CS_V CTagName_V CS_V? CENDI_V valueContent CCLOSE_V
            ;

tagB        :   TSTART_B TS_B TTagName_B TS_B? TENDI_B blockContent TCLOSE_B
            |   CSTART_B CS_B CTagName_B CS_B? CENDI_B blockContent CCLOSE_B
            ;

tagBV       :   TSTART_BV TS_B TTagName_B TS_B? TENDI_B blockContent TCLOSE_BV
            |   CSTART_BV CS_B CTagName_B CS_B? CENDI_B blockContent CCLOSE_BV
            ;

tagBA       :   TSTART_BA TS_B TTagName_B TS_B? TENDI_B blockContent TCLOSE_BA
            |   CSTART_BA CS_B CTagName_B CS_B? CENDI_B blockContent CCLOSE_BA
            ;

// Character data in the document not part of the tags
blockData   :   TEXT+;
valueData   :   TEXT+;
