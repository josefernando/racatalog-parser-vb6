grammar Vb6;

//@parser::header {
//  package br.com.arcatalog.parser.vb6; 
//}

//@lexer::header { 
//  package br.com.arcatalog.parser.vb6; 
//}

@lexer::members {
 public static final int HIDDEN_WHITESPACE = 2; //Especificar "1" e não "HIDDEN_WHITESPACE" ERRO a ser corrigido
 public static final int HIDDEN_COMMENT = 3;
 
 public static boolean startOfLine = true;
 public static boolean insideUIProperty = false;
}

options { language = Java ;}

//tokens {  IDENTIFIER
//         ,FLOAT }

startRule : module EOF?
 ;

module : ( section | endOfLine | endOfFile )+ 
	;

section :
	  metadata         
//	| definition
	| declaration
//	| stmt
	| expr				
	;

metadata : 
	  version            
	| optionStmt       
	| attributeStmt       
	;
	
version :
	VERSION  FLOAT  CLASS?	;
	
optionStmt : 
	  OPTION_BASE			
	| OPTION_COMPARE  (BINARY | TEXT) 	    
	| OPTION_EXPLICIT 	
	| OPTION_EXPLICIT_OFF 						
	| OPTION_PRIVATE_MODULE 				
;
	
attributeStmt :
	ATTRIBUTE  Key=identifier '=' Value=expr (',' Value=expr)*? 
	;
	
//definition :
//	userInterface
//	;
	
declaration :
     references
	;
	
references :
 referenceStmt+
	;

referenceStmt :
 objectType endOfStmt
;

objectType :
 OBJECT '=' Hklm=stringLiteral  ';' Name=stringLiteral
;		
	
//stmt :
//	;
	
	
// 1. para entender "expr:" entenda precedence and associativity em ANTLR	
// 2. referencia para montagem da precedência das operações
//    https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Operators/Operator_Precedence	
expr : '(' expr ')'                    			        //#exprAtom
    | expr '.' expr                     		        //#exprMemberAccess
	| expr '(' expr ')'                  		        // acesso a array expr '[' expr ']'
//
    | expr '&' expr                                     // concat esta expressão não aparece com as outras abaixo
//
	| NEW expr '(' (expr (',' expr)*?)? ')'             // com lista de parâmetros
	| expr '(' expr ')'                 //#ArrayOrFunctionCall
	| <assoc=right> NEW expr
	| <assoc=right> '!' expr
	| <assoc=right> '+' expr
	| <assoc=right> '-' expr
	| <assoc=right> TYPEOF expr
//
    | <assoc=right> expr '^'  expr      //#exprMult
    | expr ('*' | '/') expr             //#exprMult
    | expr MOD expr
	| expr ('+' | '-') expr             //#exprAdd
//
    | expr '<' expr
    | expr '<=' expr
    | expr '>' expr
    | expr '>=' expr
    | expr INSTANCEOF expr
//
    | expr '==' expr        // == if
    | expr '!=' expr        // != if
//
	| expr AND expr            
	| expr OR  expr
//	
	| expr '=' expr         // = atribuição
//	
	| atom
	;						
	
endOfLine :
   newLine label?
 | comment 
 | newStmtInLine
 ;

endOfFile : EOF ;
 
endOfStmt : endOfLine | endOfFile
;
 
label : LABEL ;
	
comment :	COMMENT ;
	
newStmtInLine : NEW_STMT_IN_LINE ;
	
newLine :	NEWLINE ;

identifier : IDENTIFIER ;
	
number : INT | FLOAT ;

atom : identifier | number	| stringLiteral;

stringLiteral : STRING_LITERAL ;


