package menevseoglu.okan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown if Member Type already exists.
 * Returns HTTP CONFLICT header.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Member already exists.")
public class MemberAlreadyExistsException extends RuntimeException {
}
