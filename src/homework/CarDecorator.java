package homework;

public class CarDecorator implements Car {
    private Car wrappee;

    CarDecorator(Car car) {
        this.wrappee = car;
    }

    @Override
    public String getInfo() {
        return "***" + wrappee.getInfo() + "***";
    }
}
