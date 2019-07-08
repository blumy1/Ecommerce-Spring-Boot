package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserUnsaveableException extends ResponseStatusException {
    private static final String MESSAGE = "Couldn't save user";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public UserUnsaveableException() {
        super(STATUS, MESSAGE);
    }
}
