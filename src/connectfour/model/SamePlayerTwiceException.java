package connectfour.model;

public class SamePlayerTwiceException extends RuntimeException {

    public SamePlayerTwiceException() {
    }

    public SamePlayerTwiceException(String msg) {
        super(msg);
    }
}
