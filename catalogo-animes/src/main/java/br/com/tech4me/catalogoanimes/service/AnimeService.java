package br.com.tech4me.catalogoanimes.service;

import java.util.List;
import java.util.Optional;
import br.com.tech4me.catalogoanimes.model.Genero;
import br.com.tech4me.catalogoanimes.shared.AnimesCompletoDTO;
import br.com.tech4me.catalogoanimes.shared.AnimesDTO;

public interface AnimeService {
    List<AnimesDTO> obterAnimes();
    Optional<AnimesCompletoDTO> obterAnimesPorId(String id);
    AnimesCompletoDTO cadastrarAnimes(AnimesCompletoDTO dto);
    Optional<AnimesCompletoDTO> atualizarAnime(String id, AnimesCompletoDTO dto);
    void excluirAnimePorId(String id);
    List<AnimesDTO> filtrarPorGenero(Genero genero);
}
