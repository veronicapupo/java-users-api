package br.com.pupo.users.services;

import br.com.pupo.users.models.UserJson;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserJson Create(UserJson u) {
//            throw new AddressValidationException();

        //TODO validar nas apis o cep https://viacep.com.br/ws/02442070/json/
        return u;
    }

}