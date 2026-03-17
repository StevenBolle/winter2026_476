package edu.umich.bolle;

public class Token {
    // identifies the type of token that will be used by parser

    // type of token
    private final TokenType type;

    // what the string value of the input actually is
    private final String text;

    // constructor
    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
    }

    // return value of token
    public String getText() {
        return text;
    }

    // return token category, parser uses
    public TokenType getType() {
        return type;
    }

    // debug statement. comment out later if not needed. - smb
    @Override
    public String toString() {
        return "Token {" + "type = " + type
                 + ", text = " + text + "}";
    }
}
