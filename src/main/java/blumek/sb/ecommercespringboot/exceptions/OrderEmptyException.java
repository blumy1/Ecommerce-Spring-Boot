package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderEmptyException extends ResponseStatusException {
    private static final String MESSAGE = "Order has no content";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public OrderEmptyException() {
        super(STATUS, MESSAGE);
    }
}
