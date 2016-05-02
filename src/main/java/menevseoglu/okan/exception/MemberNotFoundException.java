package menevseoglu.okan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown if Member not exists.
 * Returns HTTP NOT_FOUND header.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Member type not found.")
public class MemberNotFoundException extends RuntimeException {
}
