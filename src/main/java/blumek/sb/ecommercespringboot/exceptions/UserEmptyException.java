package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserEmptyException extends ResponseStatusException {
    private static final String MESSAGE = "User has no content";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public UserEmptyException() {
        super(STATUS, MESSAGE);
    }
}
