parser grammar TemplateParser;
@parser::header {
    package rife.template.antlr;
}

options { tokenVocab=TemplateLexer; }

document        :   blockContent EOF ;

blockContent    :   (blockData|tagI|tagC|tagV|tagVDefault|tagB|tagBV|tagBA)* ;
valueContent    :   (valueData|tagI|tagC|tagB|tagBV|tagBA)*;

tagI        :   TSTART_I TS_I TTagName_I TS_I? TSTERM_I
            |   CSTART_I CS_I CTagName_I TS_I? CSTERM_I
            ;

tagC        :   TSTART_C TComment_C? TENDI_C commentData* TCLOSE_C
            |   CSTART_C CComment_C? CENDI_C commentData* CCLOSE_C
            ;

tagV        :   TSTART_V TS TTagName TS? TSTERM
            |   CSTART_V CS CTagName CS? CSTERM
            ;

tagVDefault :   TSTART_V TS TTagName TS? TENDI valueContent TCLOSE_V
            |   CSTART_V CS CTagName CS? CENDI valueContent CCLOSE_V
            ;

tagB        :   TSTART_B TS TTagName TS? TENDI blockContent TCLOSE_B
            |   CSTART_B CS CTagName CS? CENDI blockContent CCLOSE_B
            ;

tagBV       :   TSTART_BV TS TTagName TS? TENDI blockContent TCLOSE_BV
            |   CSTART_BV CS CTagName CS? CENDI blockContent CCLOSE_BV
            ;

tagBA       :   TSTART_BA TS TTagName TS? TENDI blockContent TCLOSE_BA
            |   CSTART_BA CS CTagName CS? CENDI blockContent CCLOSE_BA
            ;

// Character data in the document not part of the tags
blockData   :   TEXT+;
valueData   :   TEXT+;
commentData :   TEXT+;
