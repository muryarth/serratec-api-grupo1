package org.serratec.trabalho.grupo1.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.serratec.trabalho.grupo1.exception.ErroResposta;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<FieldError> listaFieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> erros = new ArrayList<>();

        for (FieldError error : listaFieldErrors) {
            System.out.println(error.toString());
            erros.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(status.value(), "Existem Campos Invalidos", LocalDateTime.now(),
                erros);
        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Void> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoContentException.class)
    protected ResponseEntity<Void> handleNoContentException(NotFoundException ex) {
        return ResponseEntity.noContent().build();
    }

}