package edu.pattern.gof.factorymethod;

/**
* Define an interface for creating an object, but let subclasses decide which class to instantiate.
* Factory Method lets a class defer instantiation to subclasses. Another name is Virtual Constructor.
* This type of design pattern comes under creational pattern
*/
public class Main {
    public static void main(String... args) {

        /* Work with Parameterized Fabric Method */
        Main factoryMethod = new Main();
        Job job = factoryMethod.createJob(JobType.STEEL);
        System.out.println(job.getName());
        job.getTool().execute();

        System.out.println("------------------------------");

        factoryMethod = new MethodHardSteelFactory();
        job = factoryMethod.createJob(JobType.STEEL);
        System.out.println(job.getName());
        job.getTool().execute();

    }

    /* Parameterized Factory Method or Parameterized Virtual Constructor */
    public Job createJob(JobType jobType) {
        switch (jobType) {
            case WOOD:
                return new WoodJob();
            case STEEL:
                return new SteelJob();
        }
        return null;
    }

}


