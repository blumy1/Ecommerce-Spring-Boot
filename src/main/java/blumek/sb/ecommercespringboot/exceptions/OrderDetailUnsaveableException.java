package blumek.sb.ecommercespringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderDetailUnsaveableException extends ResponseStatusException {
    private static final String MESSAGE = "Couldn't save order detail";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public OrderDetailUnsaveableException() {
        super(STATUS, MESSAGE);
    }
}
