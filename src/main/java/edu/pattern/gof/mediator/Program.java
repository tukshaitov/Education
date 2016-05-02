package edu.pattern.gof.mediator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Program implements Runnable {
    private String code;
    private boolean isDeployed;
    private boolean isCompiled;
    private Object mutex = new Object();
    private Mediator mediator;

    public boolean isCompiled() {
        return isCompiled;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isDeployed() {
        return isDeployed;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void deploy() {
        synchronized (mutex) {
            if (this.isCompiled) {
                this.isDeployed = true;
                System.out.println("The code " + this.code + " was deployed.");
            }
        }
    }

    public void run() {
        while (true) {
            try {
                if (this.isDeployed) {
                    Screen screen = new Screen((int) (Math.random() * 3));
                    mediator.fromProgram(screen, this.isCompiled, this.isDeployed);
                    this.isDeployed = false;
                } else if (!this.isCompiled) {
                    int r = (int) (Math.random() * 100);
                    Thread.sleep(5000);
                    synchronized (mutex) {
                        if (r <= 90) {
                            this.code = code;
                            this.isCompiled = true;
                            Screen screen = new Screen((int) (Math.random() * 50) + 100);
                            mediator.fromProgram(screen, this.isCompiled, this.isDeployed);
                            System.out.println("The code " + this.code + " was compiled.");
                        } else {
                            this.isDeployed = false;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
