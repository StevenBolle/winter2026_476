package edu.umich.bolle;

import java.util.HashMap;
import java.util.Map;

// this class handles runtime environment of interpreter
// stores variable names and their values
// acts as a symbol table of the formal language to be interpreted
// VariableExpression and AssignmentExpression interact with this
// class to store and retrieve variable values
public class Context {
    // Map used for key value pairs of String and Double, store in hashmap
    // for faster retrieval
    private Map<String, Double> variables = new HashMap<>();

    // retrieves the value of a variable
    public double getVariableValue(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Interpreter Error: Variable'"
                    + name + "' is not defined");
        }
        // get is part of java map util
        return variables.get(name);
    }

    // assign numeric value to a variable
    public void setVariableValue(String name, double value) {
        // put is part of java map util
        variables.put(name, value);
    }
}