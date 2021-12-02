package patterns.factoryMethod.products;

import patterns.factoryMethod.main.Car;

public class KiaRio implements Car {
    @Override
    public String getColor() {
        return "Серая";
    }

    @Override
    public String getBrand() {
        return "KiaRio";
    }

    @Override
    public String getNubmer() {
        return "Е165РУ";
    }
}
