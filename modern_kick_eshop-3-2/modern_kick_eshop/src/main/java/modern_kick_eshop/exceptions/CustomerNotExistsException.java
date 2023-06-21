package modern_kick_eshop.exceptions;

public class CustomerNotExistsException extends RuntimeException {

    public CustomerNotExistsException(String message) {
        super(message);
    }
}
