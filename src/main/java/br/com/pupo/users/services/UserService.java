package br.com.pupo.users.services;

import br.com.pupo.users.exceptions.AddressValidationException;
import br.com.pupo.users.models.EnderecoJSON;
import br.com.pupo.users.models.UserJson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    public UserJson Create(UserJson u) {

        RestTemplate r = new RestTemplate();

        var endereco = r.getForObject("https://viacep.com.br/ws/"+ u.getCep()+"/json/", EnderecoJSON.class);
        var entity = r.getForEntity("https://viacep.com.br/ws/"+ u.getCep()+"/json/", EnderecoJSON.class);

        if (entity.getStatusCodeValue() != 200){
            throw new AddressValidationException();
        } else {
            u.setBairro(entity.getBody().getBairro());
            u.setLograduro(entity.getBody().getLogradouro());
            u.setComplemento(entity.getBody().getComplemento());
            u.setUf(entity.getBody().getUf());
            return u;
        }

    }

}