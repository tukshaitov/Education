package edu.pattern.gof.state;

/**
 * Created by eitukshaitov on 06.10.2015.
 */
public class Main {
    public static void main(String... args) {
        Statement statement = new Statement();

        try {
            statement.execute("SELECT * FROM users u");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        statement.openReadOnly();
        statement.execute("SELECT * FROM users u");

        try {
            statement.executeUpdate("UPDATE users u SET name='admin' where u.id=0");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        statement.open();
        statement.execute("SELECT * FROM users u");
        statement.executeUpdate("UPDATE users u SET name='admin' where u.id=0");
        statement.commit();
        statement.close();

    }
}

