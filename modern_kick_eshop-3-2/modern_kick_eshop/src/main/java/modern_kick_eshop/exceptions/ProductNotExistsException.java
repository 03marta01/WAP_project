package modern_kick_eshop.exceptions;

public class ProductNotExistsException extends RuntimeException {

    public ProductNotExistsException(String message) {
        super(message);
    }
}
