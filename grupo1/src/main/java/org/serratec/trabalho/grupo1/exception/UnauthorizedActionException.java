package org.serratec.trabalho.grupo1.exception;

import java.io.Serial;

public class UnauthorizedActionException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedActionException() {
    }

    public UnauthorizedActionException(String message) {
        super(message);
    }
}
