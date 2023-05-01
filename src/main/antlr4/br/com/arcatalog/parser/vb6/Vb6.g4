/*
* Copyright (C) 2014 Ulrich Wolffgang <u.wol@wwu.de>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

/*
* Visual Basic 6.0 Grammar for ANTLR4
*
* This is an approximate grammar for Visual Basic 6.0, derived 
* from the Visual Basic 6.0 language reference 
* http://msdn.microsoft.com/en-us/library/aa338033%28v=vs.60%29.aspx 
* and tested against MSDN VB6 statement examples as well as several Visual 
* Basic 6.0 code repositories.
*
* Characteristics:
*
* 1. This grammar is line-based and takes into account whitespace, so that
*    member calls (e.g. "A.B") are distinguished from contextual object calls 
*    in WITH statements (e.g. "A .B").
*
* 2. Keywords can be used as identifiers depending on the context, enabling
*    e.g. "A.Type", but not "Type.B".
*
*
* Known limitations:
*
* 1. Preprocessor statements (#if, #else, ...) must not interfere with regular
*    statements.
*
* 2. Comments are skipped.
*
*
* Change log:
*
* v1.3
*	- call statement precedence
*
* v1.2
*	- refined call statements
*
* v1.1 
*	- precedence of operators and of ELSE in select statements
*	- optimized member calls
*
* v1.0 Initial revision
*/

//======================MAP CONTROL VB6 to .Net =============================
// MAP Control            	To .Net
// Threed.SSCommand							System.Windows.Forms.Button
// Threed.Constants_ButtonStyle				System.Windows.Forms.FlatStyle
// Threed.SSFrame							System.Windows.Forms.GroupBox
// Threed.SSPanel							System.Windows.Forms.Panel
// Threed.SSCheck							System.Windows.Forms.CheckBox
// Threed.SSOption							System.Windows.Forms.RadioButton
// Threed.Constants_Alignment				System.Drawing.ContentAlignment
// Threed.Constants_PictureBackgroundStyle	System.Windows.Forms.ImageLayout
// Threed.Constants_Bevel					System.Windows.Forms.BorderStyle
// Threed.Constants_MousePointer			System.Windows.Forms.Cursor
// Threed.Constants_CheckBoxValue			System.Windows.Forms.CheckState
//=============================================================================

/*
============================== VB5 Activex Controls =========================
AniBtn32.ocx
Gauge32.ocx
Graph32.ocx
Gsw32.EXE
Gswdll32.DLL
Grid32.ocx
KeySta32.ocx
MSOutl32.ocx
Spin32.ocx
Threed32.ocx
MSChart.ocx
==============================================================================
*/
/*
===== Herança da linguagem BASIC - Variáveis terminadas com os seguintes caracteres
===== não tem qualquer significado em VB ou VB.Net
      %                 Integer
      &                 Long
      !                 Single
      #                 Double
      $                 String
      @                 Currency
=============================================================================
*/     

/* ============= VBP File - References Vs Objects
Objects are for ActiveX controls which are usually compiled to .ocx files.
References are for type libraries usually compiled to .dll files or .tlb files.
Notice that .ocx files contain typelib too so this is very inconsistent and pretty much a legacy division.

Paths and filenames are optional, typelib IDs are canonical way to resolve dependency.
Only if these are not found in registry there is a auto-resolve strategy searching
for files in current folder for .ocxes only. 
This most annoying behavior happens at run-time too when the applications starts 
to auto-registering .ocxes in current folder if typelibs are not found and often 
fails on modern OSes for lack of permissions to write in HKLM.

There are Object lines in .frm/.ctl source files too. These get appended to 
current project if adding existing form/usercontrol.

If an .ocx typelib is added as Reference line the IDE usually fails to load the project 
and a manual edit is needed.
*/ 

/*
ScaleMode 	Meaning 
0 	User-defined. 
1 	Twips - 1440 per inch. 
2 	Points - 72 per inch. 
3 	Pixels - number per inch depends on monitor. 
4 	Characters - character = 1/6 inch high and 1/12 inch wide. 
5 	Inches. 
6 	Millimeters. 
7 	Centimeters.
*/

/*
Byte-------------------------------1 byte   
Boolean----------------------------2 bytes  
Integer----------------------------2 bytes  
Long
(long integer)---------------------4 bytes  
Single-----------------------------4 bytes  
(single-precision floating-point)   
Double-----------------------------8 bytes
(double-precision floating-point)       
Currency
(scaled integer)-------------------8 bytes
Decimal---------------------------14 bytes  
Date------------------------------ 8 bytes  
Object-----------------------------4 bytes  
String 
(variable-length)-----------------10 bytes 
Variant
(with numbers)--------------------16 bytes  
Variant
(with characters)-----------------22 bytes + string length
User-defined
*/

grammar Vb6;

//@lexer::header { 
//  package br.com.bicam.parser.visualbasic6; 
//}

@lexer::members { 
  public boolean firstIdInLine = true;
  public boolean inUIProperty = false;
}

@parser::header {
//  package br.com.bicam.parser.visualbasic6;
//  import br.com.bicam.util.Watch;
  import br.com.arcatalog.util.Watch;
  import java.util.HashMap;
}

