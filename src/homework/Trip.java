package homework;

public abstract class Trip {
    Car car = createCar();

    public void message () {
        System.out.println("К Вам приедет " + car.getInfo());
    }

    public abstract Car createCar();
}
