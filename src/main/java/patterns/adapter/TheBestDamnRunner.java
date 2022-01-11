package patterns.adapter;

public interface TheBestDamnRunner {
    String getName();

    double getSpeed();

    static void getResult(TheBestDamnRunner member) {
        System.out.println(member.getName() + " поставил новый рекорд! Ему удалось развить скорость: " + member.getSpeed() + " км/ч!");
    }
}