@parser::members {
   Watch elapsedTime = new Watch();
   double timeElapsedSinceLastStatement = 0;
   public boolean firstIdInLine = true;
   public boolean inBeginBlock = false;
   public boolean inDirectiveSection = false;
   public boolean inDefStmt = false;
   public boolean formParam = false;
   public boolean reservedKeyword = false;
   public boolean reserverdKeywordUntil = false;
   public boolean realParam = false;
//   public boolean isIdentifier = false;
   public String currentID = "";
   public boolean isPrintLine = false;
   public boolean isIfStmt = false;
   public boolean isDefinedInDeclarationSection = false;
   
   HashMap<String,Integer> reservedWord = new HashMap<String,Integer>();
   
   public int positionOfMemberAccessOper; // usado para verificar se Ã©:
                                          // identificador qualificado "ABC.d" ou
                                          // rotina com parÃ¢metro iniciado com ponto "ABC .d"
                                          // veja exemplo (**)
                                          
/*
   public boolean isAmbiguosIdentifier(){
   	if(inBeginBlock) return true;
   	if(inDefStmt) return true;
   	if(firstIdInLine) return false;
   	return true;
   }
 */
 
 	public boolean isReserdWord(String _word) {
		if(reservedWord.containsKey(_word)) return true;
		return false;
	}
	
	public void setReserdWord(String _word) {
		if(reservedWord.containsKey(_word)) reservedWord.put(_word, reservedWord.get(_word)+1);
		else reservedWord.put(_word, 1);
	}
	
	public void removeReserdWord(String _word) {
		if(reservedWord.containsKey(_word)) {
			reservedWord.put(_word, reservedWord.get(_word)-1);
			if(reservedWord.get(_word) == 0) reservedWord.remove(_word);
		}
		else {
			System.err.format("*** ERROR: reserved word '%s' not found.%n", _word);
		}
	}  
   public boolean isSpecialName(String _name){
    if(_name.equalsIgnoreCase("Unchecked")) return true;
    if(_name.equalsIgnoreCase("Checked")) return true;
	return false;
   }
      
   public boolean isImplicitCall(String _oper){
     return !(_oper.equals("="));
   }
   
   public void marcaCurrentID(Token _currentToken){
//   	if (_currentToken.getText().equalsIgnoreCase("Printer")) currentID = _currentToken.getText();
//	if (_currentToken.getText().equalsIgnoreCase("Line")){
//		if (currentID.equalsIgnoreCase("Printer")) {
//			isPrintLine = true;
//			currentID = "";
//		}
//	}
 if (_currentToken.getText().equalsIgnoreCase("Printer.Line")) isPrintLine = true;
   }
}

options
{
	language = Java;
}

startRule : module EOF;

module : ( section | endOfLine )+
;

section :
	 	 moduleHeader 
//	| moduleHeader
	| moduleReferences
//	| directiveBlock
	| directiveSection
	| moduleUI
	| definitionSection
//	| directiveSection
;

moduleHeader : VERSION  DOUBLELITERAL  CLASS?;

moduleReferences :
 moduleReferenceStmt+
;

moduleReferenceStmt :
 referenceType assignOper Hklm=expr  ';' Name=expr endOfLine+
;

referenceType :
 OBJECT
;

moduleUI: guiDefinition+ {inBeginBlock = false;};

guiDefinition:
 BEGIN {inBeginBlock = true;} (type | designerHKLM ) Name=expr endOfLine+
  ( guiAttributeSetting  | moduleUI | guiProperty )*
//  END  {inBeginBlock = false;} {System.err.println("Time elapsed: " + elapsedTime.elapsedTime() + " - " + $expr.text);} endOfLine+ 
  END  {inBeginBlock = false;} {System.err.println("Elapsed Time: " + elapsedTime.elapsedTime() + " - " + $expr.text);} endOfLine+ 
;

designerHKLM :
 HKLM=expr?
;

guiAttributeSetting:  
  expr endOfLine+
;

guiProperty:
 UI_BEGINPROPERTY {inBeginBlock = true;} PROPERTY_NAME=expr HKLM=expr? endOfLine+
    (guiAttributeSetting | guiProperty)*
 UI_ENDPROPERTY endOfLine+
;

directiveSection :
	optionStmt endOfLine
	| directiveBlock  // kep this order
	| attributeStmt endOfStmt
	| defTypeStmt endOfStmt
	| ifDirective endOfLine?
//	| directiveBlock
//	| definitionSection
;

definitionSection :
	methodDefinition
	| {isDefinedInDeclarationSection = true;} stmt 
;

definitionInMethod:
 	  typeDefinition
    | variableDefinition
	| enumerationDefinition
	| declareStmt
	| eventStmt
;

enumerationDefinition : 
	accessModifier* ENUM  {inDefStmt = true; firstIdInLine = false;} Name=identifier endOfLine+ 
        enumValues
	END_ENUM {inDefStmt = false;}
;

enumValues :
 (variableStmt endOfStmt+)+
;


methodDefinition :
//	accessModifier* methodType {formParam = true; inDefStmt = true;}  Name=expr ReturnType=asTypeClause? endOfLine {formParam = false; inDefStmt = false;}
	accessModifier* methodType {formParam = true; inDefStmt = true;}  Name=identifier formalParameters ReturnType=asTypeClause? ArrayIndicator=formalParameters? endOfLine {formParam = false; inDefStmt = false;}

		blockStmt*
	( endSub 
	  | endFunction
	  | endProperty)  {System.err.println("Elapsed Time: " + elapsedTime.elapsedTime() + " - " + $Name.text);}  
;

endSub :
END_SUB
;

endFunction :
END_FUNCTION
;

endProperty :
END_PROPERTY
;

variableDefinition :
	accessModifier+ {inDefStmt = true;}  WITHEVENTS? 
  			variableListStmt {inDefStmt = false;}
;

variableListStmt :
	variableStmt ( ','  variableStmt)*
;

variableStmt :
	Name=identifier ( LPAREN  (subscripts )? RPAREN )? asTypeClause? fieldLength? initialValue?
;

typeDefinition : 
	accessModifier* TYPE  {inDefStmt = true;} Name=identifier endOfLine+ 
		(variableStmt endOfLine+)*
	END_TYPE {inDefStmt = false;}
;

accessModifier :
 DIM | STATIC | visibility | CONST
;

visibility : 
PRIVATE 
 | PUBLIC 
 | FRIEND 
 | GLOBAL 
 ;

methodType :
    SUB
  | FUNCTION
  | PROPERTY_GET
  | PROPERTY_SET
  | PROPERTY_LET
;

asTypeClause : AS  newOper? type ;

