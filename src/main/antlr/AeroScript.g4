grammar AeroScript;

@header {
package no.uio.aeroscript.antlr;
}

// Whitespace and comments added
WS           : [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT      : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;

LCURL   : '{';
RCURL   : '}';
LSQUARE : '[';
RSQUARE : ']';
LPAREN  : '(';
RPAREN  : ')';

NEG     : '--';
SEMI    : ';';
COMMA   : ',';
GREATER : '>';
ARROW : '->';

PLUS    : '+';
MINUS   : '-';
TIMES   : '*';

// Define all the elements of the language for the various keywords that you need
RANDOM  : 'random';
POINT   : 'point';

// New keywords
DESCEND_TO_GROUND: 'descend to ground';
RETURN_TO_BASE: 'return to base';
DESCEND_BY: 'descend by';
ASCEND_BY: 'ascend by';
AT_SPEED: 'at speed';
SECONDS: 'seconds';
RIGHT : 'right';
MOVE : 'move';
TURN : 'turn';
LEFT : 'left';
FOR : 'for';
TO : 'to';
BY : 'by';


// Keywords
ID: [a-zA-Z_]+; // Allow underscore in ID
NUMBER: [0-9]+('.'[0-9]+)?;

// Entry point
// Comment: Excecution and mode is being used around eachother
program : (execution)+ ; 
execution : ARROW? ID LCURL (statement)* RCURL (ARROW ID)?;

statement : action;
action : (acDock
        | acMove
        | acTurn
        | acAscend
        | acDescend)
        ((FOR expression SECONDS) | (AT_SPEED expression))?
;

// Executions / modes
acDock : RETURN_TO_BASE;
acMove : MOVE ( TO POINT point | BY NUMBER );
acTurn : TURN ( RIGHT | LEFT )? BY expression;
acAscend : ASCEND_BY expression;
acDescend : DESCEND_BY expression | DESCEND_TO_GROUND;

// From oblig 1
expression : NEG expression #NegExp
            | left = expression TIMES right = expression #TimesExp
            | left = expression PLUS right = expression #PlusExp
            | left = expression MINUS right = expression #MinusExp
            | NUMBER #NumExp
            | RANDOM range #RangeExp
            | POINT point #PointExp
            | LPAREN expression RPAREN #ParentExp
            ;

point : LPAREN left = expression COMMA right = expression RPAREN ;
range : LSQUARE left = expression COMMA right = expression RSQUARE ;