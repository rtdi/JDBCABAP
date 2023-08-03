grammar SqlAbap;
options { caseInsensitive = true; }

SCOL:      ';';
DOT:       '.';
OPEN_PAR:  '(';
CLOSE_PAR: ')';
COMMA:     ',';
STAR:      '*';
PLUS:      '+';
MINUS:     '-';
PIPE2:     '||';
DIV:       '/';
MOD:       '%';
LT:        '<';
LT_EQ:     '<=';
GT:        '>';
GT_EQ:     '>=';
EQ:        '=';
NOT_EQ:    '<>';

AND_:               'AND';
AS_:                'AS';
ASC_:               'ASC';
BETWEEN_:           'BETWEEN';
BY_:                'BY';
CASE_:              'CASE';
COLUMN_:            'COLUMN';
COMMIT_:            'COMMIT';
CREATE_:            'CREATE';
CURRENT_DATE_:      'CURRENT_DATE';
CURRENT_TIME_:      'CURRENT_TIME';
CURRENT_TIMESTAMP_: 'CURRENT_TIMESTAMP';
DESC_:              'DESC';
DISTINCT_:          'DISTINCT';
ELSE_:              'ELSE';
END_:               'END';
FOR_:               'FOR';
FROM_:              'FROM';
FULL_:              'FULL';
GROUP_:             'GROUP';
HAVING_:            'HAVING';
IF_:                'IF';
IN_:                'IN';
INNER_:             'INNER';
IS_:                'IS';
ISNULL_:            'ISNULL';
JOIN_:              'JOIN';
KEY_:               'KEY';
LEFT_:              'LEFT';
LIKE_:              'LIKE';
LIMIT_:             'LIMIT';
NOT_:               'NOT';
NULL_:              'NULL';
OFFSET_:            'OFFSET';
ON_:                'ON';
OR_:                'OR';
ORDER_:             'ORDER';
OUTER_:             'OUTER';
RIGHT_:             'RIGHT';
ROLLBACK_:          'ROLLBACK';
SELECT_:            'SELECT';
THEN_:              'THEN';
WHEN_:              'WHEN';
WHERE_:             'WHERE';

IDENTIFIER:
    '"' (~'"' | '""')* '"'
    | '`' (~'`' | '``')* '`'
    | '[' ~']'* ']'
    | [A-Z_] [A-Z_0-9]*
;

NUMERIC_LITERAL: ((DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+)) ('E' [-+]? DIGIT+)? | '0x' HEX_DIGIT+;

STRING_LITERAL: '\'' ( ~'\'' | '\'\'')* '\'' | '?';

BLOB_LITERAL: 'X' STRING_LITERAL;

SINGLE_LINE_COMMENT: '--' ~[\r\n]* (('\r'? '\n') | EOF) -> channel(HIDDEN);

MULTILINE_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

SPACES: [ \u000B\t\r\n] -> channel(HIDDEN);

UNEXPECTED_CHAR: .;

fragment HEX_DIGIT: [0-9A-F];
fragment DIGIT:     [0-9];



sql_stmt: (
        | commitstmt
        | rollbackstmt
        | selectstmt
    )
;

commitstmt: COMMIT_
;

rollbackstmt:
    ROLLBACK_
;

signednumber: (PLUS | MINUS)? NUMERIC_LITERAL
;

expr:
    exprconstantnum
    | exprconstantstring
    | exprnull
    | (tablename DOT)? columnname
;

exprconstantstring:
    STRING_LITERAL
;

exprconstantnum:
    NUMERIC_LITERAL
;

exprnull:
    NULL_
;

whereclause:
    wherecondition (whereandorop wherecondition) *
;

whereandorop:
    (AND_ | OR_ )
;

whereop:
    ( EQ | NOT_EQ | LT | 
    LT_EQ | GT | GT_EQ |
    NOT_? LIKE_)
;

wherecondition:
    whereconditionbrackets
    | whereconditioncomp
;

whereconditioncomp:
    whereexprl whereop whereexprr
;

whereconditionbrackets:
    OPEN_PAR whereclause CLOSE_PAR
;

whereexprl:
    wherevaluel
    | (wheretablenamel DOT)? wherecolumnnamel
;

whereexprr:
    wherevaluer
    | (wheretablenamer DOT)? wherecolumnnamer
;

wheretablenamel:
    any_name
;

wherecolumnnamel:
    any_name
;

wheretablenamer:
    any_name
;

wherecolumnnamer:
    any_name
;

exprlimit:
    NUMERIC_LITERAL
;

exproffset:
    NUMERIC_LITERAL
;

literalvalue:
    NUMERIC_LITERAL
    | STRING_LITERAL
;

wherevaluel:
    NUMERIC_LITERAL
    | STRING_LITERAL
;

wherevaluer:
    NUMERIC_LITERAL
    | STRING_LITERAL
;

selectstmt:
    selectcore orderbystmt? limitstmt?
;

joinclause:
    tableclause (joinoperator tableclause joinconstraint?)*
;

tableclause:
        tablename (AS_? tablealias)? 
;

selectcore:
    (
        SELECT_ DISTINCT_? resultcolumn (COMMA resultcolumn)* (
            FROM_ (tableclause (COMMA tableclause)* | joinclause)
        )? (WHERE_ whereclause)?
    )
;

simpleselectstmt:
    selectcore orderbystmt? limitstmt?
;

starcolumn:
	STAR
;

resultcolumn:
    starcolumn
    | tablename DOT starcolumn
    | expr ( AS_? columnalias)?
;

joinoperator:
    COMMA
    | (LEFT_ OUTER_? | INNER_ )? JOIN_
;

joinconstraint:
    ON_ expr
;

qualifiedtablename: tablename (AS_ alias)?
;

orderbystmt:
    ORDER_ BY_ orderingterm (COMMA orderingterm)*
;

limitstmt:
    LIMIT_ exprlimit (OFFSET_ exproffset)?
;

orderingterm:
    expr ascdesc?
;

ascdesc:
    ASC_
    | DESC_
;

initialselect:
    selectstmt
;

unaryoperator:
    MINUS
    | PLUS
    | NOT_
;

columnalias:
    IDENTIFIER
    | STRING_LITERAL
;

keyword:
    | AND_
    | AS_
    | ASC_
    | BETWEEN_
    | BY_
    | CASE_
    | COLUMN_
    | COMMIT_
    | CREATE_
    | CURRENT_DATE_
    | CURRENT_TIME_
    | CURRENT_TIMESTAMP_
    | DESC_
    | DISTINCT_
    | ELSE_
    | END_
    | FOR_
    | FROM_
    | FULL_
    | GROUP_
    | HAVING_
    | IF_
    | IN_
    | INNER_
    | IS_
    | ISNULL_
    | JOIN_
    | KEY_
    | LEFT_
    | LIKE_
    | LIMIT_
    | NOT_
    | NULL_
    | OFFSET_
    | ON_
    | OR_
    | ORDER_
    | OUTER_
    | RIGHT_
    | ROLLBACK_
    | SELECT_
    | THEN_
    | WHEN_
    | WHERE_
;

name:
    any_name
;

tablename:
    any_name
;

columnname:
    any_name
;

tablealias:
    any_name
;

alias:
    any_name
;

any_name:
    IDENTIFIER
    | STRING_LITERAL
    | OPEN_PAR any_name CLOSE_PAR
;