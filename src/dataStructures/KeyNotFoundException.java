package dataStructures;

public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException() {
        super();
    }

    public String getMessage() {
        return "There is no element with the specified key";
    }
}

