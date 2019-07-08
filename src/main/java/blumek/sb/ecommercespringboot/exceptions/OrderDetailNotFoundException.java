package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderDetailNotFoundException extends ResponseStatusException {
    private static final String MESSAGE = "Order detail not found";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public OrderDetailNotFoundException() {
        super(STATUS, MESSAGE);
    }

    public OrderDetailNotFoundException(Integer id) {
        super(STATUS, MESSAGE + ": " + id);
    }
}
