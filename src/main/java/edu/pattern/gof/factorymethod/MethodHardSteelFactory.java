package edu.pattern.gof.factorymethod;

/**
 * Created by Eldar on 11/8/2015.
 */
public class MethodHardSteelFactory extends Main {
    /* Fabric Method or Virtual Constructor */
    public Job createJob(JobType jobType) {
        switch (jobType) {
            case WOOD:
                return super.createJob(jobType);
            case STEEL:
                return new HardSteelJob();
        }
        return null;
    }
}
