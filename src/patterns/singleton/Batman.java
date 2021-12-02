package patterns.singleton;

public class Batman {
    private static Batman batman;
    private int age = 34;
    private String enemy = "Joker";

    private Batman() {
        batman = this;
    }

    public static Batman callBatman() {
        if (batman == null) {
            System.out.println("Batman here!");
            batman = new Batman();
        } else System.out.println("Batman here again!");
        return batman;
    }

    public int getAge() {
        return age;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }
}
