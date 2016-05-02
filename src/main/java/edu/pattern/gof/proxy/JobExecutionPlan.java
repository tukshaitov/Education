package edu.pattern.gof.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Eldar on 11/8/2015.
 */
public class JobExecutionPlan implements ExecutionPlan, Cloneable {

    private List<Task> taskList = new ArrayList<>();
    private volatile Task currentTask;

    @Override
    public void addTask(Task task) {
        synchronized (taskList) {
            taskList.add(task);
        }
    }

    @Override
    public void execute() {
        for (Task task : taskList) {
            this.currentTask = task;
            ExecutionStatus executionStatus = generateStatus();
            this.currentTask.setExecutionStatus(executionStatus);

            if (executionStatus == ExecutionStatus.EXECUTION) {
                try {
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (executionStatus == ExecutionStatus.ERROR)
                break;
        }
    }

    @Override
    public void replaceTask(Task source, Task to) {
        if (source != null && to != null) {
            synchronized (taskList) {
                int indexOf = taskList.indexOf(source);
                if (indexOf > 0) {
                    taskList.add(indexOf, to);
                    taskList.remove(indexOf + 1);
                }
            }
        }
    }

    @Override
    public Task getCurrentExecutionTask() {
        return this.currentTask;
    }

    @Override
    public ExecutionStatus getCurrentExecutionStatus() {
        if (this.currentTask != null)
            return this.currentTask.getExecutionStatus();
        else
            return ExecutionStatus.WAIT;
    }

    public JobExecutionPlan clone() {
        try {
            JobExecutionPlan plan = (JobExecutionPlan) super.clone();
            List<Task> taskList = new ArrayList<>();
            for (Task task : plan.taskList)
                taskList.add(task.clone());

            plan.taskList = taskList;
            return plan;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private ExecutionStatus generateStatus() {
        int min = 0;
        int max = 2;
        ExecutionStatus status = ExecutionStatus.EXECUTION;
        Random random = new Random();
        int num = random.nextInt((max - min) + 1) + min;
        switch (num) {
            case 0:
                status = ExecutionStatus.DONE;
                break;
            case 1:
                status = ExecutionStatus.EXECUTION;
                break;
            case 2:
                status = ExecutionStatus.ERROR;
                break;
        }

        return status;
    }

    @Override
    public String toString() {
        return "JobExecutionPlan{Number of tasks is " + taskList.size() + "; hash code is: " + taskList.hashCode() + "}";
    }
}
