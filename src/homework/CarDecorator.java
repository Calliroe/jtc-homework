package homework;

public class CarDecorator implements Car {
    private Car wrappee;

    CarDecorator(Car car) {
        this.wrappee = car;
    }

    @Override
    public String getColor() {
        return wrappee.getColor();
    }

    @Override
    public String getBrand() {
        return wrappee.getBrand();
    }

    @Override
    public String getNubmer() {
        return wrappee.getNubmer();
    }

    @Override
    public String getInfo() {
        return "***" + wrappee.getInfo() + "***";
    }
}
