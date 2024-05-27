package org.serratec.trabalho.grupo1.exception;

import java.io.Serial;

public class ForeignKeyMustBeNullException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ForeignKeyMustBeNullException() {
    }

    public ForeignKeyMustBeNullException(String message) {
        super(message);
    }

}
