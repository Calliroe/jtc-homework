package homework;

public class EconomyTrip extends Trip{
    @Override
    public Car createCar() {
        return new Lada();
    }
}
