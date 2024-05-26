package org.serratec.trabalho.grupo1.exception;

import java.io.Serial;

public class IncompatibleEqualsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public IncompatibleEqualsException(){

    }

    public IncompatibleEqualsException(String message){
        super(message);
    }
}
