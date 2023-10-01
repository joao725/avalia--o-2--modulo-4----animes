package br.com.tech4me.plataformasstream.model;

import br.com.tech4me.plataformasstream.shared.AnimesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(schema ="catalogo_animes", name ="Anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String nome;
    private Genero genero;
    private Integer anoDeLancamento;
    private String autor;
    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return nome;
    }
    public void setName(String nome) {
        this.nome = nome;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Anime() {
    }
    public Anime(AnimesDTO dto) {
        setId(dto.id());
        setName(dto.nome());
        setGenero(dto.genero());
    }

    public static Anime from(AnimesDTO dto){
        Anime anime = new Anime();
        anime.setId(dto.id());
        anime.setName(dto.nome());
        anime.setGenero(dto.genero());
        return anime;
    }
}
