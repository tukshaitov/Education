package edu.pattern.gof.interpreter;

/**
 * Created by Eldar on 11/22/2015.
 */
public class OrExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public OrExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    @Override
    public boolean evaluate(Context context) {
        return this.leftExpression.evaluate(context) || this.rightExpression.evaluate(context);
    }
}
