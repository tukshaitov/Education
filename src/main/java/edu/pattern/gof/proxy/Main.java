package edu.pattern.gof.proxy;

import java.time.LocalDateTime;

/**
* Provide a surrogate or placeholder for another object to control access to it.
*
* Also Known As Surrogate
*/

public class Main {
    public static void main(String... args) {
        CopyOnWriteProxy proxy = new CopyOnWriteProxy();
        proxy.addTask(new Task("Task One", "Change Color", LocalDateTime.now(), LocalDateTime.now().plusMinutes(1), Mode.SERIAL));
        System.out.println(proxy);

        CopyOnWriteProxy copyProxy = proxy.copyOnWrite();
        proxy.copyOnWrite();
        copyProxy.getCurrentExecutionTask();
        // System.out.println(copyProxy);
        // System.out.println(proxy);

        proxy.addTask(new Task("Task Two", "Change Background", LocalDateTime.now(), LocalDateTime.now().plusMinutes(1), Mode.SERIAL));
        System.out.println(proxy);
        System.out.println(copyProxy);

//        copyProxy.addTask(new Task("Task Three", "Change Font", LocalDateTime.now(),LocalDateTime.now().plusMinutes(1),Mode.SERIAL));
//
//        System.out.println(proxy);
//        System.out.println(copyProxy);

    }
}


