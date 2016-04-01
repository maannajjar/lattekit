grammar Latte;


unit :  (classDeclaration|codeChar)*;
classDeclaration: CLASS BRACE_OPEN classBody BRACE_CLOSE;
classBody: (function|codeChar)*;

function      : FUN '=' codeChar+
              | FUN '{' codeChar+ '}'
              | layoutFunction;

layoutFunction: FUN '=' 'lxml' '(' layoutString ')'
        | FUN '{' 'lxml' '(' layoutString ')'  '}';


layoutString    : '"""' layoutBody '"""';

layoutBody  : (xmlTag|inlineCode|CHAR+)*;
inlineCode  : '$' '{' (layoutString|codeChar)* '}';

codeChar        : CHAR|'<'|'>'|'/>'|'/'|'{'|'}'|'('|')'|'"'|'='|'\'' | '@' | ':'|'lxml';


xmlTag      : '<' xmlName layoutProp* '/>'
            | '<' xmlName layoutProp* '>' layoutBody '</' CHAR+ '>'
            ;
xmlName     : CHAR+;

layoutProp  :   CHAR+ '=' '"' (CHAR|'@'|'/')* '"'
            |   CHAR+ '=' '"' resource '"'
            |   CHAR+ '=' inlineCode
            ;
resource    : '@' CHAR+ '/' CHAR+;


CLASS : ('open' WS)? 'class' WS+ ~[;{:,]+ WS* (':' WS* ~[;{:]+)? WS*;

FUN: ('override' WS)? 'fun' WS+ ~[{=]+ WS+;
BRACE_OPEN : '{';
BRACE_CLOSE : '}';
PAREN_OPEN : '(';
PAREN_CLOSE : ')';
CHAR: ~[<>/{}"= ];
WS  :  [ \t\u000C]+ -> skip;