type : builtinType
  | identifier // | instance
  ;
  
builtinType :  ANY | BOOLEAN | BYTE | COLLECTION | DATE | DOUBLE | INTEGER | LONG |  OBJECT | SINGLE | STRING | VARIANT 
;

//instance : NEW identifier
//;

fieldLength : multOper  expr;

initialValue : assignOper expr;

subscripts : 
	subscript ( ','  subscript)*
;

subscript : 
	(expr  TO )? expr
;

optionStmt : 
	OPTION_BASE  INTEGERLITERAL 			
	| OPTION_COMPARE  (BINARY | TEXT) 	    
	| OPTION_EXPLICIT 	
	| OPTION_EXPLICIT_OFF 						
	| OPTION_PRIVATE_MODULE 				
;

attributeStmt : 
	ATTRIBUTE?  identifier '=' expr (',' expr)*
;

defTypeStmt : 
	defType  expr
;

defType :
	DEFBOOL  
	| DEFBYTE 
	| DEFDATE 
	| DEFDBL 
	| DEFDEC 
	| DEFCUR 
	| DEFINT 
	| DEFLNG 
	| DEFOBJ 
	| DEFSNG 
	| DEFSTR 
	| DEFVAR
;


directiveBlock :
	BEGIN {inBeginBlock = true;} endOfLine+ 
//		(expr endOfLine+)+
		(attributeStmt endOfLine+)+
	END {inBeginBlock = false;} endOfLine
;

blockStmt :
 (stmt {System.err.println("Elapsed Time Interval: " + elapsedTime.elapsedTimeInterval() + " - " + $stmt.start.getLine());}
  | endOfLine)+
;

stmt :
//    {isDefinedInDeclarationSection}? definitionInMethod {isDefinedInDeclarationSection=false;}
//   | {formParam == true}? formalParameter
      commandStmt endOfStmt*  // endOfStmt? por conta do ifthenelseInLine
//  | definitionInMethod 
 	| typeDefinition
    | variableDefinition
	| enumerationDefinition
	| declareStmt
	| eventStmt
//    | {isImplicitCall(_input.LT(2).getText())}? implicitCallStmt endOfStmt?
    | assignmentStmt
    | implicitCallStmt endOfStmt?
//    | expr realParametersNoParen? SEMI_COLON? endOfStmt?
    | expr realParametersNoParen? SEMI_COLON? endOfStmt
;

assignmentStmt :
 identifier assignOper expr
;

implicitCallStmt:
 expr realParametersNoParen? SEMI_COLON? // SEMI_COLON pode ser usado no comando "Printer.Print"
;

commandStmt :
    appactivateStmt
//  | attributeStmt   
  | callStmt
  | chdirStmt
  | closeStmt
  | doEvents
  | doLoopStmt
  |	endStmt
  | eraseStmt  
  | eventStmt
  | exitStmt
  | filecopyStmt
  | forStmt
//  | forEachStmt 
//  | forNextStmt
  | goToStmt
  | ifThenElseStmt
  | inputStmt
  | getStmt 
  |	goSubStmt
  | killStmt
  | lineInputStmt 
  | loadStmt
  | mkdirStmt
  | nameStmt
  | onErrorStmt
  | openStmt
  | putStmt
  | printStmt
  | raiseEventStmt
  | redimStmt
  | randomizeStmt
  | rmdirStmt 
  | rsetStmt
  | resumeStmt
  | selectCaseStmt
  | sendkeysStmt
  | setattrStmt
  | setStmt
  | stopStmt
  | unloadStmt
//  | widthStmt
  | whileWendStmt
  | withStmt
  | writeStmt
;

appactivateStmt : 
	APPACTIVATE  expr ( ','  expr)?
;

callStmt: 
	CALL expr
;

chdirStmt : 
	CHDIR  expr
;

closeStmt : 
	CLOSE ( expr ( ','  expr)*)?
;

declareStmt : 
 accessModifier* DECLARE  {formParam = true;} methodType  Name=expr  library alias? 
      formalParameters?
      ReturnType=asTypeClause?
      {formParam = false;}
;

library :
 LIB  Name=expr
;

alias :
ALIAS  Name=expr
;

eventStmt : 
// accessModifier? EVENT  { formParam = true;} Name=expr   
 accessModifier? EVENT  { formParam = true;} Name=identifier   
      formalParameters?
      ReturnType=asTypeClause?
      {formParam = false;}
;

doEvents :
 DOEVENTS
;

endStmt :
 END 
;

eraseStmt : 
 ERASE expr
;

exitStmt :
 ( exitDo | exitFor | exitFunction | exitProperty | exitSub) 
;

exitDo :
	EXIT_DO
;

exitFor :
	EXIT_FOR
;

exitFunction :
	EXIT_FUNCTION
;

exitProperty :
	EXIT_PROPERTY
;

exitSub :
	EXIT_SUB
;

getStmt : 
 GET expr  (','+  expr)*
;

goSubStmt : 
	GOSUB expr
;

ifThenElseStmt : 
	IF {isIfStmt = true;} conditionalExpr THEN ( ifBodyInLine	| endOfLine+ ifBodyInBlock	)	{isIfStmt = false;}
;

ifBodyInLine :
    ifTrueInLine ifFalseInLine?
    | ifFalseInLine
;

ifBodyInBlock :
     ifTrue? elseIf* ifFalse? endIf  //elsex para nÃ£o conflitar com else da linguagem ANTLR
;

endIf :
	END_IF
;

ifDirective :
	IF_DIRECTIVE conditionalExpr THEN endOfLine+ 
		ifBodyInBlockDirective
;
	
ifBodyInBlockDirective :
     ifTrue? elseIfDirective* elseDirective? END_IF_DIRECTIVE  
;		

conditionalExpr :
 expr
;

ifTrue :
 blockStmt
;


ifTrueElseIf :
 blockStmt
;

ifTrueInLine :
    stmt 
;

