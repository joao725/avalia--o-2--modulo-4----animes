package br.com.tech4me.catalogoanimes.shared;

import br.com.tech4me.catalogoanimes.model.Anime;
import br.com.tech4me.catalogoanimes.model.Genero;

public record AnimesDTO(String id, String nome, Genero genero) {

    public static AnimesDTO from(Anime a){
        return new AnimesDTO(a.getId(), a.getName(), a.getGenero());
    }

    public static AnimesDTO filtrarPorGenero(Anime a , Genero genero){
        a.setGenero(genero);
        return new AnimesDTO(a.getId(), a.getName(), a.getGenero());
    }
}
