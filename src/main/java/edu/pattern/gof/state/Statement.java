package edu.pattern.gof.state;

import java.util.ArrayList;
import java.util.List;

/**
* Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
* This  type  of  design  pattern comes under behavior pattern
*/
public class Statement {
    private State state = new StateClosed();

    public void open() {
        state.open();
    }

    public void openReadOnly() {
        state.openReadOnly();
    }

    public void close() {
        state.close();
    }

    public void rollback() {
        state.rollback();
    }

    public void execute(String sql) {
        state.execute(sql);
    }

    public void executeUpdate(String sql) {
        state.executeUpdate(sql);
    }

    public void commit() {
        state.commit();
    }

    private interface State {
        void open();

        void openReadOnly();

        void close();

        void rollback();

        void execute(String sql);

        void executeUpdate(String sql);

        void commit();
    }

    private class StateReadOnly implements State {
        @Override
        public void open() {
            Statement.this.state = new StateTransactional();
        }

        @Override
        public void openReadOnly() {
        }

        @Override
        public void close() {
            Statement.this.state = new StateClosed();
        }

        @Override
        public void rollback() {
        }

        @Override
        public void execute(String sql) {
            System.out.println("Sql " + sql + " was executed.");
        }

        @Override
        public void executeUpdate(String sql) {
            throw new IllegalStateException("Update operations is not supported in read only mode.");
        }

        @Override
        public void commit() {
        }
    }

    private class StateTransactional implements State {

        private List<String> sqlList = new ArrayList<String>();

        @Override
        public void open() {
        }

        @Override
        public void openReadOnly() {
            clearState();
            Statement.this.state = new StateReadOnly();
        }

        @Override
        public void close() {
            clearState();
            Statement.this.state = new StateClosed();
        }

        @Override
        public void rollback() {
            System.out.println(sqlList.size() + " operations were rollback");
        }

        @Override
        public void execute(String sql) {
            this.sqlList.add(sql);
            System.out.println("Sql " + sql + " was executed.");
        }

        @Override
        public void executeUpdate(String sql) {
            this.sqlList.add(sql);
            System.out.println("Sql " + sql + " was executed.");
        }

        @Override
        public void commit() {
            System.out.println(sqlList.size() + " operations were commit.");
        }

        private void clearState() {
            sqlList = null;
        }
    }

    private class StateClosed implements State {
        @Override
        public void open() {
            Statement.this.state = new StateTransactional();
        }

        @Override
        public void openReadOnly() {
            Statement.this.state = new StateReadOnly();
        }

        @Override
        public void close() {
        }

        @Override
        public void rollback() {
            throw new IllegalStateException("Rollback could not executed for closed statement.");
        }

        @Override
        public void execute(String sql) {
            throw new IllegalStateException("Sql could not executed for closed statement.");
        }

        @Override
        public void executeUpdate(String sql) {
            throw new IllegalStateException("Sql could not executed for closed statement.");
        }

        @Override
        public void commit() {
            throw new IllegalStateException("Commit could not executed for closed statement.");
        }
    }
}
