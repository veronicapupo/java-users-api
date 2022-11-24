package br.com.pupo.users.config.feign.address;

import br.com.pupo.users.models.EnderecoJSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/", fallback = AddressFallback.class)
public interface AddressFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    ResponseEntity<EnderecoJSON> Get(@PathVariable("cep") String cep);
}

