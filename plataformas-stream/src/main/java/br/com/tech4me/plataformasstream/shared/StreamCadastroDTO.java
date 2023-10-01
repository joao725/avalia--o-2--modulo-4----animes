package br.com.tech4me.plataformasstream.shared;

import br.com.tech4me.plataformasstream.model.TipoDeAssinatura;

public record StreamCadastroDTO(String id, String nome, TipoDeAssinatura tipoAssinatura, Double valorAssinatura, String idAnime) {
    
}
