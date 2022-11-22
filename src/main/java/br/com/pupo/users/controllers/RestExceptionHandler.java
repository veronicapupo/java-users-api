package br.com.pupo.users.controllers;

import br.com.pupo.users.AddressValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class, Exception.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>("erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {AddressValidationException.class})
    protected ResponseEntity<Object> addressException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}