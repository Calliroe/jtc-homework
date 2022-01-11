package patterns.proxy;

public interface DB {
    Table getTable(String tableName);
}
