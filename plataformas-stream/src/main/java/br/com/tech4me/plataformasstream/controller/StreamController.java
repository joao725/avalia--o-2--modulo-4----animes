package br.com.tech4me.plataformasstream.controller;

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
import br.com.tech4me.plataformasstream.service.StreamService;
import br.com.tech4me.plataformasstream.shared.StreamCadastroDTO;
import br.com.tech4me.plataformasstream.shared.StreamCompletoDTO;
import br.com.tech4me.plataformasstream.shared.StreamDTO;

@RestController
@RequestMapping("/stream")
public class StreamController {
    
    @Autowired
    private StreamService servico;

    @GetMapping
     public ResponseEntity<List<StreamDTO>> obterAnimes(){
        return new ResponseEntity<>(servico.obterStream(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamCompletoDTO> obterAnimePorId(@PathVariable String id){
        Optional<StreamCompletoDTO> streamDto = servico.obterStreamPorId(id);

        if(streamDto.isPresent()){
             return new ResponseEntity<>(streamDto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<StreamCompletoDTO> cadastrarStream(@RequestBody StreamCadastroDTO dto){
        return new ResponseEntity<>(servico.cadastrarStream(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamCompletoDTO> atualizarAnime(@PathVariable String id, @RequestBody StreamCompletoDTO dto){
        Optional<StreamCompletoDTO> streamDto = servico.atualizarStream(id, dto);

        if(streamDto.isPresent()){
            return new ResponseEntity<>(streamDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnime(@PathVariable String id){
        servico.deletarStream(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