// keywords
ACCESS : A C C E S S  {startOfLine = false;};
ADDRESSOF : A D D R E S S O F  {startOfLine = false;};
ALIAS : A L I A S {startOfLine = false;};
AND : A N D {startOfLine = false;};
ANDALSO : A N D A L S O {startOfLine = false;};
ANY : A N Y {startOfLine = false;};
ATTRIBUTE : A T T R I B U T E {startOfLine = false;};
APPACTIVATE : A P P A C T I V A T E {startOfLine = false;};
APPEND : A P P E N D {startOfLine = false;};
AS : A S {startOfLine = false;};
BEGIN : B E G I N {startOfLine = false;};
BEEP : B E E P {startOfLine = false;};
BINARY : B I N A R Y {startOfLine = false;};
BOOLEAN : B O O L E A N {startOfLine = false;};
BYVAL : B Y V A L {startOfLine = false;};
BYREF : B Y R E F {startOfLine = false;};
BYTE : B Y T E {startOfLine = false;};
CALL : C A L L {startOfLine = false;};
CASE : C A S E {startOfLine = false;};
CHDIR : C H D I R {startOfLine = false;};
CHDRIVE : C H D R I V E {startOfLine = false;};
CLASS : C L A S S {startOfLine = false;};
CLOSE : C L O S E {startOfLine = false;};
COLLECTION : C O L L E C T I O N {startOfLine = false;};
CONST : C O N S T {startOfLine = false;};
DATE : D A T E {startOfLine = false;};
DECLARE : D E C L A R E {startOfLine = false;};
DEFBOOL : D E F B O O L {startOfLine = false;}; 
DEFBYTE : D E F B Y T E {startOfLine = false;};
DEFDATE : D E F D A T E {startOfLine = false;};
DEFDBL : D E F D B L {startOfLine = false;};
DEFDEC : D E F D E C {startOfLine = false;};
DEFCUR : D E F C U R {startOfLine = false;};
DEFINT : D E F I N T {startOfLine = false;};
DEFLNG : D E F L N G {startOfLine = false;};
DEFOBJ : D E F O B J {startOfLine = false;};
DEFSNG : D E F S N G {startOfLine = false;};
DEFSTR : D E F S T R {startOfLine = false;};
DEFVAR : D E F V A R {startOfLine = false;};
DELETESETTING : D E L E T E S E T T I N G {startOfLine = false;};
DIM : D I M {startOfLine = false;};
DOEVENTS : D O E V E N T S {startOfLine = false;};
DO : D O {startOfLine = false;};
DOUBLE : D O U B L E {startOfLine = false;};
EACH : E A C H {startOfLine = false;};
ELSE : E L S E {startOfLine = false;};
ELSE_DIRECTIVE : '#' E L S E {startOfLine = false;};
ELSEIF : E L S E I F {startOfLine = false;};
ELSEIF_DIRECTIVE : '#' E L S E I F {startOfLine = false;};
EMPTY : E M P T Y {startOfLine = false;};
END_ENUM : E N D ' ' E N U M {startOfLine = false;};
END_FUNCTION : E N D (' ')+ F U N C T I O N {startOfLine = false;};
END_IF : E N D ' ' I F {startOfLine = false;};
END_IF_DIRECTIVE : '#' E N D ' ' I F {startOfLine = false;};
END_PROPERTY : E N D ' ' P R O P E R T Y {startOfLine = false;};
END_SELECT : E N D ' ' S E L E C T {startOfLine = false;};
END_SUB : E N D ' ' S U B {startOfLine = false;};
END_TYPE : E N D ' ' T Y P E {startOfLine = false;};
END_WITH : E N D ' ' W I T H {startOfLine = false;};
END : E N D {startOfLine = false;};
ENUM : E N U M {startOfLine = false;};
EQV : E Q V {startOfLine = false;};
ERASE : E R A S E {startOfLine = false;};
ERROR : E R R O R {startOfLine = false;};
EVENT : E V E N T {startOfLine = false;};
EXIT_DO : E X I T ' ' D O {startOfLine = false;};
EXIT_FOR : E X I T ' ' F O R {startOfLine = false;};
EXIT_FUNCTION : E X I T ' ' F U N C T I O N {startOfLine = false;};
EXIT_PROPERTY : E X I T ' ' P R O P E R T Y {startOfLine = false;};
EXIT_SUB : E X I T ' ' S U B {startOfLine = false;};
FALSE : F A L S E {startOfLine = false;};
FILECOPY : F I L E C O P Y {startOfLine = false;};
FRIEND : F R I E N D {startOfLine = false;};
FOR : F O R {startOfLine = false;};
FUNCTION : F U N C T I O N {startOfLine = false;};
GET : G E T {startOfLine = false;};
GLOBAL : G L O B A L {startOfLine = false;};
GOSUB : G O S U B {startOfLine = false;};
GOTO : G O T O {startOfLine = false;};
IF : I F {startOfLine = false;};
IF_DIRECTIVE : '#' I F {startOfLine = false;};
IMP : I M P {startOfLine = false;};
IMPLEMENTS : I M P L E M E N T S {startOfLine = false;};
IN : I N {startOfLine = false;};
INPUT : I N P U T {startOfLine = false;};
IS : I S {startOfLine = false;};
INSTANCEOF: I N S T A N C E O F {startOfLine = false;};
INTEGER : I N T E G E R {startOfLine = false;};
KILL: K I L L {startOfLine = false;};
LOAD : L O A D {startOfLine = false;};
LOCK : L O C K {startOfLine = false;};
LONG : L O N G {startOfLine = false;};
LOOP : L O O P {startOfLine = false;};
LEN : L E N {startOfLine = false;};
LET : L E T {startOfLine = false;};
LIB : L I B {startOfLine = false;};
LIKE : L I K E {startOfLine = false;};
LINE_INPUT : L I N E ' ' I N P U T {startOfLine = false;};
LOCK_READ : L O C K ' ' R E A D {startOfLine = false;};
LOCK_WRITE : L O C K ' ' W R I T E {startOfLine = false;};
LOCK_READ_WRITE : L O C K ' ' R E A D ' ' W R I T E {startOfLine = false;};
LSET : L S E T {startOfLine = false;};
MACRO_IF : '#' I F {startOfLine = false;};
MACRO_ELSEIF : '#' E L S E I F {startOfLine = false;};
MACRO_ELSE : '#' E L S E {startOfLine = false;};
MACRO_END_IF : '#' E N D ' ' I F {startOfLine = false;};
//ME : M E {startOfLine = false;};
//MID : M I D {startOfLine = false;};
MKDIR : M K D I R {startOfLine = false;};
MOD : M O D {startOfLine = false;};
NAME : N A M E {startOfLine = false;};
NEXT : N E X T {startOfLine = false;};
NEW : N E W {startOfLine = false;};
NOT : N O T {startOfLine = false;};
NOTHING : N O T H I N G {startOfLine = false;};
NULL : N U L L {startOfLine = false;};
OBJECT : O B J E C T {startOfLine = false;};
ON : O N {startOfLine = false;};
ON_ERROR : O N ' ' E R R O R {startOfLine = false;};
OPEN : O P E N {startOfLine = false;};
OPTIONAL : O P T I O N A L {startOfLine = false;};
OPTION_BASE : O P T I O N WS B A S E {startOfLine = false;};
OPTION_EXPLICIT : O P T I O N WS ((E X P L I C I T) | (E X P L I C I T WS O N))
                 {startOfLine = false;};
