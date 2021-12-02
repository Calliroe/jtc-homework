package patterns.abstractFactory.factories;

import patterns.abstractFactory.interfaces.Chocolate;
import patterns.abstractFactory.interfaces.Cup;
import patterns.abstractFactory.interfaces.Mittens;
import patterns.abstractFactory.products.CoffeeCup;
import patterns.abstractFactory.products.RitterSport;
import patterns.abstractFactory.products.RitterSportTastes;
import patterns.abstractFactory.products.WhiteAndBrownMittens;

public class GiftBoxForHimFactory extends AbstractGiftBoxFactory {

    @Override
    public Chocolate addChocolate() {
        return new RitterSport(RitterSportTastes.ESPRESSO);
    }

    @Override
    public Mittens addMittens() {
        return new WhiteAndBrownMittens();
    }

    @Override
    public Cup addCup() {
        return new CoffeeCup();
    }
}
