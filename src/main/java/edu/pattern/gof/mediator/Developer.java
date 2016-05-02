package edu.pattern.gof.mediator;

import java.util.UUID;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Developer implements Runnable {
    private TaskType taskType;
    private volatile String code;
    private Object mutex = new Object();
    private Mediator mediator;
    private volatile boolean isNewTask;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getCode() {
        return code;
    }

    public void setTask(TaskType taskType) {
        if (taskType == TaskType.DEPLOY || taskType == TaskType.TEST)
            throw new IllegalArgumentException();

        synchronized (mutex) {
            this.taskType = taskType;
            this.isNewTask = true;
        }
    }

    public void completeTask() {
        this.isNewTask = false;
    }

    public void run() {
        while (true) {
            try {
                if (isNewTask) {
                    Thread.sleep(5000);
                    this.code = UUID.randomUUID().toString();
                    mediator.fromDeveloper(this.code);
                }
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
