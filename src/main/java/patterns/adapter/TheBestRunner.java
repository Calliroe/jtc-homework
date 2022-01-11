package patterns.adapter;

public interface TheBestRunner {
    String getName();

    double getSpeed();

    static void getResult(TheBestRunner member) {
        System.out.println(member.getName() + " пробежал со скоростью: " + member.getSpeed() + " м/с!");
    }
}
