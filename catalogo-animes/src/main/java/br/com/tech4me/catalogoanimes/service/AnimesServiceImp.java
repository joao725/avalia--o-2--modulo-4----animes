package br.com.tech4me.catalogoanimes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.catalogoanimes.model.Anime;
import br.com.tech4me.catalogoanimes.model.Genero;
import br.com.tech4me.catalogoanimes.repository.AnimesRepository;
import br.com.tech4me.catalogoanimes.shared.AnimesCompletoDTO;
import br.com.tech4me.catalogoanimes.shared.AnimesDTO;

@Service
public class AnimesServiceImp implements AnimeService{

    @Autowired
    private AnimesRepository repositorio;

    @Override
    public List<AnimesDTO> obterAnimes() {
        return repositorio.findAll().stream()
        .map(a -> AnimesDTO.from(a)).toList();
    }

    @Override
    public Optional<AnimesCompletoDTO> obterAnimesPorId(String id) {
        Optional<Anime> animeProcurado = repositorio.findById(id);

        if(animeProcurado.isPresent()){
            return Optional.of(AnimesCompletoDTO.from(animeProcurado.get()));
        }
        return Optional.empty();
    }

    @Override
    public AnimesCompletoDTO cadastrarAnimes(AnimesCompletoDTO dto) {
        Anime animeCadastrado = Anime.from(dto);
        repositorio.save(animeCadastrado);
        return AnimesCompletoDTO.from(animeCadastrado);
    }

    @Override
    public Optional<AnimesCompletoDTO> atualizarAnime(String id, AnimesCompletoDTO dto) {
         Optional<Anime> animeProcurado = repositorio.findById(id);

        if(animeProcurado.isPresent()){
            Anime animeAtualizado = new Anime(dto);
            animeAtualizado.setId(id);
            repositorio.save(animeAtualizado);
            return Optional.of(AnimesCompletoDTO.from(animeAtualizado));
        }
        return Optional.empty();
    }

    @Override
    public void excluirAnimePorId(String id) {
       repositorio.deleteById(id);
    }

    @Override
    public List<AnimesDTO> filtrarPorGenero(Genero genero) {
        return repositorio.findAll().stream()
        .map(a -> AnimesDTO.filtrarPorGenero(a, genero)).toList();
    }

    
    
}
