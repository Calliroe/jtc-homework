package patterns.factoryMethod.creatingClasses;

import patterns.factoryMethod.main.Car;
import patterns.factoryMethod.main.Trip;
import patterns.factoryMethod.products.MersedesBenz;

public class BusinessTrip extends Trip {
    @Override
    public Car createCar() {
        return new MersedesBenz();
    }
}
