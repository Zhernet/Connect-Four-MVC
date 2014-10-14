package connectfour.model;

public class NullCellException extends RuntimeException {

    public NullCellException() {
    }

    public NullCellException(String msg) {
        super(msg);
    }
}
