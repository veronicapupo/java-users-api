package br.com.pupo.users.exceptions;

public class AddressValidationException extends RuntimeException {
    public AddressValidationException() {
        super("Erro para validar o endereço");
    }
}