elseIf :
//	ELSEIF conditionalExpr THEN blockStmt
	ELSEIF conditionalExpr THEN ifTrueElseIf
;

ifFalse :
	ELSE blockStmt
;

ifFalseInLine :
	ELSE stmt
;

elseIfDirective :
	ELSEIF_DIRECTIVE conditionalExpr THEN blockStmt
;

elseDirective :
	ELSE_DIRECTIVE blockStmt
;

filecopyStmt : 
	FILECOPY  expr  ','  expr
;

forStmt :
// FOR {reservedKeyword = true;} (forEachStmt | forNextStmt)  {reservedKeyword = false;}
   FOR {setReserdWord("NEXT");} (forEachStmt | forNextStmt)  {removeReserdWord("NEXT");}
;

forEachStmt : 
	EACH  expr  IN  expr endOfLine+ 
		blockStmt*
   endFor
;

forNextStmt : 
//	expr  TO  expr ( STEP  expr)? endOfLine
	assignmentStmt TO  expr ( STEP  expr)? endOfLine
		blockStmt*
    endFor
;

endFor :
 NEXT expr?
;

goToStmt : 
	GOTO  Name=expr
; 

lineInputStmt : 
	LINE_INPUT expr  (','  expr)+
;


inputStmt : 
	INPUT expr  (','  expr)+
;

loadStmt : 
	LOAD expr
;

killStmt : 
 KILL expr
;

doLoopStmt :
 doInconditional
	| whileDo
	| doUntil
;

doInconditional :
	DO { reserverdKeywordUntil = true;} endOfLine+ 
		blockStmt*
  endLoop { reserverdKeywordUntil = false;}
;

printStmt : 
 PRINT  (realParameters | realParametersNoParen)
;

whileDo :
	DO  (WHILE | UNTIL { reserverdKeywordUntil = true;})   conditionalExpr endOfLine+ 
		blockStmt*
endLoop { reserverdKeywordUntil = false;}
;

doUntil :
	DO {firstIdInLine = false;} { reserverdKeywordUntil = true;} endOfLine+ 
		blockStmt*
 endLoop { reserverdKeywordUntil = false;}
;

endLoop :
    LOOP 
 | 	LOOP (WHILE | UNTIL)  conditionalExpr
;

mkdirStmt : 
	MKDIR expr
;

nameStmt :
 NAME expr AS expr
;

onErrorStmt : 
	ON_ERROR  (  goToStmt | resumeStmt)
;

openStmt : 
	OPEN  expr  FOR  (APPEND | BINARY | INPUT | OUTPUT | RANDOM) 
	( ACCESS  (READ | WRITE | READ_WRITE))?
	(SHARED | LOCK_READ | LOCK_WRITE | LOCK_READ_WRITE)?
	 AS  expr Len=expr?
;

putStmt : 
	PUT expr  (','+  expr)*
;

raiseEventStmt :
 RAISEEVENT Name=expr 
;

randomizeStmt : 
 RANDOMIZE expr?
;

redimStmt : REDIM  (PRESERVE )? variableStmt
;

rmdirStmt : 
	RMDIR expr
;
rsetStmt : 
	RSET  expr
;

resumeStmt : 
  RESUME (NEXT | expr)?
  ;

selectCaseStmt : 
	SELECT CASE  expr endOfLine+ 
	sC_Case*
	endSelect
//	 END_SELECT
;

endSelect :
 END_SELECT
;

sC_Case : 
	CASE  sC_Cond  endOfStmt+ // (':'? endOfLine* )  
	blockStmt*
;

sC_Cond : 
	ELSE 															
    | conditionalExpr ( ','  conditionalExpr)* 		
    | expr TO expr			
;

sendkeysStmt :
 SENDKEYS expr ( ','  expr)?
 ;

setattrStmt :
 SETATTR   expr  ','  expr
 ;
 
setStmt : 
//	SET assignStmt=expr
	SET assignmentStmt
;

stopStmt : 
	STOP 
;

unloadStmt : 
	UNLOAD expr
;

whileWendStmt : 
	WHILE conditionalExpr endOfLine+ 
	blockStmt*
	WEND
;

whileEnd :
 WEND
;

withStmt : 
	WITH Name=identifier endOfLine+ 
	blockStmt*
	END_WITH 
;

writeStmt : 
	WRITE expr  (','  expr)+
;

endOfLine :
   NEWLINE label?
 | comment 
 | ': '
 ;

endOfStmt :
   endOfLine 
 | comment 
 | ': '
 | END_OF_STMT label?
;

comment :
  COMMENT label?
;

/*
label : 
   lineNumber
 | labelLine
 | lineNumber labelLine
;
*/

/*
lineNumber :
 LINE_NUMBER
;
*/

/*
labelLine :
 LABEL
;
*/

label :
 LABEL
;

realParameters 
  : {formParam == false}?  '(' realParameter (','+  realParameter)* ')'
  | {formParam == false}?  '(' ',' (','*  realParameter)* ')'
  | {formParam == false}?  '(' ')'
  | {formParam == false}? '(' realParameter (',' realParameter)+ ')' '-' '(' realParameter (',' realParameter)+ ')'
;

realParameter :
 parmOption? expr // logicalExpr
;

 
 expr :
	  notOper expr
//	| '(' expr ')'
	| expr concatOper expr
	| expr neOper expr
	| expr andOper expr
	| expr orOper expr
	| booleanExpr
	;
	
booleanExpr
		: //'(' booleanExpr ')'
		 isOper  ltOper  booleanExpr 						
		| isOper  leOper  booleanExpr 						
		| isOper  gtOper  booleanExpr
		| isOper  geOper  booleanExpr
		| isOper  neOper  booleanExpr
		| isOper  assignOper  booleanExpr
		| booleanExpr  isOper  booleanExpr 							
		| booleanExpr  likeOper  booleanExpr 
		| booleanExpr assignOper booleanExpr
		| booleanExpr neOper booleanExpr
		| booleanExpr gtOper booleanExpr
		| booleanExpr geOper booleanExpr
		| booleanExpr ltOper booleanExpr
		| booleanExpr leOper booleanExpr
		| arithExpr
		;
		
