package br.com.pupo.users.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class UserJson extends Object {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private Boolean risk;
    // private AddressJson address
        private String cep;
        private String lograduro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;

    public static UserJson of(User u) {
        return UserJson.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .password(u.getPassword())
                .cpf(u.getCpf())
                .cep(u.getCep())
                .phone(u.getPhone())
                .localidade(u.getLocalidade())
                .lograduro(u.getLograduro())
                .bairro(u.getBairro())
                .complemento(u.getComplemento())
                .uf(u.getUf())
                .build();
    }
}

