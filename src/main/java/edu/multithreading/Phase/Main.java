package edu.multithreading.Phase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by eitukshaitov on 04.08.2016.
 */
public class Main {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) {

        final Phaser phaser = new Phaser(2) {
            protected boolean onAdvance(int phase, int parties) {
                //System.out.println("onAdvance phase: " + phase + " parties: " + parties);
                return false;
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //System.out.println(phaser.getPhase());
                    phaser.awaitAdvanceInterruptibly(phaser.getPhase() , 1,  TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //System.out.println(phaser.getPhase());
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println("I am here.");
            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(phaser.toString());

        phaser.arrive();
        thread.interrupt();
        System.out.println("Arrived Parties: " + phaser.getArrivedParties());

        phaser.bulkRegister(100000);
        //System.out.println("GetRegisteredParties: " + phaser.getRegisteredParties());


        //System.out.println("RegisteredParties: " + phaser.getRegisteredParties() + "");
        //System.out.println("ArrivedParties: " + phaser.getArrivedParties() + "");
        //System.out.println("UnarrivedParties: " + phaser.getUnarrivedParties() + "");
        //System.out.println("Фаза: " + phaser.getPhase() + " завершена");
        //System.out.println("Is Terminated: " + phaser.isTerminated());


        /*Phaser phaser = new Phaser(2);
        phaser.arrive();
        phaser.arrive();
        phaser.arrive();

        System.out.println("RegisteredParties: " + phaser.getRegisteredParties() + "");
        System.out.println("ArrivedParties: " + phaser.getArrivedParties() + "");
        System.out.println("UnarrivedParties: " + phaser.getUnarrivedParties() + "");
        System.out.println("Фаза: " + phaser.getPhase() + " завершена");
        System.out.println("Is Terminated: " + phaser.isTerminated());

        //phaser.awaitAdvance(1); // Необходимо указать текущую фазу, если указывет любое другое число, то ничего не происходит
        try {
            phaser.awaitAdvanceInterruptibly(1, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        /*
        phaser = new Phaser(3);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        //phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        //phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        //phaser.arriveAndDeregister();
        */
    }
}