arithExpr
	: //'(' arithExpr ')'
	 minusOper arithExpr
	| plusOper  arithExpr
	| arithExpr (multOper | divOper) arithExpr
	| arithExpr modOper arithExpr
	| arithExpr (plusOper | minusOper) arithExpr
	| atomExpr
	;	
		
atomExpr
   :  //'(' atomExpr ')'
    literal
   | specialIdentifier
//   | builtinType realParameters
   | identifier
   | '(' expr ')'
   ;

//===============================================================================

modOper: MOD;

memberAccessOper : ( '.' | '!') ;
//bangOper: '!';

concatOper : '&';	 
powOper : '^';
multOper : '*' ;
divOper : DIV;
plusOper : '+';
minusOper : '-' ;
isOper :  IS;
likeOper : LIKE;
geOper : '>=';
gtOper : '>';
leOper : '<=';
ltOper: '<';
//eqOper: '=';	SUBSTITUÃ�DO POR assignOper
neOper: '<>';
orOper: OR;
andOper: AND;
andAlsoOper: ANDALSO;

assignOper : '=' | '+=' | '-=' | ':=' ;	

newOper : NEW;

notOper : NOT;

addressOfOper : ADDRESSOF;

typeOfOper : TYPEOF;

parameterAssignOper : ':=' ;

identifier :
  '(' identifier ')'
// | addressOfOper  identifier
// | typeOfOper  identifier 
// | newOper identifier 
 | referenceOper identifier
 | identifier realParameters {_input.LT(1).getText().startsWith(".")}? identifier // IDENTIFIER //( IDENTIFIER realParameters*)+ 
 | identifier realParameters
 | IDENTIFIER
 | BRACKET_IDENTIFIER                      
 | VALEU_UI_PROPERTY  
 | builtinType                   
 | ambiguousKeyword 
;

referenceOper :
   addressOfOper  
 | typeOfOper  
 | newOper 
;

// Parameter utilizado dentro de With Stamennt. Exemplo:
// With var
// ....procname .parameter, onde ".parameter Ã© var.parameter. ".parameter" Ã© qualifiedParameters

qualifiedParameter :
 identifier
;

literal 
 	: stringLiteral
 	| numberLiteral	
 	| specialName
;

stringLiteral : IMAGE_VALUE	| STRINGLITERAL	| CURLY_LITERAL | DATELITERAL  | COLORLITERAL
;

numberLiteral : INTEGERLITERAL | DOUBLELITERAL
;

specialIdentifier : FILENUMBER	| SHORTCUT
;

specialName : TRUE | FALSE | EMPTY | VBA_PARAM | NOTHING | NULL
;

/* 
 realParametersNoParen :
   parmOption? expr (','+ parmOption? expr)* endOfStmt
 | (','+ parmOption? expr)+ endOfStmt
;
*/

 realParametersNoParen :
   realParameter (','+ realParameter)* endOfStmt
 | (','+ realParameter)+ endOfStmt
 ;

formalParameters :
 '(' formalParameter (',' formalParameter)* ')'
 | '(' ')'
;

formalParameter :
// {formParam = false;} => trata chamada de função dentro de parâmetro. Ex.:
//Private Function Verifica_Acesso(ByVal Connumber As Integer, ByVal Formulario As String, Autorizacao() As String, AuxGrUser As String) As Integer

//	parmOption?  {formParam = false;} Name=expr {formParam = true;} asTypeClause?  fieldLength? paramDefaultValue?
	parmOption? variableStmt
;

parmOption:
 (OPTIONAL | (BYVAL |  BYREF) | PARAMARRAY)+
;

paramDefaultValue : 
initialValue
;

ambiguousKeyword // ALL Reserved Keywords must be marked as true. Ex: Error 
	 :   ACCESS  
	 |   {inBeginBlock == false}? ATTRIBUTE  
	 |   APPACTIVATE  
	 |   APPEND  
	 |   BEEP  
	 |   BEGIN  
	 |   BINARY  
	 |   CLASS  
	 |   CLOSE  
	 |   CHDIR  
	 |   CHDRIVE  
	 |   COLLECTION  
	 |   CONST  
	 |   DATE 
	 |   DEFBOOL 
	 |   DEFBYTE  
	 |   DEFCUR  
	 |   DEFDBL  
	 |   DEFDATE 
	 |   DEFDEC  
	 |   DEFINT  
	 |   DEFLNG 
	 |   DEFOBJ  
	 |   DEFSNG 
	 |   DEFSTR  
	 |   DEFVAR  
	 |   DELETESETTING  
	 |   EQV  
	 |   ERROR  // Reserved Keywords // ZE sem  o teste  isAmbiguosIdentifier()
	 |   FILECOPY  
	 |   IMP 
	 |   INPUT  
	 |   KILL  
	 |   LOAD 
	 |   LOCK  
	 |   LEN 
	 |   LSET 
	 |   MKDIR 
	 |   NAME 
//	 |   {reservedKeyword != true}? NEXT  //Reserved Keywords
	 |   {!isReserdWord("NEXT")}? NEXT  //Reserved Keywords
	 |   NOTHING 
	 |   NULL 
	 |   EMPTY  
	 |   NULL  
	 |   OBJECT   
	 |   OPEN  
	 |   OUTPUT  
	 |   PRINT 
	 |   PUT  
	 |   RANDOM  
	 |   RANDOMIZE  
	 |   READ  
	 |   REDIM  
	 |   REM  
	 |   RESET 
	 |   RMDIR  
	 |   RSET  
	 |   SAVEPICTURE  
	 |   SAVESETTING  
	 |   SEEK  
	 |   SENDKEYS  
	 |   SETATTR  
	 |   SPC  
	 |   STEP
	 |   STRING  
	 |   TAB  
	 |   TEXT  
	 |   TIME  
	 |   TYPE  
	 |   UNLOAD  
	 |   UNLOCK 
