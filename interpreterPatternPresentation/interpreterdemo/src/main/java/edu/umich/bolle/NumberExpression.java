package edu.umich.bolle;

// class that looks at terminal nodes of AST that contain integers
public class NumberExpression implements Expression {
    // this class is base case for interpreter eval
    private double value;

    // constructor
    public NumberExpression(double value){
        this.value = value;
    }

    // override interpret in Expression
    @Override
    public double interpret(Context context) {
        return value;
    }
}
