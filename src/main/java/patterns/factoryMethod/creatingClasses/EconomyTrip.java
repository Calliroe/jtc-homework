package patterns.factoryMethod.creatingClasses;

import patterns.factoryMethod.main.Car;
import patterns.factoryMethod.main.Trip;
import patterns.factoryMethod.products.Lada;

public class EconomyTrip extends Trip {
    @Override
    public Car createCar() {
        return new Lada();
    }
}
