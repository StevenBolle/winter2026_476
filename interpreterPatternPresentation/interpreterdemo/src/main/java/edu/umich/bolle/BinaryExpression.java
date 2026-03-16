package edu.umich.bolle;

public abstract class BinaryExpression implements Expression {
    // this class is what is used to read inner nodes from AST tree
    // has references to left and right children in the AST tree
    protected Expression left;
    protected Expression right;

    // constructor for BinaryExpression
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    // this method implemented by the concrete subclasses
    @Override
    public abstract double interpret(Context context);
}
