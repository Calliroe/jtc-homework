package homework;

public class BusinessTrip extends Trip{
    @Override
    public Car createCar() {
        return new MersedesBenz();
    }
}
