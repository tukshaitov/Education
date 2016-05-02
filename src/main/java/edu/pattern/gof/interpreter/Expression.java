package edu.pattern.gof.interpreter;

/**
 * Created by Eldar on 11/22/2015.
 */
public interface Expression {
    public class Context implements Cloneable{
        private String source;
        private int from;
        private int end;

        public Context(String source) {
            this.source = source;
        }

        public String getSource() {
            return source;
        }

        protected void setSource(String source) {
            this.source = source;
        }

        protected int getFrom() {
            return from;
        }

        protected void setFrom(int from) {
            this.from = from;
        }

        protected int getEnd() {
            return end;
        }

        protected void setEnd(int end) {
            this.end = end;
        }

        @Override
        protected Context clone(){
            try {
                return (Context)super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }
    boolean evaluate(Context context);
}
