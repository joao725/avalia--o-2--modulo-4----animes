package br.com.tech4me.catalogoanimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tech4me.catalogoanimes.model.Anime;

@Repository
public interface AnimesRepository extends JpaRepository<Anime, String>{
    
}