//	 |   {reserverdKeywordUntil == false}? UNTIL  
	 |   VERSION  
	 |   WIDTH  
	 |   WRITE  
//	 | 	 ERROR 
	 |   LEN  
;

// lexer rules --------------------------------------------------------------------------------
//LINE_NUMBER: {getCharPositionInLine() == 0}? [0-9]+;
LINE_NUMBER : [0-9]+ {firstIdInLine}? -> skip;

LABEL:  LETTERORDIGIT+ ':' {firstIdInLine}? {firstIdInLine = false;}; 

 VALEU_UI_PROPERTY : 
  ('0'..'9') LETTERORDIGIT+  {inUIProperty}? {firstIdInLine = false;} 
 ;
 
 VBA_PARAM :
     'SaveChanges:=wdDoNotSaveChanges'
   | 'SaveChanges:=wdPromptToSaveChanges'
   | 'SaveChanges:=wdSaveChanges'
 ;

// keywords
ACCESS : A C C E S S  {firstIdInLine = false;};
ADDRESSOF : A D D R E S S O F  {firstIdInLine = false;};
ALIAS : A L I A S {firstIdInLine = false;};
AND : A N D {firstIdInLine = false;};
ANDALSO : A N D A L S O {firstIdInLine = false;};
ANY : A N Y {firstIdInLine = false;};
ATTRIBUTE : A T T R I B U T E {firstIdInLine = false;};
APPACTIVATE : A P P A C T I V A T E {firstIdInLine = false;};
APPEND : A P P E N D {firstIdInLine = false;};
AS : A S {firstIdInLine = false;};
BEGIN : B E G I N {firstIdInLine = false;};
BEEP : B E E P {firstIdInLine = false;};
BINARY : B I N A R Y {firstIdInLine = false;};
BOOLEAN : B O O L E A N {firstIdInLine = false;};
BYVAL : B Y V A L {firstIdInLine = false;};
BYREF : B Y R E F {firstIdInLine = false;};
BYTE : B Y T E {firstIdInLine = false;};
CALL : C A L L {firstIdInLine = false;};
CASE : C A S E {firstIdInLine = false;};
CHDIR : C H D I R {firstIdInLine = false;};
CHDRIVE : C H D R I V E {firstIdInLine = false;};
CLASS : C L A S S {firstIdInLine = false;};
CLOSE : C L O S E {firstIdInLine = false;};
COLLECTION : C O L L E C T I O N {firstIdInLine = false;};
CONST : C O N S T {firstIdInLine = false;};
DATE : D A T E {firstIdInLine = false;};
DECLARE : D E C L A R E {firstIdInLine = false;};
DEFBOOL : D E F B O O L {firstIdInLine = false;}; 
DEFBYTE : D E F B Y T E {firstIdInLine = false;};
DEFDATE : D E F D A T E {firstIdInLine = false;};
DEFDBL : D E F D B L {firstIdInLine = false;};
DEFDEC : D E F D E C {firstIdInLine = false;};
DEFCUR : D E F C U R {firstIdInLine = false;};
DEFINT : D E F I N T {firstIdInLine = false;};
DEFLNG : D E F L N G {firstIdInLine = false;};
DEFOBJ : D E F O B J {firstIdInLine = false;};
DEFSNG : D E F S N G {firstIdInLine = false;};
DEFSTR : D E F S T R {firstIdInLine = false;};
DEFVAR : D E F V A R {firstIdInLine = false;};
DELETESETTING : D E L E T E S E T T I N G {firstIdInLine = false;};
DIM : D I M {firstIdInLine = false;};
DOEVENTS : D O E V E N T S {firstIdInLine = false;};
DO : D O {firstIdInLine = false;};
DOUBLE : D O U B L E {firstIdInLine = false;};
EACH : E A C H {firstIdInLine = false;};
ELSE : E L S E {firstIdInLine = false;};
ELSE_DIRECTIVE : '#' E L S E {firstIdInLine = false;};
ELSEIF : E L S E I F {firstIdInLine = false;};
ELSEIF_DIRECTIVE : '#' E L S E I F {firstIdInLine = false;};
EMPTY : E M P T Y {firstIdInLine = false;};
END_ENUM : E N D ' ' E N U M {firstIdInLine = false;};
END_FUNCTION : E N D (' ')+ F U N C T I O N {firstIdInLine = false;};
END_IF : E N D ' ' I F {firstIdInLine = false;};
END_IF_DIRECTIVE : '#' E N D ' ' I F {firstIdInLine = false;};
END_PROPERTY : E N D ' ' P R O P E R T Y {firstIdInLine = false;};
END_SELECT : E N D ' ' S E L E C T {firstIdInLine = false;};
END_SUB : E N D ' ' S U B {firstIdInLine = false;};
END_TYPE : E N D ' ' T Y P E {firstIdInLine = false;};
END_WITH : E N D ' ' W I T H {firstIdInLine = false;};
END : E N D {firstIdInLine = false;};
ENUM : E N U M {firstIdInLine = false;};
EQV : E Q V {firstIdInLine = false;};
ERASE : E R A S E {firstIdInLine = false;};
ERROR : E R R O R {firstIdInLine = false;};
EVENT : E V E N T {firstIdInLine = false;};
EXIT_DO : E X I T ' ' D O {firstIdInLine = false;};
EXIT_FOR : E X I T ' ' F O R {firstIdInLine = false;};
EXIT_FUNCTION : E X I T ' ' F U N C T I O N {firstIdInLine = false;};
EXIT_PROPERTY : E X I T ' ' P R O P E R T Y {firstIdInLine = false;};
EXIT_SUB : E X I T ' ' S U B {firstIdInLine = false;};
FALSE : F A L S E {firstIdInLine = false;};
FILECOPY : F I L E C O P Y {firstIdInLine = false;};
FRIEND : F R I E N D {firstIdInLine = false;};
FOR : F O R {firstIdInLine = false;};
FUNCTION : F U N C T I O N {firstIdInLine = false;};
GET : G E T {firstIdInLine = false;};
GLOBAL : G L O B A L {firstIdInLine = false;};
GOSUB : G O S U B {firstIdInLine = false;};
GOTO : G O T O {firstIdInLine = false;};
IF : I F {firstIdInLine = false;};
IF_DIRECTIVE : '#' I F {firstIdInLine = false;};
IMP : I M P {firstIdInLine = false;};
IMPLEMENTS : I M P L E M E N T S {firstIdInLine = false;};
IN : I N {firstIdInLine = false;};
INPUT : I N P U T {firstIdInLine = false;};
IS : I S {firstIdInLine = false;};
INTEGER : I N T E G E R {firstIdInLine = false;};
KILL: K I L L {firstIdInLine = false;};
LOAD : L O A D {firstIdInLine = false;};
LOCK : L O C K {firstIdInLine = false;};
LONG : L O N G {firstIdInLine = false;};
LOOP : L O O P {firstIdInLine = false;};
LEN : L E N {firstIdInLine = false;};
LET : L E T {firstIdInLine = false;};
LIB : L I B {firstIdInLine = false;};
LIKE : L I K E {firstIdInLine = false;};
LINE_INPUT : L I N E ' ' I N P U T {firstIdInLine = false;};
LOCK_READ : L O C K ' ' R E A D {firstIdInLine = false;};
LOCK_WRITE : L O C K ' ' W R I T E {firstIdInLine = false;};
LOCK_READ_WRITE : L O C K ' ' R E A D ' ' W R I T E {firstIdInLine = false;};
LSET : L S E T {firstIdInLine = false;};
MACRO_IF : '#' I F {firstIdInLine = false;};
MACRO_ELSEIF : '#' E L S E I F {firstIdInLine = false;};
MACRO_ELSE : '#' E L S E {firstIdInLine = false;};
MACRO_END_IF : '#' E N D ' ' I F {firstIdInLine = false;};
//ME : M E {firstIdInLine = false;};
//MID : M I D {firstIdInLine = false;};
MKDIR : M K D I R {firstIdInLine = false;};
MOD : M O D {firstIdInLine = false;};
NAME : N A M E {firstIdInLine = false;};
NEXT : N E X T {firstIdInLine = false;};
NEW : N E W {firstIdInLine = false;};
NOT : N O T {firstIdInLine = false;};
NOTHING : N O T H I N G {firstIdInLine = false;};
NULL : N U L L {firstIdInLine = false;};
OBJECT : O B J E C T {firstIdInLine = false;};
ON : O N {firstIdInLine = false;};
ON_ERROR : O N ' ' E R R O R {firstIdInLine = false;};
OPEN : O P E N {firstIdInLine = false;};
OPTIONAL : O P T I O N A L {firstIdInLine = false;};
OPTION_BASE : O P T I O N ' ' B A S E {firstIdInLine = false;};
OPTION_EXPLICIT : O P T I O N ' '+ ((E X P L I C I T) | (E X P L I C I T ' '+ O N))
                 {firstIdInLine = false;};
