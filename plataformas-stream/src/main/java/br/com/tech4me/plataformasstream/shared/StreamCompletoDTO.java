package br.com.tech4me.plataformasstream.shared;

import br.com.tech4me.plataformasstream.model.Anime;
import br.com.tech4me.plataformasstream.model.Stream;
import br.com.tech4me.plataformasstream.model.TipoDeAssinatura;

public record StreamCompletoDTO(String id, String nome, TipoDeAssinatura tipoAssinatura, Double valorAssinatura, Anime anime) {
    
    public static StreamCompletoDTO from(Stream stream){
        return new StreamCompletoDTO(stream.getId(), stream.getNome(), stream.getTipoAssinatura()
        ,stream.getValorAssinatura(), stream.getAnime());
    }
}
