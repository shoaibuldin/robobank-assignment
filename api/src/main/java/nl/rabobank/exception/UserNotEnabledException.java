package nl.rabobank.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * This exception is thrown in case of a not enabled user trying to authenticate.
 */
public class UserNotEnabledException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public UserNotEnabledException(String message) {
        super(message);
    }
}
