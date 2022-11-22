package br.com.pupo.users.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cep;
    private String phone;
    private String lograduro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public static User from(UserJson u) {
        return User.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .password(u.getPassword())
                .phone(u.getPhone())
                .cep(u.getCep())
                .cpf(u.getCpf())
                .lograduro(u.getLograduro())
                .complemento(u.getComplemento())
                .bairro(u.getBairro())
                .localidade(u.getLocalidade())
                .uf(u.getUf())
                .build();
    }

}
