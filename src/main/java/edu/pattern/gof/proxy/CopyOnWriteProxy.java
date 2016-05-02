package edu.pattern.gof.proxy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Eldar on 11/8/2015.
 */
public class CopyOnWriteProxy implements ExecutionPlan {

    JobExecutionPlan executionPlan;
    AtomicInteger atomicCounter = new AtomicInteger(1);

    public CopyOnWriteProxy() {
        this.executionPlan = new JobExecutionPlan();
    }

    @Override
    public void addTask(Task task) {
        ensursaingExecutionPlanNotShared();
        this.executionPlan.addTask(task);
    }

    @Override
    public void execute() {
        ensursaingExecutionPlanNotShared();
        this.executionPlan.execute();
    }

    @Override
    public void replaceTask(Task source, Task to) {
        ensursaingExecutionPlanNotShared();
        this.executionPlan.replaceTask(source, to);
    }

    @Override
    public Task getCurrentExecutionTask() {
        return executionPlan.getCurrentExecutionTask();
    }

    @Override
    public ExecutionStatus getCurrentExecutionStatus() {
        return executionPlan.getCurrentExecutionStatus();
    }

    public void ensursaingExecutionPlanNotShared() {
        if (atomicCounter.get() > 1 && this.executionPlan != null) {
            this.executionPlan = executionPlan.clone();
            atomicCounter.decrementAndGet();
            atomicCounter = new AtomicInteger(1);
        }
    }

    /**
     *
     *
     * @return proxy object with current instance state
     */
    public CopyOnWriteProxy copyOnWrite() {
        atomicCounter.incrementAndGet();
        CopyOnWriteProxy proxy = new CopyOnWriteProxy();
        proxy.executionPlan = this.executionPlan;
        proxy.atomicCounter = atomicCounter;
        return proxy;
    }

    @Override
    public String toString() {
        return "CopyOnWriteProxy{" + this.executionPlan + "; atomic counter: " + atomicCounter.get() + "}";
    }
}
