package br.com.pupo.users.controllers;

import br.com.pupo.users.models.UserJson;
import br.com.pupo.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserJson> create(@RequestBody UserJson json) {
        return new ResponseEntity<>(userService.Create(json), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<UserJson> createWithBodyString(@RequestBody String json) {
        // TODO : converter de string para objeto
        return new ResponseEntity<>(userService.Create(new UserJson()), HttpStatus.CREATED);
    }

/*
    {
    "data": {
        "id": 1,
        "name": "veronica",
        "email": "ve@gmail.com",
        "password": "ver12d4f7",
        "cpf": "41902049861",
        "address": "rua carlos",
        "phone": "987714363",
        "risk": true
    }
}
 */
}
