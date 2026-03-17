package edu.umich.bolle;

import java.util.ArrayList;
import java.util.List;

// class that uses tokenizer - takes user input string
// looks at each char, and converts them to tokens the
// parser can make sense of. Tokens put into a list,
// later consumed by parser to build AST to recursively interpret
// language correctly
public class Tokenizer {
    public List <Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            // charAt part of java String library
            // returns value at specified character index
            char c = input.charAt(i);

            // don't tokenize whitespace
            if (Character.isWhitespace(c)) {
                // advance head to next readable character
                i++;
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                // stringbuilder constructor for numeral storage
                StringBuilder number = new StringBuilder();

                while (i < input.length() && (Character.isDigit(input.charAt(i)) ||
                        input.charAt(i) == '.')) {
                    number.append(input.charAt(i));
                    // advance head AFTER appending to StringBuilder
                    i++;
                }

                tokens.add(new Token(TokenType.NUMBER, number.toString()));
                continue;
            }

            // handle reading variables
            if (Character.isLetter(c)) {
                // stringbuilder constructor object for storing variables
                StringBuilder identifier = new StringBuilder();

                while (i < input.length() && Character.isLetterOrDigit(input.charAt(i))) {
                    identifier.append(input.charAt(i));
                    i++;
                }

                tokens.add(new Token(TokenType.IDENTIFIER, identifier.toString()));
                continue;
            }
            // switch case list for symbol identification
            switch (c) {
                case '+' : tokens.add(new Token(TokenType.PLUS, "+"));
                break;
                case '-' : tokens.add(new Token(TokenType.MINUS, "-"));
                break;
                case '/' : tokens.add(new Token(TokenType.DIVIDE, "/"));
                break;
                case '*' : tokens.add(new Token(TokenType.MULTIPLY, "*"));
                break;
                case '^' : tokens.add(new Token(TokenType.POWER, "^"));
                break;
                case '=' : tokens.add(new Token(TokenType.ASSIGN, "="));
                break;
                case '(' : tokens.add(new Token(TokenType.LPAREN, "("));
                break;
                case ')' : tokens.add(new Token(TokenType.RPAREN, ")"));
                break;
                default:
                    throw new RuntimeException("Unexpected Character: " + c);
            }

            i++;
        }
        // EOF handling
        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}
