%{
// Package declaration for the generated Java class
package com.example.lexer;
import java.io.IOException;
%}

// Define macros for common character sets
LETTER = [a-zA-Z_]
DIGIT = [0-9]
IDENTIFIER = {LETTER}({LETTER}|{DIGIT})*
WHITESPACE = [ \t\n\r]+

%%

// Variable Declaration
{IDENTIFIER} {WHITESPACE}+ (int|float|double|boolean|char|String) {WHITESPACE}+ {IDENTIFIER} {
    yylval = new TokenValue("VARIABLE_DECLARATION", yytext());
    return TokenType.VARIABLE_DECLARATION;
}

// Assignment
{IDENTIFIER} {WHITESPACE}+ = {WHITESPACE}+ [^;]+ ; {
    yylval = new TokenValue("ASSIGNMENT", yytext());
    return TokenType.ASSIGNMENT;
}

// Selection (if-else)
if {WHITESPACE}+ \( {WHITESPACE}+ [^)]+ {WHITESPACE}+ \) {WHITESPACE}+ \{ [^}]* \} (\s* else \s* \{ [^}]* \})? {
    yylval = new TokenValue("SELECTION_IF_ELSE", yytext());
    return TokenType.SELECTION_IF_ELSE;
}

// Looping (For)
for {WHITESPACE}+ \( {WHITESPACE}* ([^;]*);([^;]*);([^;]*)\) {WHITESPACE}+ \{ [^}]* \} {
    yylval = new TokenValue("LOOPING_FOR", yytext());
    return TokenType.LOOPING_FOR;
}

// Print (assuming System.out.println)
System {WHITESPACE}+ \. {WHITESPACE}+ out {WHITESPACE}+ \. {WHITESPACE}+ println {WHITESPACE}+ \( [^)]* \) ; {
    yylval = new TokenValue("PRINT", yytext());
    return TokenType.PRINT;
}

// Skip whitespace
{WHITESPACE} {}

// Error handling for unrecognized tokens
. {
    yylval = new TokenValue("ERROR", yytext());
    return TokenType.ERROR;
}

%%

// Custom TokenValue class to hold token type and value
class TokenValue {
    private String type;
    private String value;

    public TokenValue(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}


public enum TokenType {
    VARIABLE_DECLARATION,
    ASSIGNMENT,
    SELECTION_IF_ELSE,
    LOOPING_FOR,
    PRINT,
    ERROR
}

// Custom lexer class extending the generated lexer
class MyLexer extends yylex {
    public MyLexer(java.io.Reader reader) {
        super(reader);
    }
}