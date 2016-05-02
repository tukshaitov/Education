package edu.pattern.gof.mediator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Manager implements Runnable {
    private final Object mutex = new Object();
    private boolean isReported = false;
    private ReportType reportType;
    private volatile int tl = 0;
    private Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void report(ReportType reportType) {
        this.reportType = reportType;
        this.isReported = true;
    }

    public void run() {
        while (true) {
            try {
                synchronized (mutex) {
                    if (isReported) {
                        Thread.sleep(1000);
                        if (reportType == ReportType.COMPILED) {
                            mediator.fromManager(TaskType.DEPLOY);
                        } else if (reportType == ReportType.DEPLOYED) {
                            mediator.fromManager(TaskType.TEST);
                        } else if (reportType == ReportType.TESTED) {
                            mediator.fromManager(TaskType.NEW_TASK);
                        }
                    } else if (tl >= 10000) {
                        tl = 0;
                        mediator.fromManager(TaskType.NEW_TASK);
                    }
                    int slp = 100;
                    tl += slp;
                    Thread.sleep(slp);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
