package patterns.abstractFactory.factories;

import patterns.abstractFactory.interfaces.Chocolate;
import patterns.abstractFactory.interfaces.Cup;
import patterns.abstractFactory.interfaces.Mittens;

public abstract class AbstractGiftBoxFactory {

    public abstract Chocolate addChocolate();

    public abstract Mittens addMittens();

    public abstract Cup addCup();

}
