package br.com.tech4me.plataformasstream.shared;

import br.com.tech4me.plataformasstream.model.Anime;
import br.com.tech4me.plataformasstream.model.Genero;

public record AnimesDTO(String id, String nome, Genero genero) {
    
     public static AnimesDTO from(Anime a){
        return new AnimesDTO(a.getId(), a.getName(), a.getGenero());
    }
}
