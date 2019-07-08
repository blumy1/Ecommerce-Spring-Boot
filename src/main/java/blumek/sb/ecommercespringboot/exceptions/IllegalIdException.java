package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IllegalIdException extends ResponseStatusException {
    private static final String DEFAULT_MESSAGE = "Illegal ID";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public IllegalIdException() {
        super(STATUS, DEFAULT_MESSAGE);
    }

    public IllegalIdException(HttpStatus status) {
        super(status);
    }

    public IllegalIdException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public IllegalIdException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
