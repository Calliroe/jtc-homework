package patterns.factoryMethod.main;

public interface Car {
    String getColor();
    String getBrand();
    String getNubmer();
    default String getInfo(){
        return getColor() + " " + getBrand() + ". Номер машины: " + getNubmer();
    }
}
