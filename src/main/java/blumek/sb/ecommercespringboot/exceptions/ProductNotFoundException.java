package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotFoundException extends ResponseStatusException {
    private static final String MESSAGE = "Product not found";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public ProductNotFoundException() {
        super(STATUS, MESSAGE);
    }

    public ProductNotFoundException(Integer id) {
        super(STATUS, MESSAGE + ": " + id);
    }
}
