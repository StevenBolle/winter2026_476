package edu.umich.bolle;

import java.util.List;

public class Parser {
    // takes tokens made by tokenizer and builds AST
    // AST made of Expression objects
    private List<Token> tokens;
    private int position;

    // constructor builds list made of parsable tokens
    // position points head at start of List
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.position = 0;
    }

    public Expression parseStatement() {
        if (peek().getType() == TokenType.IDENTIFIER &&
        peekNext().getType() == TokenType.ASSIGN) {
            String variableName = consume(TokenType.IDENTIFIER).getText();
            consume(TokenType.ASSIGN);
            Expression valueExpression = parseExpression();
            return new AssignmentExpression(variableName, valueExpression);
        }
        return parseExpression();
    }

    private Expression parseExpression() {
        Expression left = parseTerm();
        while (match(TokenType.PLUS) || match(TokenType.MINUS)) {
            Token operator = previous();
            Expression right = parseTerm();

            if (operator.getType() == TokenType.PLUS) {
                left = new AddExpression(left, right);
            } else {
                left = new SubtractExpression(left, right);
            }
        }
        return left;
    }

    private Expression parseTerm() {
        Expression left = parsePower();
        while (match(TokenType.MULTIPLY) || match(TokenType.DIVIDE)) {
            Token operator = previous();
            Expression right = parsePower();

            if (operator.getType() == TokenType.MULTIPLY) {
                left = new MultiplyExpression(left, right);
            } else {
                left = new DivideExpression(left, right);
            }
        }
        return left;
    }

    private Expression parsePower() {
        Expression left = parseFactor();
        while (match(TokenType.POWER)) {
            Expression right = parseFactor();
            left = new PowerExpression(left, right);
        }
        return left;
    }

    private Expression parseFactor() {
        if (match(TokenType.NUMBER)) {
            return new NumberExpression(Double.parseDouble(previous().getText()));
        }
        if (match(TokenType.IDENTIFIER)) {
            return new VariableExpression((previous().getText()));
        }
        if (match(TokenType.LPAREN)) {
            Expression exp = parseExpression();
            consume(TokenType.RPAREN);
            return exp;
        }
        throw new RuntimeException("Unexpected Token" + peek().getText());
    }

    // ---------- PARSER UTILITIES ----------
    private boolean match(TokenType type) {
        if (check(type)) {
            position++;
            return true;
        }
        return false;
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().getType() == type;
    }

    private Token consume(TokenType type) {
        if (check(type)) return tokens.get(position++);
        throw new RuntimeException("Expected Token: " + type);
    }

    private Token peek() {
        return tokens.get(position);
    }

    private Token peekNext() {
        if (position + 1 >= tokens.size()) return tokens.get(tokens.size() - 1);
        return tokens.get(position + 1);
    }

    private Token previous() {
        return tokens.get(position - 1);
    }

    private boolean isAtEnd() {
        return peek().getType() == TokenType.EOF;
    }

} // end of Parser class
