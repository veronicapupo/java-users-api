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
    private String address;
    private String phone;
    private Boolean risk;

    //TODO: trocar para Builder do lombok
    public static UserJson of(User u) {
        var json = new UserJson();
        json.setId(u.getId());
        json.setName(u.getName());
        json.setEmail(u.getEmail());
        json.setPassword(u.getPassword());
        json.setCpf(u.getCpf());
        json.setAddress(u.getAddress());
        json.setPhone(u.getPhone());
        return json;
    }
}

