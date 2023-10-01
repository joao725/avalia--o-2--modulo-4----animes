package br.com.tech4me.catalogoanimes.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.catalogoanimes.model.Genero;
import br.com.tech4me.catalogoanimes.service.AnimeService;
import br.com.tech4me.catalogoanimes.shared.AnimesCompletoDTO;
import br.com.tech4me.catalogoanimes.shared.AnimesDTO;

@RestController
@RequestMapping("/animes")
public class AnimesController {

    @Autowired
    private AnimeService servico;

    @GetMapping
    public ResponseEntity<List<AnimesDTO>> obterAnimes(){
        return new ResponseEntity<>(servico.obterAnimes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimesCompletoDTO> obterAnimePorId(@PathVariable String id){
        Optional<AnimesCompletoDTO> animeDto = servico.obterAnimesPorId(id);

        if(animeDto.isPresent()){
             return new ResponseEntity<>(animeDto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<AnimesCompletoDTO> cadastrarAnime(@RequestBody AnimesCompletoDTO dto){
        return new ResponseEntity<>(servico.cadastrarAnimes(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimesCompletoDTO> atualizarAnime(@PathVariable String id, @RequestBody AnimesCompletoDTO dto){
        Optional<AnimesCompletoDTO> animeDto = servico.atualizarAnime(id, dto);

        if(animeDto.isPresent()){
            return new ResponseEntity<>(animeDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnime(@PathVariable String id){
        servico.excluirAnimePorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<AnimesDTO>> filtrarPorGenero(@PathVariable Genero genero){
        return new ResponseEntity<>(servico.filtrarPorGenero(genero), HttpStatus.OK);
    }
}
