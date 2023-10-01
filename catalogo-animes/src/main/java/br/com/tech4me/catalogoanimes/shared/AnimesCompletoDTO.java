package br.com.tech4me.catalogoanimes.shared;

import br.com.tech4me.catalogoanimes.model.Anime;
import br.com.tech4me.catalogoanimes.model.Genero;

public record AnimesCompletoDTO(String id, String nome, Genero genero, Integer anoDeLancamento, String autor) {
    
    public static AnimesCompletoDTO from(Anime a){
        return new AnimesCompletoDTO(a.getId(), a.getName(), a.getGenero(), a.getAnoDeLancamento(), a.getAutor());
        
    }
}
