package br.com.pupo.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

// TODO : Definir onde vai ficar o tratamento caso falhe a integração
//    @ExceptionHandler(FeignException.class)
//    public ResponseEntity<String> handleFeignStatusException(FeignException e, HttpServletResponse response) {
//        return new ResponseEntity<>("Integracao falhou ", HttpStatus.valueOf(e.status()));
//    }

    @ExceptionHandler(value = {AddressValidationException.class})
    protected ResponseEntity<String> addressException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}