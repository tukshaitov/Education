package edu.multithreading.Phase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by eitukshaitov on 04.08.2016.
 */
public class PhaseTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) {

        {
            final Phaser phaser = new Phaser();
            try {
                phaser.arriveAndAwaitAdvance();
            }
            catch (IllegalStateException e) {
                System.out.println("{1} " + e.getMessage());
            }
        }


        {
            final Phaser phaser = new Phaser() {
                protected boolean onAdvance(int phase, int parties) {
                    //System.out.println("onAdvance phase: " + phase + " parties: " + parties);
                    return false;
                }
            };

            try {
                phaser.arriveAndAwaitAdvance();
            }
            catch (IllegalStateException e) {
                System.out.println("{2} " + e.getMessage());
            }
        }

        {
            final Phaser phaser = new Phaser(1) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{3} OnAdvance phase: " + phase + " parties: " + parties);
                    return false;
                }
            };

            try {
                phaser.arriveAndDeregister();
                System.out.println("{3} Phaser terminated state: " + phaser.isTerminated());
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        }

        {
            final Phaser phaser = new Phaser(1);

            try {
                phaser.arriveAndDeregister();
                System.out.println("{4} Phaser terminated state: " + phaser.isTerminated());
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        }

        {
            final Phaser phaser = new Phaser(1) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{5} OnAdvance phase: " + phase + " parties: " + parties);
                    return true;
                }
            };

            try {
                phaser.arrive();
                System.out.println("{5} Phaser terminated state: " + phaser.isTerminated());
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        {
            final Phaser parent = new Phaser(0) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{6} Parent phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            }, childOne = new Phaser(parent, 1), childTwo = new Phaser(parent, 1){
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{6} ChildTwo phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            }, childThree = new Phaser(parent, 3) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{6} ChildThree phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            };

            System.out.println("{6} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());


            parent.arrive();
            parent.arrive();
            childThree.arrive();
            parent.arrive();

            System.out.println("{6} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());

            System.out.println("{6} ChildOne phaser RegisteredParties: " + childOne.getRegisteredParties() +
                    " UnarrivedParties: " + childOne.getUnarrivedParties() + " ArrivedParties: " + childOne.getArrivedParties() + " Phase: " +
                    childOne.getPhase() + " IsTerminated: " + childOne.isTerminated());

            System.out.println("{6} ChildTwo phaser RegisteredParties: " + childTwo.getRegisteredParties() +
                    " UnarrivedParties: " + childTwo.getUnarrivedParties() + " ArrivedParties: " + childTwo.getArrivedParties() + " Phase: " +
                    childTwo.getPhase() + " IsTerminated: " + childTwo.isTerminated());

            System.out.println("{6} ChildThree phaser RegisteredParties: " + childThree.getRegisteredParties() +
                    " UnarrivedParties: " + childThree.getUnarrivedParties() + " ArrivedParties: " + childThree.getArrivedParties() + " Phase: " +
                    childThree.getPhase() + " IsTerminated: " + childThree.isTerminated());

            System.out.println();
            parent.arriveAndDeregister();

            System.out.println("{6} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());

            System.out.println("{6} ChildOne phaser RegisteredParties: " + childOne.getRegisteredParties() +
                    " UnarrivedParties: " + childOne.getUnarrivedParties() + " ArrivedParties: " + childOne.getArrivedParties() + " Phase: " +
                    childOne.getPhase() + " IsTerminated: " + childOne.isTerminated());

            System.out.println("{6} ChildTwo phaser RegisteredParties: " + childTwo.getRegisteredParties() +
                    " UnarrivedParties: " + childTwo.getUnarrivedParties() + " ArrivedParties: " + childTwo.getArrivedParties() + " Phase: " +
                    childTwo.getPhase() + " IsTerminated: " + childTwo.isTerminated());

            System.out.println("{6} ChildThree phaser RegisteredParties: " + childThree.getRegisteredParties() +
                    " UnarrivedParties: " + childThree.getUnarrivedParties() + " ArrivedParties: " + childThree.getArrivedParties() + " Phase: " +
                    childThree.getPhase() + " IsTerminated: " + childThree.isTerminated());

            System.out.println();

            try {
                childOne.arrive();
                childThree.arrive();
                childTwo.arrive();
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


            System.out.println("{6} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());

            System.out.println("{6} ChildOne phaser RegisteredParties: " + childOne.getRegisteredParties() +
                    " UnarrivedParties: " + childOne.getUnarrivedParties() + " ArrivedParties: " + childOne.getArrivedParties() + " Phase: " +
                    childOne.getPhase() + " IsTerminated: " + childOne.isTerminated());

            System.out.println("{6} ChildTwo phaser RegisteredParties: " + childTwo.getRegisteredParties() +
                    " UnarrivedParties: " + childTwo.getUnarrivedParties() + " ArrivedParties: " + childTwo.getArrivedParties() + " Phase: " +
                    childTwo.getPhase() + " IsTerminated: " + childTwo.isTerminated());

            System.out.println("{6} ChildThree phaser RegisteredParties: " + childThree.getRegisteredParties() +
                    " UnarrivedParties: " + childThree.getUnarrivedParties() + " ArrivedParties: " + childThree.getArrivedParties() + " Phase: " +
                    childThree.getPhase() + " IsTerminated: " + childThree.isTerminated());

            System.out.println();

            try {
                childOne.arrive();
                childTwo.arrive();
                childThree.arrive();
                childThree.arrive();
                childOne.arrive();
                childTwo.arrive();

                childThree.arrive();
                childThree.arrive();
                childThree.arrive();
                childTwo.arrive();

                childThree.arrive();
                childThree.arrive();
                childTwo.arrive();
                childOne.arrive();

                childThree.arrive();
                childThree.arrive();
                childThree.arrive();
                childThree.arrive();
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("{6} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());

            System.out.println("{6} ChildOne phaser RegisteredParties: " + childOne.getRegisteredParties() +
                    " UnarrivedParties: " + childOne.getUnarrivedParties() + " ArrivedParties: " + childOne.getArrivedParties() + " Phase: " +
                    childOne.getPhase() + " IsTerminated: " + childOne.isTerminated());

            System.out.println("{6} ChildTwo phaser RegisteredParties: " + childTwo.getRegisteredParties() +
                    " UnarrivedParties: " + childTwo.getUnarrivedParties() + " ArrivedParties: " + childTwo.getArrivedParties() + " Phase: " +
                    childTwo.getPhase() + " IsTerminated: " + childTwo.isTerminated());

            System.out.println("{6} ChildThree phaser RegisteredParties: " + childThree.getRegisteredParties() +
                    " UnarrivedParties: " + childThree.getUnarrivedParties() + " ArrivedParties: " + childThree.getArrivedParties() + " Phase: " +
                    childThree.getPhase() + " IsTerminated: " + childThree.isTerminated());

        }

        {
            System.out.println();
            final Phaser parent = new Phaser(0) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{7} Parent phaser OnAdvance phase: " + phase + " parties: " + parties);
                    //return super.onAdvance(phase, parties);
                    return false;
                }
            }, childLevelFirst = new Phaser(parent, 0){
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{7} ChildLevelFirst phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            },
            childLevelFirstOne = new Phaser(parent, 1){
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{7} ChildLevelFirst phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            },
            childLevelSecondOne = new Phaser(childLevelFirst, 1) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{7} ChildLevelSecondOne phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return super.onAdvance(phase, parties);
                }
            }, childLevelSecondTwo = new Phaser(childLevelFirst, 1);


           Thread myThread = new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       childLevelSecondTwo.awaitAdvanceInterruptibly(childLevelSecondTwo.getPhase());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("Thread: " + Thread.currentThread().getName() + " completed.");
               }
           });

            myThread.start();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myThread.interrupt();

            System.out.println("{7} Parent phaser RegisteredParties: " + parent.getRegisteredParties() +
                    " UnarrivedParties: " + parent.getUnarrivedParties() + " ArrivedParties: " + parent.getArrivedParties() + " Phase: " +
                    parent.getPhase() + " IsTerminated: " + parent.isTerminated());

            System.out.println("{7} ChildLevelFirst phaser RegisteredParties: " + childLevelFirst.getRegisteredParties() +
                    " UnarrivedParties: " + childLevelFirst.getUnarrivedParties() + " ArrivedParties: " + childLevelFirst.getArrivedParties() + " Phase: " +
                    childLevelFirst.getPhase() + " IsTerminated: " + childLevelFirst.isTerminated());

            System.out.println("{7} ChildLevelSecondOne phaser RegisteredParties: " + childLevelSecondOne.getRegisteredParties() +
                    " UnarrivedParties: " + childLevelSecondOne.getUnarrivedParties() + " ArrivedParties: " + childLevelSecondOne.getArrivedParties() + " Phase: " +
                    childLevelSecondOne.getPhase() + " IsTerminated: " + childLevelSecondOne.isTerminated());


            System.out.println("{7} ChildLevelSecondTwo phaser RegisteredParties: " + childLevelSecondTwo.getRegisteredParties() +
                    " UnarrivedParties: " + childLevelSecondTwo.getUnarrivedParties() + " ArrivedParties: " + childLevelSecondTwo.getArrivedParties() + " Phase: " +
                    childLevelSecondTwo.getPhase() + " IsTerminated: " + childLevelSecondTwo.isTerminated());

            try {
                //parent.arrive();
                //childLevelFirst.arriveAndDeregister();

            }
            catch (IllegalStateException e) {
                System.out.println("{7} " + e.getMessage());
            }
        }

        /*{
            final Phaser phaser = new Phaser(1) {
                protected boolean onAdvance(int phase, int parties) {
                    System.out.println("{7} Parent phaser OnAdvance phase: " + phase + " parties: " + parties);
                    return false;
                }
            };

            phaser.arriveAndDeregister();
            phaser.register();

            System.out.println("{1} Phaser RegisteredParties: " + phaser.getRegisteredParties() +
                    " UnarrivedParties: " + phaser.getUnarrivedParties() + " ArrivedParties: " + phaser.getArrivedParties() + " Phase: " +
                    phaser.getPhase() + " IsTerminated: " + phaser.isTerminated());
        }*/


        /*final Phaser parent = new Phaser(0), childOne = new Phaser(parent, 52535), childTwo = new Phaser(parent, 52535),  childThree = new Phaser(parent, 52535);

        System.out.println("Parent Phaser terminated state: " + parent.isTerminated());
        System.out.println("Child one terminated state: " + childOne.isTerminated());
        System.out.println("Child two terminated state: " + childTwo.isTerminated());
        System.out.println("childTwo phase " + childTwo.getPhase());
        System.out.println("childOne phase " + childOne.getPhase());
        System.out.println("Parent phase " + parent.getPhase());
        childOne.arrive();
        childTwo.arrive();
        parent.arrive();
        parent.arrive();
        parent.arrive();
        parent.arrive();
        parent.arrive();
        parent.arrive();*/



        //parent.arriveAndDeregister();
        //childOne.arriveAndDeregister();
        //childTwo.arriveAndDeregister();

        /*System.out.println("Parent Phaser terminated state: " + parent.isTerminated());
        System.out.println("Child one terminated state: " + childOne.isTerminated());
        System.out.println("Child two terminated state: " + childTwo.isTerminated());
        System.out.println("childTwo phase " + childTwo.getPhase());
        System.out.println("childOne phase " + childOne.getPhase());
        System.out.println("Parent phase " + parent.getPhase());

        final Phaser phaser = new Phaser(parent, 1) {
            protected boolean onAdvance(int phase, int parties) {
                //System.out.println("onAdvance phase: " + phase + " parties: " + parties);
                return false;
            }
        };

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //System.out.println(phaser.getPhase());
//                    phaser.awaitAdvanceInterruptibly(phaser.getPhase() , 1,  TimeUnit.SECONDS);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    //System.out.println(phaser.getPhase());
//                } catch (TimeoutException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("I am here.");
//            }
//        });
//
//        thread.start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //System.out.println(phaser.toString());

//        phaser.arrive();
//        thread.interrupt();
//        System.out.println("Arrived Parties: " + phaser.getArrivedParties());
//
//        phaser.bulkRegister(100000);
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
