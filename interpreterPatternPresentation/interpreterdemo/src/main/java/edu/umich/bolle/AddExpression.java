package edu.umich.bolle;

public class AddExpression extends BinaryExpression {
    // defines the way interpret method performs addition
    // concrete, non-terminal expression (inner node of AST)
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    // evaluates addition expression recursively checking left and right
    @Override
    public double interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}
