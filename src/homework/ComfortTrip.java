package homework;

public class ComfortTrip extends Trip{
    @Override
    public Car createCar() {
        return new KiaRio();
    }
}
