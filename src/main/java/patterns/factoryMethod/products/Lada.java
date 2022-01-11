package patterns.factoryMethod.products;

import patterns.factoryMethod.main.Car;

public class Lada implements Car {
    @Override
    public String getColor() {
        return "Ржавая";
    }

    @Override
    public String getBrand() {
        return "Lada";
    }

    @Override
    public String getNubmer() {
        return "В836РК";
    }
}
