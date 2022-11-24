package br.com.pupo.users.models;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ResponseAPI<T> {
    private T data;
    private HttpStatus status;
    private String[] errors;
}