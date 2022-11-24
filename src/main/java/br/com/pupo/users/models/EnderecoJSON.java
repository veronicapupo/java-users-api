package br.com.pupo.users.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnderecoJSON {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}