package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmptyResourceException extends ResponseStatusException {
    private static final String DEFAULT_MESSAGE = "Resource has not content";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public EmptyResourceException() {
        super(STATUS, DEFAULT_MESSAGE);
    }

    public EmptyResourceException(HttpStatus status) {
        super(status);
    }

    public EmptyResourceException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public EmptyResourceException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
