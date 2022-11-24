package br.com.pupo.users.services;

import br.com.pupo.users.config.feign.address.AddressFeign;
import br.com.pupo.users.exceptions.AddressValidationException;
import br.com.pupo.users.models.UserJson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AddressFeign address;

    public UserJson Create(UserJson u) {

        var res = address.Get(u.getCep());
        if (res.getStatusCode() != HttpStatus.OK) {
            throw new AddressValidationException();
        }


        // TODO: Criar um objeto de endereco no UserJson e transferir via construtor os valores
        var json = res.getBody();
        u.setBairro(json.getBairro());
        u.setLograduro(json.getLogradouro());
        u.setComplemento(json.getComplemento());
        u.setUf(json.getUf());

        return u;
    }

/**
 * @Example using RestTemplate
 *
 *         RestTemplate r = new RestTemplate();
 *         var endereco = r.getForObject("https://viacep.com.br/ws/"+ u.getCep()+"/json/", EnderecoJSON.class);
 *         var entity = r.getForEntity("https://viacep.com.br/ws/"+ u.getCep()+"/json/", EnderecoJSON.class);
 *
 *         if (entity.getStatusCodeValue() != 200){
 *             throw new AddressValidationException();
 *         } else {
 *             u.setBairro(entity.getBody().getBairro());
 *             u.setLograduro(entity.getBody().getLogradouro());
 *             u.setComplemento(entity.getBody().getComplemento());
 *             u.setUf(entity.getBody().getUf());
 *             return u;
 *         }
 *
*/

}