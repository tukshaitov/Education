package edu.pattern.gof.proxy;

/**
 * Created by Eldar on 11/8/2015.
 */
public interface ExecutionPlan {
    void addTask(Task task);

    void execute();

    void replaceTask(Task source, Task to);

    Task getCurrentExecutionTask();

    ExecutionStatus getCurrentExecutionStatus();
}
