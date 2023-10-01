package br.com.tech4me.plataformasstream.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.tech4me.plataformasstream.shared.AnimesDTO;

@FeignClient("catalogo-animes")
public interface AnimeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/animes/{id}")
    AnimesDTO obterAnimePorId(@PathVariable String id);
}