OPTION_EXPLICIT_OFF : O P T I O N WS E X P L I C I T WS O F F {startOfLine = false;};
OPTION_COMPARE : O P T I O N WS C O M P A R E {startOfLine = false;};
OPTION_PRIVATE_MODULE : O P T I O N WS P R I V A T E WS M O D U L E {startOfLine = false;};
OR : O R {startOfLine = false;};
OUTPUT : O U T P U T {startOfLine = false;};
PARAMARRAY : P A R A M A R R A Y {startOfLine = false;};
PRESERVE : P R E S E R V E {startOfLine = false;};
PRINT : P R I N T {startOfLine = false;};
PRIVATE : P R I V A T E {startOfLine = false;};
PROPERTY_GET : P R O P E R T Y ' '+ G E T {startOfLine = false;};
PROPERTY_LET : P R O P E R T Y ' '+ L E T {startOfLine = false;};
PROPERTY_SET : P R O P E R T Y ' '+ S E T {startOfLine = false;};
PUBLIC : P U B L I C {startOfLine = false;};
PUT : P U T {startOfLine = false;};
RANDOM : R A N D O M {startOfLine = false;};
RANDOMIZE : R A N D O M I Z E {startOfLine = false;};
RAISEEVENT : R A I S E E V E N T {startOfLine = false;};
READ : R E A D {startOfLine = false;};
READ_WRITE : R E A D ' ' W R I T E {startOfLine = false;};
REDIM : R E D I M {startOfLine = false;};
REM : R E M {startOfLine == true}? {startOfLine = false;};
RESET : R E S E T {startOfLine = false;};
RESUME : R E S U M E {startOfLine = false;};
RETURN : R E T U R N {startOfLine = false;};
RMDIR : R M D I R {startOfLine = false;};
RSET : R S E T {startOfLine = false;};
SAVEPICTURE : S A V E P I C T U R E {startOfLine = false;};
SAVESETTING : S A V E S E T T I N G {startOfLine = false;};
SEEK : S E E K {startOfLine = false;};
SELECT : S E L E C T {startOfLine = false;};
SENDKEYS : S E N D K E Y S {startOfLine = false;};
SET : S E T {startOfLine = false;};
SETATTR : S E T A T T R {startOfLine = false;};
SHARED : S H A R E D {startOfLine = false;};
SINGLE : S I N G L E {startOfLine = false;};
SPC : S P C {startOfLine = false;};
STATIC : S T A T I C {startOfLine = false;};
STEP : S T E P {startOfLine = false;};
STOP : S T O P {startOfLine = false;};
STRING : S T R I N G {startOfLine = false;};
SUB : S U B {startOfLine = false;};
TAB : T A B {startOfLine = false;};
TEXT : T E X T {startOfLine = false;};
THEN : T H E N {startOfLine = false;};
TIME : T I M E {startOfLine = false;};
TYPEOF : T Y P E O F {startOfLine = false;};
TO : T O {startOfLine = false;};
TRUE : T R U E {startOfLine = false;};
TYPE : T Y P E {startOfLine = false;};
UNLOAD : U N L O A D {startOfLine = false;};
UNLOCK : U N L O C K {startOfLine = false;};
UNTIL : U N T I L {startOfLine = false;};
VARIANT : V A R I A N T {startOfLine = false;};
VERSION : V E R S I O N {startOfLine = false;};
WEND : W E N D {startOfLine = false;};
WHILE : W H I L E {startOfLine = false;};
WIDTH : W I D T H {startOfLine = false;};
WITH : W I T H {startOfLine = false;};
WITHEVENTS : W I T H E V E N T S {startOfLine = false;};
WRITE : W R I T E {startOfLine = false;};
XOR : X O R {startOfLine = false;};

