package patterns.factoryMethod.creatingClasses;

import patterns.factoryMethod.main.Car;
import patterns.factoryMethod.main.Trip;
import patterns.factoryMethod.products.KiaRio;

public class ComfortTrip extends Trip {
    @Override
    public Car createCar() {
        return new KiaRio();
    }
}
