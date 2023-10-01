package br.com.tech4me.plataformasstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tech4me.plataformasstream.model.Stream;

@Repository
public interface StreamRepository extends JpaRepository<Stream, String>{
    
}
