package edu.pattern.gof.interpreter;

/**
 * Created by Eldar on 11/22/2015.
 */
public class AndExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private boolean isSequence;

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public AndExpression setIsSequence(boolean isSequence) {
        this.isSequence = isSequence;
        return this;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    @Override
    public boolean evaluate(Context context) {
        if(isSequence) {
            Context clone = context.clone();
            boolean eval = this.leftExpression.evaluate(clone);
            clone.setSource(clone.getSource().substring(clone.getEnd() + 1));
            return eval && rightExpression.evaluate(clone);
        }
        return this.leftExpression.evaluate(context) && this.rightExpression.evaluate(context);
    }
}
