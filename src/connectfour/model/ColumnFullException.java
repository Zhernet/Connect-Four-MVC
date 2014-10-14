package connectfour.model;

public class ColumnFullException extends RuntimeException {

    public ColumnFullException() {
    }

    public ColumnFullException(String msg) {
        super(msg);
    }
}
