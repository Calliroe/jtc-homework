package patterns.adapter;

public class ForrestAdapter implements TheBestDamnRunner {
    private Forrest forrest;

    public ForrestAdapter(Forrest forrest) {
        this.forrest = forrest;
    }

    @Override
    public String getName() {
        return "Forrest Gump";
    }

    @Override
    public double getSpeed() {
        return forrest.getSpeed() * 3.6;
    }
}
