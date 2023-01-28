lexer grammar TemplateLexer;
@lexer::header {
    package rife.template.antlr;

    import rife.template.TemplateConfig;
    import static rife.template.TemplateConfig.*;

}
@lexer::members {
    public TemplateConfig tc = TemplateConfig.XML;
}

// -------------------------------------------------------------------
// MODE: Everything OUTSIDE of a tag

fragment TSTART :   '<!--'  { tc == XML }? | '<!'  { tc == TXT }? ;
fragment TEND   :   '-->'   { tc == XML }? | '>'   { tc == TXT }? ;
fragment TTERM  :   '<!--/' { tc == XML }? | '<!/' { tc == TXT }? ;
fragment STTERM :   '/-->'  { tc == XML }? | '/>'  { tc == TXT }? ;
fragment FTEXT  :   ~[\\<{]+ { tc == XML }?
                |   ~[\\<{]+ { tc == TXT }?
                ;
fragment TTEXT  :   ( ('\\<!--' ('i'|'c'|'v'|'b'|'/'))    { tc == XML }? |
                      ('\\<!'   ('i'|'c'|'v'|'b'|'/'))    { tc == TXT }? )
                |   ( ('<' ~'!' | '<!' ~'-' | '<!-' ~'-') { tc == XML }? |
                      ('<' ~'!')                          { tc == TXT }? )
                |   ( '<!--' ~('i'|'c'|'v'|'b'|'/')       { tc == XML }? |
                      '<!'   ~('i'|'c'|'v'|'b'|'/')       { tc == TXT }? )
                |   ( '<!--/' ~('i'|'c'|'v'|'b')          { tc == XML }? |
                      '<!/'   ~('i'|'c'|'v'|'b')          { tc == TXT }? )
                ;
//fragment TCOMM  :   ( ('\\<!--' ('c'|'/c'))               { tc == XML }? |
//                      ('\\<!'   ('c'|'/c'))               { tc == TXT }? )
//                |   ( ('<' ~'!' | '<!' ~'-' | '<!-' ~'-') { tc == XML }? |
//                      ('<' ~'!')                          { tc == TXT }? )
//                |   ( '<!--' ~('c'|'/')                   { tc == XML }? |
//                      '<!'   ~('c'|'/')                   { tc == TXT }? )
//                |   ( '<!--/' ~('c')                      { tc == XML }? |
//                      '<!/'   ~('c')                      { tc == TXT }? )
//                ;
fragment
TNameComment    :   ( ~[-]+ | '-' ~'-' | '--' ~'>' ) { tc == XML }?
                |   ( ~[>]+ )                        { tc == TXT }?
                ;

fragment I      :   'i' ;
fragment C      :   'c' ;
fragment V      :   'v' ;
fragment B      :   'b' ;
fragment BV     :   'bv' ;
fragment BA     :   'ba' ;

fragment CSTART :   '{{' ;
fragment CEND   :   '}}' ;
fragment CTERM  :   '{{/' ;
fragment CTTERM :   '/}}' ;
fragment CTEXT  :   '\\{{' ('i'|'c'|'v'|'b'|'/')
                |   '{' ~'{'
                |   '{{' ~('i'|'c'|'v'|'b'|'/')
                |   '{{/' ~('i'|'c'|'v'|'b')
                ;
//fragment CCOMM  :   '\\{{' ('c'|'/c')
//                |   '{' ~'{'
//                |   '{{' ~('c'|'/')
//                |   '{{/' ~('c')
//                ;
fragment
CNameComment    :   ~[}]+ | '}' ~'}' ;

fragment DIGIT  :   [0-9] ;

fragment
NameChar    :   NameStartChar
            |   NameEndChar
            |   '-' | '/'
            ;

fragment
NameEndChar :   NameStartChar
            |   '[' | ']' | ',' | '*'
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

fragment
NameStartChar
            :   [:a-zA-Z]
            |   DIGIT | '_' | '.'
            |   '\u2070'..'\u218F'
            |   '\u2C00'..'\u2FEF'
            |   '\u3001'..'\uD7FF'
            |   '\uF900'..'\uFDCF'
            |   '\uFDF0'..'\uFFFD'
            ;

TSTART_I    :   TSTART I                    -> pushMode(TINSIDE_I) ;
CSTART_I    :   CSTART I                    -> pushMode(CINSIDE_I) ;

TCLOSE_C    :   TTERM C TEND ;
TSTART_C    :   TSTART C                    -> pushMode(TINSIDE_C) ;
CCLOSE_C    :   CTERM C CEND ;
CSTART_C    :   CSTART C                    -> pushMode(CINSIDE_C) ;

TCLOSE_V    :   TTERM V TEND ;
TSTART_V    :   TSTART V                    -> pushMode(TINSIDE_V) ;
CCLOSE_V    :   CTERM V CEND ;
CSTART_V    :   CSTART V                    -> pushMode(CINSIDE_V) ;

TCLOSE_B    :   TTERM B TEND ;
TSTART_B    :   TSTART B                    -> pushMode(TINSIDE_B) ;
CCLOSE_B    :   CTERM B CEND ;
CSTART_B    :   CSTART B                    -> pushMode(CINSIDE_B) ;

TCLOSE_BV   :   TTERM BV TEND ;
TSTART_BV   :   TSTART BV                   -> pushMode(TINSIDE_B) ;
CCLOSE_BV   :   CTERM BV CEND ;
CSTART_BV   :   CSTART BV                   -> pushMode(CINSIDE_B) ;

TCLOSE_BA   :   TTERM BA TEND ;
TSTART_BA   :   TSTART BA                   -> pushMode(TINSIDE_B) ;
CCLOSE_BA   :   CTERM BA CEND ;
CSTART_BA   :   CSTART BA                   -> pushMode(CINSIDE_B) ;

TEXT        :   FTEXT
            |   TTEXT
            |   CTEXT
            |   '\\\\'
            |   '\\'
            ;

// Final "catch all" rule to make IDEA happy
ERRCHAR
	:	.	-> channel(HIDDEN)
	;

// -------------------------------------------------------------------
// MODE: Everything INSIDE of a regular include tag

mode TINSIDE_I;

TSTERM_I      :   STTERM                      -> popMode ;
TS_I          :   [ \t\r\n]+ ;
TTagName_I    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
TERRCHAR_I
	:	.	-> channel(HIDDEN)
	;

mode CINSIDE_I;

// -------------------------------------------------------------------
// MODE: Everything INSIDE of a compact include tag

CSTERM_I      :   CTTERM                       -> popMode ;
CS_I          :   [ \t\r\n]+ ;
CTagName_I    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
CERRCHAR_I
	:	.	-> channel(HIDDEN)
	;

// -------------------------------------------------------------------
// MODE: Everything INSIDE of a regular comment tag

mode TINSIDE_C;

TENDI_C       :   TEND                        -> popMode ;
TComment_C    :   TNameComment ;

// Final "catch all" rule to make IDEA happy
TERRCHAR_C
	:	.	-> channel(HIDDEN)
	;

// -------------------------------------------------------------------
// MODE: Everything INSIDE of a compact comment tag

mode CINSIDE_C;

CENDI_C       :   CEND                        -> popMode ;
CComment_C    :   CNameComment ;

// Final "catch all" rule to make IDEA happy
CERRCHAR_C
	:	.	-> channel(HIDDEN)
	;

// -------------------------------------------------------------------
// MODE: Everything INSIDE of a value tag

mode TINSIDE_V;

TENDI_V       :   TEND                        -> popMode ;
TSTERM_V      :   STTERM                      -> popMode ;
TS_V          :   [ \t\r\n]+ ;
TTagName_V    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
TERRCHAR_V
	:	.	-> channel(HIDDEN)
	;


// -------------------------------------------------------------------
// MODE: Everything INSIDE of a compact value tag

mode CINSIDE_V;

CENDI_V       :   CEND                        -> popMode ;
CSTERM_V      :   CTTERM                      -> popMode ;
CS_V          :   [ \t\r\n]+ ;
CTagName_V    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
CERRCHAR_V
	:	.	-> channel(HIDDEN)
	;


// -------------------------------------------------------------------
// MODE: Everything INSIDE of a block tag

mode TINSIDE_B;

TENDI_B       :   TEND                        -> popMode ;
TSTERM_B      :   STTERM                      -> popMode ;
TS_B          :   [ \t\r\n]+ ;
TTagName_B    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
TERRCHAR_B
	:	.	-> channel(HIDDEN)
	;


// -------------------------------------------------------------------
// MODE: Everything INSIDE of a compact block tag

mode CINSIDE_B;

CENDI_B       :   CEND                        -> popMode ;
CSTERM_B      :   CTTERM                      -> popMode ;
CS_B          :   [ \t\r\n]+ ;
CTagName_B    :   NameStartChar | NameStartChar NameChar* NameEndChar ;

// Final "catch all" rule to make IDEA happy
CERRCHAR_B
	:	.	-> channel(HIDDEN)
	;

