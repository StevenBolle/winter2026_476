package edu.umich.bolle;

public class VariableExpression implements Expression {
    // concrete class for terminal expressions
    // when variables like x, x + 5, x * y occupy leaf positions in AST
    // this class acts like variable storage for interpreter
    private String variableName;

    // constructor
    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    public String getName() {
        return variableName;
    }

    @Override
    public double interpret(Context context) {
        return context.getVariableValue(variableName);
    }
}