UI_BEGINPROPERTY: B E G I N P R O P E R T Y {startOfLine = false; insideUIProperty = true;};
UI_ENDPROPERTY: E N D P R O P E R T Y {startOfLine = false; insideUIProperty = false;};  

COLON_CHAR : ':' ;
DOT_CHAR :   '.' ;
LPAREN_CHAR : '(' ;
RPAREN_CHAR : ')' ;
SEMI_CHAR : ',' ;
EXPONENT_CHAR : '^' ;
PLUS_CHAR : '+' ;
MINUS_CHAR : '-' ;
MULT_CHAR : '*' ;
DIV_CHAR : '/' ;
EQUALS_CHAR : '=' ;
LT_CHAR : '<' ;
LE_CHAR : '<=' ;
GT_CHAR : '>' ;
GE_CHAR : '>=' ;
NOT_CHAR : '!' ;
NOT_EQUALS : '!=' ;
CONCAT_CHAR : '&' ;

LABEL:  (LETTER | DIGIT)+? ':'  (WS | NEWLINE) {startOfLine}? {startOfLine = false;}; 

NEW_STMT_IN_LINE : ':' WS {startOfLine = false;};

LINE_CONTINUATION : '_' '\r'? '\n' -> skip ;

COMMENT :  ('\'' | ':'? REM WS?) (LINE_CONTINUATION | ~('\r' | '\n')*)*? ('\r'? '\n' | EOF) -> channel(3) ;
           
STRING_LITERAL : '"' ~["]*? '"'
        | '\'' ~[']*? '\''
	;

INT : DIGIT+ ;

//FLOAT_NO_EXPOENT     : DIGIT+? '.' DIGIT* -> type(FLOAT) ;
//FLOAT_NO_SIGNIFICAND : DIGIT*? '.' DIGIT+ -> type(FLOAT) ;

FLOAT :   DIGIT+? '.' DIGIT*    // IMPORTANTE: NUNCA UTILIZE '*?', '+?' ou '??' em finais de "rule lexer"
		| DIGIT*? '.' DIGIT+  
		;

BRACKET_IDENTIFIER : '[' ~(']')+? ']';                //-> type(IDENTIFIER) ;

IDENTIFIER : NAME_START_CHAR NAME_CHAR+? TYPE_INDICATOR?;      //-> type(IDENTIFIER) ;

//IDENTIFIER :  NAME_START_CHAR NAME_CHAR+? TYPE_INDICATOR?
//			| '[' ~(']')+? ']'
//			;

NEWLINE : '\r'? '\n' ;

WS : [ \t]+ -> channel(2) ;

fragment
 TYPE_INDICATOR :   '&'|'%'|'#'|'!'|'@'|'$' ;
//  
///*===
// -> Herança da linguagem BASIC - Variáveis terminadas com os seguintes caracteres
// -> Não tem qualquer significado em VB ou VB.Net
//      %                 Integer
//      &                 Long
//      !                 Single
//      #                 Double
//      $                 String
//      @                 Currency
//===*/ 
//
fragment
 LETTER : [a-zA-Z] ;

fragment
 DIGIT : [0-9] ;

fragment
 NAME_CHAR : NAME_START_CHAR
	        |  DIGIT
	;

fragment
NAME_START_CHAR : [a-zA-Z_] ;

// case insensitive chars
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
