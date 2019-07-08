package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderDetailEmptyException extends ResponseStatusException {
    private static final String MESSAGE = "Order detail has no content";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public OrderDetailEmptyException() {
        super(STATUS, MESSAGE);
    }
}
