package patterns.abstractFactory.factories;

import patterns.abstractFactory.interfaces.Chocolate;
import patterns.abstractFactory.interfaces.Cup;
import patterns.abstractFactory.interfaces.Mittens;
import patterns.abstractFactory.products.LumbCup;
import patterns.abstractFactory.products.RitterSport;
import patterns.abstractFactory.products.RitterSportTastes;
import patterns.abstractFactory.products.WhiteAndGoldMittens;

public class GiftBoxForHerFactory extends AbstractGiftBoxFactory {

    @Override
    public Chocolate addChocolate() {
        return new RitterSport(RitterSportTastes.STRAWBERRY_YOGURT);
    }

    @Override
    public Mittens addMittens() {
        return new WhiteAndGoldMittens();
    }

    @Override
    public Cup addCup() {
        return new LumbCup();
    }

}
