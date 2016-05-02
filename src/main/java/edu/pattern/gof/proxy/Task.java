package edu.pattern.gof.proxy;

import java.time.LocalDateTime;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Task implements Cloneable {
    private String name;
    private String instruction;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private Mode mode;
    private ExecutionStatus executionStatus;

    public Task(String name, String instruction, LocalDateTime beginDateTime, LocalDateTime endDateTime, Mode mode) {
        this.name = name;
        this.instruction = instruction;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public String getInstruction() {
        return instruction;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Mode getMode() {
        return mode;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(ExecutionStatus executionStatus) {
        this.executionStatus = executionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (instruction != null ? !instruction.equals(task.instruction) : task.instruction != null) return false;
        if (beginDateTime != null ? !beginDateTime.equals(task.beginDateTime) : task.beginDateTime != null)
            return false;
        if (endDateTime != null ? !endDateTime.equals(task.endDateTime) : task.endDateTime != null) return false;
        return mode == task.mode;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
        result = 31 * result + (beginDateTime != null ? beginDateTime.hashCode() : 0);
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        result = 31 * result + (mode != null ? mode.hashCode() : 0);
        return result;
    }

    @Override
    protected Task clone() {
        try {
            return (Task) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
