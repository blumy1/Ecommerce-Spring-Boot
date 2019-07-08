package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderUnsaveableException extends ResponseStatusException {
    private static final String MESSAGE = "Couldn't save order";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public OrderUnsaveableException() {
        super(STATUS, MESSAGE);
    }
}
