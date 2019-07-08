package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotSaveableException extends ResponseStatusException {
    private static final String DEFAULT_MESSAGE = "Resource not saveable";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public ResourceNotSaveableException() {
        super(STATUS, DEFAULT_MESSAGE);
    }

    public ResourceNotSaveableException(HttpStatus status) {
        super(status);
    }

    public ResourceNotSaveableException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public ResourceNotSaveableException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
