package edu.pattern.gof.mediator;

/**
 * Mediator pattern is used to reduce communication complexity between multiple objects or
 * classes. This pattern provides a mediator class which normally handles all the communications
 * between  different  classes  and  supports  easy  maintainability  of  the  code  by  loose  coupling.
 * Mediator pattern falls under behavioral pattern category.
 */
public class Main {

    public static void main(String... args) {
        Developer developer = new Developer();
        QA qa = new QA();
        Manager manager = new Manager();
        Program program = new Program();

        Mediator mediator = new Mediator(manager, program, developer, qa);
        new Thread(developer).run();
        new Thread(qa).run();
        new Thread(manager).run();
        new Thread(program).run();
    }

}

