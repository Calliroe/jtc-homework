package patterns.abstractFactory.products;

import patterns.abstractFactory.interfaces.Chocolate;

public class RitterSport implements Chocolate {
    RitterSportTastes taste;

    public RitterSport(RitterSportTastes taste) {
        this.taste = taste;
    }
}
