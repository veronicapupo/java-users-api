package br.com.pupo.users.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class ResponseAPI {
    private UserJson data;
    private HttpStatus status;
    private String[] errors;
}