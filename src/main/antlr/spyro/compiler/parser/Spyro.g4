grammar Spyro;

@header {
package spyro.compiler.parser;
}

parse : program EOF ;

program : declVariables declSignatures declRelations? declLanguage declExamples declAssumptions? ;

declVariables : VARIABLES LBRACE declVar+ RBRACE ;

declVar 
 : type ID exGenNote? SEMI	                #declVisibleVar
 | HIDDENVAR type ID exGenNote? SEMI	    #declHiddenVar
 ; 

exGenNote : LARROW ID;

declSignatures : SIGNATURES LBRACE declSig* RBRACE ;

declSig : expr SEMI ;

declRelations : RELATIONS LBRACE declRel+ RBRACE;

declRel: expr  SEMI;

declLanguage : LANGUAGE LBRACE declLanguageRule+ RBRACE ;

declLanguageRule : type ID declNonterminalParam? ARROW (expr ('|' expr)*) SEMI ;

declNonterminalParam : LSQUAR (ID (',' ID)*)? RSQUAR;

declExamples : EXAMPLES LBRACE declExampleRule* RBRACE ;

declExampleRule : type ID ARROW (expr ('|' expr)*) SEMI ;

declAssumptions : ASSUMPTIONS LBRACE declAssumption+ RBRACE ;

declAssumption : expr SEMI ;

type : ID                      #scalarType
     | type LSQUAR INT RSQUAR  #arrayType
     ;

expr
 : LPAREN ID (',' ID)* RPAREN ARROW expr    #anonFuncExpr
 | LPAREN expr RPAREN						#parenExpr
 | ID LPAREN (expr (',' expr)*)? RPAREN		#functionExpr
 | MINUS expr                           	#unaryMinusExpr
 | NOT expr                             	#notExpr
 | expr op=(MULT | DIV | MOD) expr      	#multiplicationExpr
 | expr op=(PLUS | MINUS) expr          	#additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr 	#relationalExpr
 | expr op=(EQ | NEQ) expr              	#equalityExpr
 | expr AND expr                        	#andExpr
 | expr OR expr                         	#orExpr
 | atom                                 	#atomExpr
 | ID LSQUAR (expr (',' expr)*)? RSQUAR		#nontFuncExpr
 ;

atom
 : INT  		 			#numberAtom
 | (TRUE | FALSE)			#booleanAtom
 | ID            			#idAtom
 | NULL          			#nullAtom
 | HOLE			 			#unsizedHoleAtom
 | HOLE LPAREN INT RPAREN	#sizedHoleAtom
 ;

VARIABLES : 'variables';
SIGNATURES : 'signatures';
RELATIONS: 'relations';
LANGUAGE : 'language';
EXAMPLES : 'examples';
ASSUMPTIONS : 'assumptions';

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
NOT : '!';

SEMI : ';';
ASSIGN : '=';
LPAREN : '(';
RPAREN : ')';
LSQUAR : '[';
RSQUAR : ']';
LBRACE : '{';
RBRACE : '}';

ARROW : '->';
LARROW : '<-';

HIDDENVAR : 'hidden';
TRUE : 'true';
FALSE : 'false';
NULL : 'null';
HOLE : '??';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' ~[\r\n]* -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : . 
 ;