OPTION_EXPLICIT_OFF : O P T I O N ' '+ E X P L I C I T ' '+ O F F {firstIdInLine = false;};
OPTION_COMPARE : O P T I O N ' ' C O M P A R E {firstIdInLine = false;};
OPTION_PRIVATE_MODULE : O P T I O N ' ' P R I V A T E ' ' M O D U L E {firstIdInLine = false;};
OR : O R {firstIdInLine = false;};
OUTPUT : O U T P U T {firstIdInLine = false;};
PARAMARRAY : P A R A M A R R A Y {firstIdInLine = false;};
PRESERVE : P R E S E R V E {firstIdInLine = false;};
PRINT : P R I N T {firstIdInLine = false;};
PRIVATE : P R I V A T E {firstIdInLine = false;};
PROPERTY_GET : P R O P E R T Y ' '+ G E T {firstIdInLine = false;};
PROPERTY_LET : P R O P E R T Y ' '+ L E T {firstIdInLine = false;};
PROPERTY_SET : P R O P E R T Y ' '+ S E T {firstIdInLine = false;};
PUBLIC : P U B L I C {firstIdInLine = false;};
PUT : P U T {firstIdInLine = false;};
RANDOM : R A N D O M {firstIdInLine = false;};
RANDOMIZE : R A N D O M I Z E {firstIdInLine = false;};
RAISEEVENT : R A I S E E V E N T {firstIdInLine = false;};
READ : R E A D {firstIdInLine = false;};
READ_WRITE : R E A D ' ' W R I T E {firstIdInLine = false;};
REDIM : R E D I M {firstIdInLine = false;};
REM : R E M {firstIdInLine == true}? {firstIdInLine = false;};
RESET : R E S E T {firstIdInLine = false;};
RESUME : R E S U M E {firstIdInLine = false;};
RETURN : R E T U R N {firstIdInLine = false;};
RMDIR : R M D I R {firstIdInLine = false;};
RSET : R S E T {firstIdInLine = false;};
SAVEPICTURE : S A V E P I C T U R E {firstIdInLine = false;};
SAVESETTING : S A V E S E T T I N G {firstIdInLine = false;};
SEEK : S E E K {firstIdInLine = false;};
SELECT : S E L E C T {firstIdInLine = false;};
SENDKEYS : S E N D K E Y S {firstIdInLine = false;};
SET : S E T {firstIdInLine = false;};
SETATTR : S E T A T T R {firstIdInLine = false;};
SHARED : S H A R E D {firstIdInLine = false;};
SINGLE : S I N G L E {firstIdInLine = false;};
SPC : S P C {firstIdInLine = false;};
STATIC : S T A T I C {firstIdInLine = false;};
STEP : S T E P {firstIdInLine = false;};
STOP : S T O P {firstIdInLine = false;};
STRING : S T R I N G {firstIdInLine = false;};
SUB : S U B {firstIdInLine = false;};
TAB : T A B {firstIdInLine = false;};
TEXT : T E X T {firstIdInLine = false;};
THEN : T H E N {firstIdInLine = false;};
TIME : T I M E {firstIdInLine = false;};
TYPEOF : T Y P E O F {firstIdInLine = false;};
TO : T O {firstIdInLine = false;};
TRUE : T R U E {firstIdInLine = false;};
TYPE : T Y P E {firstIdInLine = false;};
UNLOAD : U N L O A D {firstIdInLine = false;};
UNLOCK : U N L O C K {firstIdInLine = false;};
UNTIL : U N T I L {firstIdInLine = false;};
VARIANT : V A R I A N T {firstIdInLine = false;};
VERSION : V E R S I O N {firstIdInLine = false;};
WEND : W E N D {firstIdInLine = false;};
WHILE : W H I L E {firstIdInLine = false;};
WIDTH : W I D T H {firstIdInLine = false;};
WITH : W I T H {firstIdInLine = false;};
WITHEVENTS : W I T H E V E N T S {firstIdInLine = false;};
WRITE : W R I T E {firstIdInLine = false;};
XOR : X O R {firstIdInLine = false;};

