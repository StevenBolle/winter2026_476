package edu.umich.bolle;

public interface Expression {
    // root abstraction for interpreter pattern
    double interpret(Context context);
}
