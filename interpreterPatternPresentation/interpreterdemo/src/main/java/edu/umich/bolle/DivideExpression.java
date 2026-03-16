package edu.umich.bolle;

public class DivideExpression extends BinaryExpression {
    // defines how interpret handles division.
    // DivideExpression is a concrete subclass of super class BinaryExpression
    public DivideExpression(Expression left, Expression right) {
        super (left, right);
    }

    @Override
    public double interpret(Context context) {
        double numerator = left.interpret(context);
        double denominator = right.interpret(context);

        // check for division by zero, throw error if true
        if (denominator == 0) {
            throw new ArithmeticException("Interpreter Error: Division by Zero.");
        }

        return numerator / denominator;
    }
}
