package patterns.proxy;

public class DataBaseProxy implements DB {
    DataBase dataBase;

    public DataBaseProxy(String password) {
        if (password.equals("qwerty")) dataBase = new DataBase();
        else throw new RuntimeException("Access denied");
    }

    @Override
    public Table getTable(String tableName) {
        return dataBase.getTable(tableName);
    }

}
