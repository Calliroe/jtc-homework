package patterns.adapter;

public class Bolt implements TheBestDamnRunner {

    @Override
    public String getName() {
        return "Usain Bolt";
    }

    @Override
    public double getSpeed() {
        return 43.9;
    }
}
