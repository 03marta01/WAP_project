package modern_kick_eshop.exceptions;

public class NoItemsInOrderException extends RuntimeException {

    public NoItemsInOrderException(String message) {
        super(message);
    }
}
