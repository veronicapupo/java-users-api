package br.com.pupo.users.controllers;

import br.com.pupo.users.config.feign.address.AddressFeign;
import br.com.pupo.users.models.ResponseAPI;
import br.com.pupo.users.models.UserJson;
import br.com.pupo.users.services.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final AddressFeign addressFeign;

    @PostMapping
    public ResponseEntity<ResponseAPI> create(@RequestBody UserJson json) {
        var u = userService.Create(json);

        var status = HttpStatus.CREATED;
        var r = ResponseAPI.<UserJson>builder()
                .data(u)
                .status(status)
                .build();
        return new ResponseEntity<>(r, status);
    }

    // TODO : fazer validacao de tipo de body para saber se precisa converter ou não, com isso teremos somente uma função
    @PostMapping("/json")
    public ResponseEntity<ResponseAPI> createWithBodyString(@RequestBody String json) {
        var body = new Gson().fromJson(json, UserJson.class);
        var u = userService.Create(body);

        var status = HttpStatus.CREATED;
        var r = ResponseAPI.<UserJson>builder()
                .data(u)
                .status(status)
                .build();
        return new ResponseEntity<>(r, status);
    }
}
