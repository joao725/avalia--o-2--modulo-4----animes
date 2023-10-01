package br.com.tech4me.plataformasstream.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.plataformasstream.shared.StreamCadastroDTO;
import br.com.tech4me.plataformasstream.shared.StreamCompletoDTO;
import br.com.tech4me.plataformasstream.shared.StreamDTO;

public interface StreamService{
    List<StreamDTO> obterStream();
    Optional<StreamCompletoDTO> obterStreamPorId(String id);
    StreamCompletoDTO cadastrarStream(StreamCadastroDTO dto);
    Optional<StreamCompletoDTO> atualizarStream(String id, StreamCompletoDTO dto);
    void deletarStream(String id);
    
}