UI_BEGINPROPERTY: B E G I N P R O P E R T Y {firstIdInLine = false; inUIProperty = true;};
UI_ENDPROPERTY: E N D P R O P E R T Y {firstIdInLine = false; inUIProperty = false;};

//
LINE_CONTINUATION : '_' '\r'? '\n' -> skip;
NEWLINE :  ('\r'? '\n' | ':' '\r'? '\n') {firstIdInLine = true;};
END_OF_STMT : ':' ' ';
COMMENT :  ('\'' | ':'? REM ' ') (LINE_CONTINUATION | ~('\r' | '\n' ))*   ('\r'? '\n' | EOF) {firstIdInLine = true;}
           | REM ('\r'? '\n' | EOF) {firstIdInLine = true;};
// symbols
COMMA : ',';
DOT : '.';
SEMI_COLON : ';';
AMPERSAND : '&';
ASSIGN_PARAM : ':=';
DIV : '\\' | '/';
EQ : '=';
GEQ : '>=';
GT : '>';
LEQ : '<=';
LPAREN : '(';
LT : '<';
MINUS : '-';
MINUS_EQ : '-=';
MULT : '*';
NEQ : '<>';
PLUS : '+';
PLUS_EQ : '+=';
POW : '^';
RPAREN : ')';
L_SQUARE_BRACKET : '[';
R_SQUARE_BRACKET : ']';

// literals
IMAGE_VALUE: '$'? '"' ~('"')*  '"' ':' ([0-9] | [A-F])+; //([0-9] | [A-F])([0-9] | [A-F])([0-9] | [A-F]);
STRINGLITERAL : '"' (~["\r\n] | '""')* '"';

CURLY_LITERAL : '{' ~('}')* '}';
DATELITERAL : '#' (~[#,\r\n])* '#';
COLORLITERAL : '&H' [0-9A-F]+ '&'?;
INTEGERLITERAL : ('0'..'9')+ ( ('e' | 'E') INTEGERLITERAL)* ('%' | '&' | '^' | '#'  | '@')?;
DOUBLELITERAL :  ('0'..'9')* '.' ('0'..'9')+ ( ('e' | 'E') (PLUS|MINUS)? ('0'..'9')+)* ('#' | '!' | '@')?;

//fragment INTEGER_SUFFIX
//    :   '%'  // Integer 16 bit signed (default)
//    |   '&'  // Long 32 bit signed
//    |   '^'  // LongLong 64bit signed
//    ;

//fragment FLOAT_SUFFIX
//    :   '!'  // Single
//    |   '#'  // Double (default)
//    |   '@'  // Currency
//    ;

FILENUMBER : '#' LETTERORDIGIT+ '%'?;

SHORTCUT : '^' LETTERORDIGIT;

BRACKET_IDENTIFIER : '[' ~(']')+ ']'
;

IDENTIFIER : LETTER (LETTERORDIGIT)* TYPE_HINT? {firstIdInLine = false;};

WS : [ \t]+ -> skip;

// letters
fragment LETTER : [a-zA-Z_.!]
// Os caracteres a parecem apÃƒÆ’Ã‚Â³s a conversÃƒÆ’Ã‚Â£o de pdf em texto por conta da VDI
// Ache a tabela UNICODE em http://unicode-table.com/en/
        | '\u00C3'  // Ã
        | '\u00C7'  // Ç
        | '\u00D5'  // Õ     
        | '\u00E3'  // ã
        | '\u00E2'  // â
        | '\u00C2'  // Â
        | '\u00F5'  // õ
        | '\u00FA'  // ú
        | '\u00DA'  // Ú                  
        | '\u00E7'  // ç
        ;
//fragment TYPE_HINT :   '&'|'%'|'#'|'!'|'@'|'$'
fragment TYPE_HINT :   '&'|'%'|'#'|'@'|'$'  //  removido '!' por ser utilizado no VB para access fields -> Dados!<field>
;      
fragment LETTERORDIGIT : [a-zA-Z0-9_.!]
// Os caracteres a parecem apÃƒÆ’Ã‚Â³s a conversÃƒÆ’Ã‚Â£o de pdf em texto por conta da VDI
// Ache a tabela UNICODE em http://unicode-table.com/en/
        | '\u00C3'  // Ã
        | '\u00C7'  // Ç
        | '\u00D5'  // Õ     
        | '\u00E3'  // ã
        | '\u00E2'  // â
        | '\u00C2'  // Â
        | '\u00F5'  // õ
        | '\u00FA'  // ú
        | '\u00DA'  // Ú                  
        | '\u00E7'  // ç
;

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