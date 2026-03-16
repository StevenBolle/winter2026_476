package edu.umich.bolle;

public class PowerExpression extends BinaryExpression {
    // concrete sub class of BinaryExpression
    // defines how interpret handles raising to power
    public PowerExpression(Expression left, Expression right) {
        super (left, right);
    }

    @Override
    public double interpret(Context context) {
        double base = left.interpret(context);
        double exponent = right.interpret(context);

        return Math.pow(base, exponent);
    }
}
