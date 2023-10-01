package br.com.tech4me.plataformasstream.shared;

import br.com.tech4me.plataformasstream.model.Stream;
import br.com.tech4me.plataformasstream.model.TipoDeAssinatura;

public record StreamDTO(String id, String nome, TipoDeAssinatura tipoAssinatura, Double valorAssinatura, String idAnime) {
    
    public static StreamDTO from(Stream stream){
        return new StreamDTO(stream.getId(), stream.getNome(), stream.getTipoAssinatura()
        ,stream.getValorAssinatura(), stream.getAnime().getId());
    }
}
