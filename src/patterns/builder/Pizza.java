package patterns.builder;

import patterns.prototype.Clonable;

import java.util.LinkedHashMap;

public class Pizza implements Clonable {
    Boolean pepperoni = false;
    Boolean mushrooms = false;
    Boolean ham = false;
    Boolean cucumbers = false;
    Boolean tomatoes = false;
    Boolean cheese = false;
    Boolean onion = false;
    java.util.LinkedHashMap<String, Boolean> ingredients = new LinkedHashMap<>();

    Pizza() {
    }

    public Pizza(Pizza pizza) {
        pepperoni = pizza.pepperoni;
        mushrooms = pizza.mushrooms;
        ham = pizza.ham;
        cucumbers = pizza.cucumbers;
        tomatoes = pizza.tomatoes;
        cheese = pizza.cheese;
        onion = pizza.onion;
        ingredients = pizza.ingredients;
    }

    public void getPizza() {
        ingredients.put("Пеппероньки", pepperoni);
        ingredients.put("Грибки", mushrooms);
        ingredients.put("Ветчина", ham);
        ingredients.put("Мариновыные огурчики", cucumbers);
        ingredients.put("Помидорки", tomatoes);
        ingredients.put("Сырок", cheese);
        ingredients.put("Лучок", onion);
        System.out.println("В вашей пиццуне есть: ");
        for (String s : ingredients.keySet()) {
            if (ingredients.get(s)) System.out.println(s + " ");
        }
        System.out.println("Боже, благослови Италию!");
    }

    @Override
    public Pizza clone() {
        return new Pizza(this);
    }
}
