package edu.pattern.gof.mediator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Mediator {
    private Manager manager;
    private Program program;
    private Developer developer;
    private QA qa;

    public Mediator(Manager manager, Program program, Developer developer, QA qa) {
        this.manager = manager;
        this.manager.setMediator(this);

        this.program = program;
        this.program.setMediator(this);

        this.developer = developer;
        this.developer.setMediator(this);

        this.qa = qa;
        this.qa.setMediator(this);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public QA getQa() {
        return qa;
    }

    public void setQa(QA qa) {
        this.qa = qa;
    }

    public void fromManager(TaskType taskType) {
        if (this.manager != null) {
            if (taskType == TaskType.DEPLOY) {
                if (this.program != null) {
                    this.program.deploy();
                }
            } else if (taskType == TaskType.TEST) {
                if (this.qa != null) {
                    this.qa.evaluate();
                }
            } else if (this.developer != null) {
                this.developer.setTask(taskType);
            }
        }
    }

    public void fromProgram(Screen screen, boolean isCompiled, boolean isDeployed) {
        if (!isDeployed) {
            if (!isCompiled) {
                if (this.developer != null) {
                    this.developer.setTask(TaskType.RECOMPILE);
                }
            } else {
                if (this.manager != null) {
                    this.manager.report(ReportType.COMPILED);
                }
            }
        } else {
            if (this.manager != null) {
                this.manager.report(ReportType.DEPLOYED);
            }
        }
    }

    public void fromDeveloper(String code) {
        if (this.developer != null) {
            if (this.program != null) {
                this.program.setCode(code);
            }
        }
    }

    public void fromQA(ResponseType responseType) {
        if (responseType == ResponseType.OK || responseType == ResponseType.WARN) {
            if (this.manager != null) {
                this.manager.report(ReportType.TESTED);
            }
        } else if (responseType == ResponseType.ERROR) {
            if (this.developer != null) {
                this.developer.setTask(TaskType.NEW_TASK);
            }
        }
    }
}
