package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductUnsaveableException extends ResponseStatusException {
    private static final String MESSAGE = "Couldn't save product";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public ProductUnsaveableException() {
        super(STATUS, MESSAGE);
    }
}
