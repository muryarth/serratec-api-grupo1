package org.serratec.trabalho.grupo1.exception;

import java.io.Serial;

public class DuplicateItemException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateItemException() {
    }

    public DuplicateItemException(String message) {
        super(message);
    }

}
