package br.com.pupo.users.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJson {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private Boolean risk;
    private String cep;
    private String lograduro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    // TODO: trocar para Builder do lombok
    public static UserJson of(User u) {
        var json = new UserJson();
        json.setId(u.getId());
        json.setName(u.getName());
        json.setEmail(u.getEmail());
        json.setPassword(u.getPassword());
        json.setCpf(u.getCpf());
        json.setCep(u.getCep());
        json.setPhone(u.getPhone());
        json.setLograduro((u.getLograduro()));
        json.setBairro((u.getBairro()));
        json.setComplemento((u.getComplemento()));
        json.setLocalidade((u.getLocalidade()));
        json.setUf((u.getUf()));
        return json;
    }
}

