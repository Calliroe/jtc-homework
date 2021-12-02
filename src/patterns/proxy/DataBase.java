package patterns.proxy;

public class DataBase implements DB {
    private final Table table1 = new Table();
    private final Table table2 = new Table();
    private final Table table3 = new Table();

    @Override
    public Table getTable(String tableName) {
        switch (tableName) {
            case "table1": return table1;
            case "table2": return table2;
            case "table3": return table3;
            default: return null;
        }
    }
}
