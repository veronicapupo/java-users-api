package br.com.pupo.users;

public class AddressValidationException extends RuntimeException {
    public AddressValidationException() {
        super("Erro para validar o endereço");
    }
}