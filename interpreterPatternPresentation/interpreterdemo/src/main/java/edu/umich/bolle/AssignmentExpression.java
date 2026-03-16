package edu.umich.bolle;

public class AssignmentExpression implements Expression {
    // Concrete class for non-terminal expression
    // if we assign result of expression to a variable
    // like x = 10, then we have y = x + 5
    // uses context class to store variable values in
    // interpreter runtime environment
    private String variableName;
    private Expression expression;

    // constructor
    public AssignmentExpression(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    // evaluates the assignment expression
    // interprets right hand side first to determine numeric value
    // store value in context using variable name and returns assigned value
    @Override
    public double interpret(Context context) {
        double value = expression.interpret(context);
        context.setVariableValue(variableName, value);
        return value;
    }
}
