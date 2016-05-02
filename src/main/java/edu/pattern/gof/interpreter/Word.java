package edu.pattern.gof.interpreter;

/**
 * Created by Eldar on 11/22/2015.
 */
public class Word implements Expression {
    private String word;
    private boolean ignoreCase;
    private boolean not;

    public Word(String word) {
        this.word = word;
    }

    public Word setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
        return this;
    }

    public Word setNot(boolean not) {
        this.not = not;
        return this;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean evaluate(Context context) {
        if (context.getSource() != null && this.word != null && this.word != "" && !this.word.equals(" ")) {
            int position = -1;
            String source = context.getSource();

            if (this.ignoreCase)
                position = source.toLowerCase().indexOf(this.word.toLowerCase());
            else
                position = source.indexOf(this.word);

            boolean eval = false;
            int end = -1;

            if(position > -1) {
                end = position + this.word.length();
                if(end < source.length()) {
                    if (context.getSource().charAt(end) == ' ')
                        eval = true;
                }
                else eval = true;
            }

            if(eval && position > 0) {
                if(!(source.charAt(position - 1) == ' '))
                    eval = false;
            }

            context.setFrom(position);

            if (!eval) context.setEnd(-1);
            else context.setEnd(end - 1);

            if (not)
                return !eval;
            else
                return eval;

        } else return false;
    }
}