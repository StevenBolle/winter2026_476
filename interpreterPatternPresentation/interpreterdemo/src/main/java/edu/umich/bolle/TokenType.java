package edu.umich.bolle;

public enum TokenType {
    // ENUM class that defines valid token categories of the language interpreter
    NUMBER,
    IDENTIFIER,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    ASSIGN,
    LPAREN,
    RPAREN,
    POWER,
    EOF // EOF = End of File (special token type for end of user input)
}
