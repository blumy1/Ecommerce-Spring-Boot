package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException extends ResponseStatusException {
    private static final String MESSAGE = "Order not found";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public OrderNotFoundException() {
        super(STATUS, MESSAGE);
    }

    public OrderNotFoundException(Integer id) {
        super(STATUS, MESSAGE + ": " + id);
    }
}
