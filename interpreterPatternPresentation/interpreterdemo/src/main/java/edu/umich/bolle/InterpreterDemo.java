package edu.umich.bolle;

import java.util.List;
import java.util.Scanner;


// serves as client class
public class InterpreterDemo {
    public static void main(String[] args) {

        System.out.println("Interpreter Pattern Demo: Arithmetic");
        System.out.println("Type Expressions or enter assignments for variables");
        System.out.println("Type 'q' to exit program.\n");

        // initialize constructors
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        Tokenizer tokenizer = new Tokenizer();

        // while loop with boolean flag for exit
        while (true) {
            System.out.println("> > > ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Interpreter demo exiting.");
                break;
            }
            try {
                // tokenize input
                List<Token> tokens = tokenizer.tokenize(input);

                // parse
                Parser parser = new Parser(tokens);
                Expression expression = parser.parseStatement();

                // interpret the language
                double result = expression.interpret(context);

                // display result to user
                System.out.println("Result: " + result);
            } catch (Exception e) {
                // errors handled at interpreter level
                System.out.println("Error " + e.getMessage());
            }
        }
        // close scanner for safe program exit
        scanner.close();
    }
}
