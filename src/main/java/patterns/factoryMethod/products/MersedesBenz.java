package patterns.factoryMethod.products;

import patterns.factoryMethod.main.Car;

public class MersedesBenz implements Car {
    @Override
    public String getColor() {
        return "Белый";
    }

    @Override
    public String getBrand() {
        return "MersedesBenz";
    }

    @Override
    public String getNubmer() {
        return "О888АО";
    }
}
