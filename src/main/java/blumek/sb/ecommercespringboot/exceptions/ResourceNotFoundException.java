package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {
    private static final String DEFAULT_MESSAGE = "Resource not found";
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException() {
        super(STATUS, DEFAULT_MESSAGE);
    }

    public ResourceNotFoundException(Integer id) {
        super(STATUS, DEFAULT_MESSAGE + ": " + id);
    }

    public ResourceNotFoundException(HttpStatus status) {
        super(status);
    }

    public ResourceNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public ResourceNotFoundException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
