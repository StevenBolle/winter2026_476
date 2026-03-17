package edu.umich.bolle;

// outputs AST structure to illustrate to user how the interpreter
// recursively checks the terminal and non-terminal nodes
// to build an expression and return the result
public class ASTPrint {

    // entry point at root of AST
    public static void print(Expression expression) {
        print(expression, 0);
    }

    // print helper method
    private static void print(Expression expression, int level) {
        // indentation
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }

        // get identifier of node
        if (expression instanceof NumberExpression) {
            NumberExpression num = (NumberExpression) expression;
            System.out.println("Number(" + num.getValue() + ")");
            return;
        } else if (expression instanceof VariableExpression) {
            VariableExpression var = (VariableExpression) expression;
            System.out.println("Variable(" + var.getName() + ")");
            return;
        } else if (expression instanceof AssignmentExpression) {
            AssignmentExpression assexp = (AssignmentExpression) expression;
            System.out.println("Assignment(" + assexp.getVariableName() + ")");
            print(assexp.getExpression(), level + 1);
            return;
        } else if (expression instanceof AddExpression) {
            System.out.println("Addition");
        } else if (expression instanceof SubtractExpression) {
            System.out.println("Subtraction");
        } else if (expression instanceof MultiplyExpression) {
            System.out.println("Multiplication");
        } else if (expression instanceof DivideExpression) {
            System.out.println("Division");
        } else if (expression instanceof PowerExpression) {
            System.out.println("Power");
        } else {
            System.out.println("Unknown expression, not in language.");
        }

        // call recursively if binary expression with a left amd right children exist
        // along with a parent
        if (expression instanceof BinaryExpression) {
            BinaryExpression binex = (BinaryExpression) expression;
            print(binex.left, level + 1);
            print(binex.right, level + 1);
        }
    }
} // end of ASTPrint helper class
