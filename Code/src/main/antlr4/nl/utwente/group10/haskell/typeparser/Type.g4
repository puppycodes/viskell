grammar Type;

CT : [A-Z][a-z]+ ;
VT : [a-z]+ ;
WS : [ \t\r\n]+ -> skip ;

type : typeClasses ? innerType ;
innerType : functionType | compoundType ; // function type
functionType : compoundType '->' innerType ;
compoundType : constantType | variableType | tupleType | listType | parenType ;

tupleType : '(' innerType (',' innerType)+ ')' ; // tuple type, k>=2
listType : '[' innerType ']' ;              // list type
parenType : '(' innerType ')' ;             // type with parentheses

constantType : typeConstructor (WS* innerType)* ;
typeConstructor : CT ;
variableType : VT ;

typeClasses : '(' typeWithClass (',' typeWithClass)* ')' '=>' | typeWithClass '=>' ;
typeWithClass : typeClass WS* classedType ;
classedType : VT ;
typeClass : CT ;
