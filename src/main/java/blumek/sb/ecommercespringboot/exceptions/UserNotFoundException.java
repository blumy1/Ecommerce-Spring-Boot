package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    private static final String MESSAGE = "User not found";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public UserNotFoundException() {
        super(STATUS, MESSAGE);
    }

    public UserNotFoundException(Integer id) {
        super(STATUS, MESSAGE + ": " + id);
    }
}
