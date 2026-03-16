package edu.umich.bolle;

public class SubtractExpression extends BinaryExpression {
    // concrete subclass that uses BinaryExpression, handles inner nodes of AST
    // defines how interpret handles subtraction
    public SubtractExpression(Expression left, Expression right) {
        super (left, right);
    }

    @Override
    public double interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}
