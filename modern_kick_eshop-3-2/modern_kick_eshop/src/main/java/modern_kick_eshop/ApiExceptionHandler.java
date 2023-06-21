package modern_kick_eshop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedIOException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import modern_kick_eshop.entities.dto.ErrorDto;
import modern_kick_eshop.exceptions.NoItemsInOrderException;
import modern_kick_eshop.exceptions.ProductNotExistsException;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        log.error("Request isn't valid", ex);
        return new ResponseEntity(ErrorDto.builder().message(ex.getMessage()).build(), headers, status);
    }

    @ExceptionHandler (NoItemsInOrderException.class)
    public final ResponseEntity<Object> handleNoItemsInOrderError(NoItemsInOrderException ex, WebRequest request) {
        log.warn("Handling NoItemsInOrderException: request - {}, error - {}", request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(ErrorDto.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (ProductNotExistsException.class)
    public final ResponseEntity<Object> handleProductNotExistsError(ProductNotExistsException ex, WebRequest request) {
        log.warn("Handling ProductNotExistsException: request - {}, error - {}", request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(ErrorDto.builder().message(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (OptimisticLockingFailureException.class)
    public final ResponseEntity<Object> handleOptimisticLockFailureError(OptimisticLockingFailureException ex, WebRequest request) {
        log.warn("Handling OptimisticLockingFailureException: request - {}, error - {}", request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(ErrorDto.builder().message(ex.getMessage()).build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler ({Exception.class})
    public final ResponseEntity<Object> handleGenericError(Exception ex, WebRequest request) {
        log.warn("Handling GenericException: request - {}, error - {}", request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(ErrorDto.builder().message(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler ({NestedIOException.class})
    public final ResponseEntity<Object> handleIOException(NestedIOException ex, WebRequest request) {
        log.warn("Handling GenericException: request - {}, error - {}", request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(ErrorDto.builder().message(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
