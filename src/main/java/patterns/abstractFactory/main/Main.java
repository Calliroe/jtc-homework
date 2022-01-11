package patterns.abstractFactory.main;

import patterns.abstractFactory.factories.AbstractGiftBoxFactory;
import patterns.abstractFactory.factories.GiftBoxForHerFactory;
import patterns.abstractFactory.interfaces.Chocolate;
import patterns.abstractFactory.interfaces.Cup;
import patterns.abstractFactory.interfaces.Mittens;

public class Main {

    public static void main(String[] args) {

        AbstractGiftBoxFactory factory = new GiftBoxForHerFactory(); // Выбор конкретной фабрики зависит от окружения
        Chocolate chocolate = factory.addChocolate();
        Mittens mittens = factory.addMittens();
        Cup cup = factory.addCup();
    }

}
