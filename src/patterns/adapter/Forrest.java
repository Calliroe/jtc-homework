package patterns.adapter;

public class Forrest implements TheBestRunner {

    @Override
    public String getName() {
        return "Forrest Gump";
    }

    @Override
    public double getSpeed() {
        return 15.9;
    }

}
