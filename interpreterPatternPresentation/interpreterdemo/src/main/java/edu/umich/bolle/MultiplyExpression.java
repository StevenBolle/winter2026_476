package edu.umich.bolle;

public class MultiplyExpression extends BinaryExpression {
    // concrete class, BinaryExpression is super class
    // defines how interpret handles multiplication
    public MultiplyExpression(Expression left, Expression right) {
        super (left, right);
    }

    @Override
    public double interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
