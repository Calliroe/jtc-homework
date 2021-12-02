package patterns.prototype;

import patterns.builder.Pizza;
import patterns.builder.PizzaBuilder;

public class Main {
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.addCheese();
        pizzaBuilder.addOnion();
        pizzaBuilder.addPepperoni();
        pizzaBuilder.addTomatoes();
        Pizza myPizza = pizzaBuilder.getResult();
        Pizza oneMoreMyPizza = myPizza.clone();
        myPizza.getPizza();
        System.out.println();
        oneMoreMyPizza.getPizza();
    }
}
