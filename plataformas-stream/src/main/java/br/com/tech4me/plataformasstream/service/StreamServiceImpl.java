package br.com.tech4me.plataformasstream.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.plataformasstream.httpClient.AnimeClient;
import br.com.tech4me.plataformasstream.model.Anime;
import br.com.tech4me.plataformasstream.model.Stream;
import br.com.tech4me.plataformasstream.repository.StreamRepository;
import br.com.tech4me.plataformasstream.shared.StreamCadastroDTO;
import br.com.tech4me.plataformasstream.shared.StreamCompletoDTO;
import br.com.tech4me.plataformasstream.shared.StreamDTO;

public class StreamServiceImpl implements StreamService{

    @Autowired
    private StreamRepository repositorio;

    @Autowired
    private AnimeClient cliente;
    
    @Override
    public List<StreamDTO> obterStream() {
       return repositorio.findAll().stream().map(s -> StreamDTO.from(s)).toList();
    }

    @Override
    public Optional<StreamCompletoDTO> obterStreamPorId(String id) {
        Optional<Stream> stream = repositorio.findById(id);

        if(stream.isPresent()){
            return Optional.of(StreamCompletoDTO.from(stream.get()));
        }
        return Optional.empty();
    }

    @Override
    public StreamCompletoDTO cadastrarStream(StreamCadastroDTO dto) {
        Anime a = Anime.from(cliente.obterAnimePorId(dto.idAnime()));
        Stream s = Stream.fromCadastro(dto, a);
        repositorio.save(s);
        return StreamCompletoDTO.from(s);
    }

    @Override
    public Optional<StreamCompletoDTO> atualizarStream(String id, StreamCompletoDTO dto) {
        Optional<Stream> stream = repositorio.findById(id);

        if(stream.isPresent()){
            Stream streamAtualizado = new Stream(dto);
            streamAtualizado.setId(id);
            repositorio.save(streamAtualizado);
            return Optional.of(StreamCompletoDTO.from(streamAtualizado));
        }
        return Optional.empty();
    }

    @Override
    public void deletarStream(String id) {
       repositorio.deleteById(id);
    }
    
}
