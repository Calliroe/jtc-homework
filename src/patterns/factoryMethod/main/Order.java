package patterns.factoryMethod.main;

import patterns.factoryMethod.creatingClasses.BusinessTrip;
import patterns.factoryMethod.creatingClasses.ComfortTrip;
import patterns.factoryMethod.creatingClasses.EconomyTrip;

public class Order {
    static Trip trip;

    public static void main(String[] args) {
        configure(CarClass.BUSINESS);
        start();
        Car carDecorator = trip.car;
        System.out.println(carDecorator.getInfo());
    }

    static void configure() {
        trip = new EconomyTrip();
    }

    static void configure(CarClass carClass) {
        if (carClass.equals(CarClass.BUSINESS)) {
            trip = new BusinessTrip();
        }
        if (carClass.equals(CarClass.COMFORT)) {
            trip = new ComfortTrip();
        }
        if (carClass.equals(CarClass.ECONOMY)) {
            trip = new EconomyTrip();
        }
    }

    static void start() {
        trip.message();
    }
}
