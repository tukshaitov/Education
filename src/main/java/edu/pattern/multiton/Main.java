package edu.pattern.multiton;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by eitukshaitov on 01.10.2015.
 */

public class Main {
    private Main() {
    }

    public static void main(String... args) {
        Main bus = Main.MultitonManager.getMultiton(Vehicle.BUS);
        Main bus1 = Main.MultitonManager.getMultiton(Vehicle.BUS);

        Main car = Main.MultitonManager.getMultiton(Vehicle.CAR);

        System.out.println("Bus @ Buss testing: " + (bus == bus1));
        System.out.println("Bus @ Vehicle testing: " + (bus == car));
    }

    private static class MultitonManager {
        static final Object mutex = new Object();
        static private Map<Vehicle, Main> enumMap = new EnumMap<Vehicle, Main>(Vehicle.class);

        public static Main getMultiton(Vehicle vehicleType) {
            if (!enumMap.containsKey(vehicleType)) {
                synchronized (mutex) {
                    if (!enumMap.containsKey(vehicleType)) {
                        Main multiton = new Main();
                        enumMap.put(vehicleType, multiton);
                        return multiton;
                    }
                }
            }
            return enumMap.get(vehicleType);
        }

    }

}


