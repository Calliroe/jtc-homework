package homework;

public enum Country {
    RUSSIA("russia_index"),
    ITALY("italy_index"),
    FRANCE("france_index"),
    USA("usa_index");

    private final String index;

    Country(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
