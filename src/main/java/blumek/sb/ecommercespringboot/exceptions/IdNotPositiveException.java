package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IdNotPositiveException extends ResponseStatusException {
    private static final String MESSAGE = "Id is not positive";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public IdNotPositiveException() {
        super(STATUS, MESSAGE);
    }

}
