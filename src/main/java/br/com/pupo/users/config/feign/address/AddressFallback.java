package br.com.pupo.users.config.feign.address;

import br.com.pupo.users.models.EnderecoJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class AddressFallback implements AddressFeign {

    @Override
    public ResponseEntity<EnderecoJSON> Get(String cep) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}