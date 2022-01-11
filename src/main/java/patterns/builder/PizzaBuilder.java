package patterns.builder;

public class PizzaBuilder {
    Pizza pizza = new Pizza();

    public void addPepperoni() {
        pizza.pepperoni = true;
    }

    public void addMushrooms() {
        pizza.mushrooms = true;
    }

    public void addHam() {
        pizza.ham = true;
    }

    public void addCucumbers() {
        pizza.cucumbers = true;
    }

    public void addTomatoes() {
        pizza.tomatoes = true;
    }

    public void addCheese() {
        pizza.cheese = true;
    }

    public void addOnion() {
        pizza.onion = true;
    }

    public Pizza getResult() {
        return pizza;
    }
}
