package edu.pattern.gof.mediator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class QA implements Runnable {
    private final Object mutex = new Object();
    private volatile Screen screen;
    private Mediator mediator;
    private volatile boolean isEvaluate = true;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void evaluate() {
        synchronized (mutex) {
            isEvaluate = true;
        }
    }

    public void notify(Screen screen) {
        synchronized (mutex) {
            this.screen = screen;
        }
    }

    public void run() {
        while (true) {
            try {
                if (this.isEvaluate && this.screen != null) {
                    Thread.currentThread().sleep(2000);
                    ResponseType responseType;
                    switch (screen.getValue()) {
                        case 0:
                            responseType = ResponseType.ERROR;
                            break;
                        case 1:
                            responseType = ResponseType.OK;
                            break;
                        case 2:
                            responseType = ResponseType.WARN;
                            break;
                        default:
                            responseType = ResponseType.NOT_EVALUATED;
                    }
                    this.isEvaluate = false;
                    mediator.fromQA(responseType);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
