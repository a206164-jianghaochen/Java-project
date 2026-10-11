%{
package com.example.lexer;
import java.io.IOException;
%}

%unicode
%line
%column

%%
// 识别关键字
"public" { System.out.println("识别到关键字: public"); return "PUBLIC"; }
"class" { System.out.println("识别到关键字: class"); return "CLASS"; }
// 识别标识符
[a-zA-Z_$][a-zA-Z0-9_$]* { System.out.println("识别到标识符: " + yytext()); return "IDENTIFIER"; }
// 识别数字
[0-9]+ { System.out.println("识别到数字: " + yytext()); return "NUMBER"; }
[ \t\r\n]+ { /* 忽略空白字符 */ }
. { System.out.println("识别到其他字符: " + yytext()); return "OTHER"; }
%%
int yywrap() {
    return 1;
}