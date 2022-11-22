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
    private String address;
    private String phone;

    public static User from(UserJson u) {
        return User.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .password(u.getPassword())
                .phone(u.getPhone())
                .address(u.getAddress())
                .cpf(u.getCpf())
                .build();
    }
}
