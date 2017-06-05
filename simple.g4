grammar simple;

//tokens {INDENT, DEDENT} 
// OPERATIONS WITH HIGHEST PRECEDENCE ARE THE DEEPEST IN THE TREE
/* entry point to the parser */
//program
    //: ( instruction NEWLINE ';'? ) * 
    //;
//
//instruction
    //: NEWLINE
    //| func_def
    //| class_def
    //| additionExp
    //| statement
    //;
//
//statement
    //: ( func_call NEWLINE ) *
    //;
//
//func_call
    //: NAME parameters 
    //;
//
//func_def
    //: DEF NAME parameters ':' ( NEWLINE INDENT statement 
                                //| NEWLINE statement
                                //) * 
    //;
//
//parameters 
    //: '(' (NAME (',' NAME)* )? ')'
    //;
//    
//class_def
    //: CLASS NAME ':' ( NEWLINE INDENT func_def 
                                //| NEWLINE func_def
                                //) *
    //;
//
//expression
//    :    evaluation (';' evaluation)? NEWLINE   
//    ;

program
    : ( instruction )* NEWLINE EOF
    ;

block
    : ( instruction (NEWLINE)* ) * 
    | 
    ;

instruction
    :  conditionalStatement
    |  assignment
//    |  importStatement 
//    |  funcDefinition 
//    |  funcCall
//    |  evaluation
//    |  assignment
//    |  retStatement
    ;

conditionalStatement
    : IF test ':' NEWLINE /* INDENT */ block 
    ;


test
    : evaluation test_op evaluation
    ;
test_op
    : '=='
    | '!='
    | '>='
    | '<='
    | '<'
    | '>'
    ;

assignment
    : NAME '=' evaluation
    ;

evaluation
    : additionExp
    ;

/* Addition and subtraction have the lowest precedence. */
// additionExp :multiplyExp ('+' multiplyExp | '-' multiplyExp)*
additionExp
    :    multiplyExp 
         ( '+' multiplyExp 
         | '-' multiplyExp
         )* 
    ;

/* Multiplication and division have a higher precedence. */
multiplyExp
    :    atomExp
         ( '*' atomExp 
         | '/' atomExp
         )* 
    ;

/* An expression atom is the smallest part of an expression: a number. Or 
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExp'. As you can see, an 'atomExp' has the highest precedence. */
atomExp
    :    Number
    |    '(' additionExp ')'
    ;

/* A number: can be an integer value, or a decimal value */
//()'0'..'9')+ ('.' ('0'..'9')+)?
Number
    : [0-9]+
    ;

/* We're going to ignore all white space characters */
WS  
    :   (' ' | '\t' ) -> skip
    ;
    
    
//DEF : 'def';



NEWLINE: '\r'? '\n' | '\r' ;
//CLASS: 'class';
IMPORT: 'import';
IF: 'if';
NAME: [_a-zA-Z][_a-zA-Z0-9]*;



//NEWLINE
// : ( {atStartOfInput()}? SPACES
//   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
//   )
//   {
//     String newLine = getText().replaceAll("[^\r\n\f]+", "");
//     String spaces = getText().replaceAll("[\r\n\f]+", "");
//     int next = _input.LA(1);
//     if (opened > 0 || next == '\r' || next == '\n' || next == '\f' || next == '#') {
//       // If we're inside a list or on a blank line, ignore all indents,
//       // dedents and line breaks.
//       skip();
//     }
//     else {
//       emit(commonToken(NEWLINE, newLine));
//       int indent = getIndentationCount(spaces);
//       int previous = indents.isEmpty() ? 0 : indents.peek();
//       if (indent == previous) {
//         // skip indents of the same size as the present indent-size
//         skip();
//       }
//       else if (indent > previous) {
//         indents.push(indent);
//         emit(commonToken(simpleParser.INDENT, spaces));
//       }
//       else {
//         // Possibly emit more than 1 DEDENT token.
//         while(!indents.isEmpty() && indents.peek() > indent) {
//           this.emit(createDedent());
//           indents.pop();
//         }
//       }
//     }
//   }
// ;

fragment SPACES
 : [ \t]+
 ;
