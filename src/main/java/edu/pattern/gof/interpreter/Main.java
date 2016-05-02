package edu.pattern.gof.interpreter;

/**
 * Given a language, define a represention for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
 */
public class Main {
    public static void main(String ... args){

        Expression.Context context = new Expression.Context(" Hello world");

        Word hello = new Word("Hello");
        Word world = new Word("World").setIgnoreCase(true).setNot(false);
        AndExpression and = new AndExpression(hello, world).setIsSequence(true);
        System.out.println("Test And: " + and.evaluate(context));

        OrExpression or = new OrExpression(hello, world);
    }
}
