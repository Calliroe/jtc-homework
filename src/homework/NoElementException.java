package homework;

public class NoElementException extends RuntimeException {

    public NoElementException() {
        super();
    }

    public String getMessage() {
        return "There is no element in the collection";
    }
}
