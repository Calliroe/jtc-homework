package patterns.proxy;

public class Main {
    public static void main(String[] args) {
        DB db = new DataBaseProxy("qwerty");
        db.getTable("table1").readTable();
    }
}
