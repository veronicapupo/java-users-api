package br.com.pupo.users.controllers;

import br.com.pupo.users.models.ResponseAPI;
import br.com.pupo.users.models.UserJson;
import br.com.pupo.users.services.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseAPI> create(@RequestBody UserJson json) {
        var r = new ResponseAPI(userService.Create(json), HttpStatus.CREATED, new String[]{});
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @PostMapping("/json")
    public ResponseEntity<ResponseAPI> createWithBodyString(@RequestBody String json) {
        var body = new Gson().fromJson(json, UserJson.class);
        var r = new ResponseAPI(userService.Create(body), HttpStatus.CREATED, new String[]{});
        return new ResponseEntity<ResponseAPI>(r, HttpStatus.CREATED);
    }
}
