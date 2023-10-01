package br.com.tech4me.plataformasstream.model;

import br.com.tech4me.plataformasstream.shared.StreamCadastroDTO;
import br.com.tech4me.plataformasstream.shared.StreamCompletoDTO;
import br.com.tech4me.plataformasstream.shared.StreamDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema ="catalogo_animes", name = "Stream")
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private TipoDeAssinatura tipoAssinatura;
    private double valorAssinatura;
    @JoinColumn(name = "anime_id")
    @OneToMany
    private Anime anime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public TipoDeAssinatura getTipoAssinatura() {
        return tipoAssinatura;
    }
    public void setTipoAssinatura(TipoDeAssinatura tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }
    public double getValorAssinatura() {
        return valorAssinatura;
    }
    public void setValorAssinatura(double valorAssinatura) {
        this.valorAssinatura = valorAssinatura;
    }
    public Anime getAnime() {
        return anime;
    }
    public void setAnime(Anime anime) {
        this.anime = anime;
    }
    public Stream(){

    }
    public Stream(StreamCompletoDTO dto){
        setId(dto.id());
        setNome(dto.nome());
        setTipoAssinatura(dto.tipoAssinatura());
        setValorAssinatura(dto.valorAssinatura());
        setAnime(dto.anime());

    }
    public static Stream fromCompletoDTO(StreamCompletoDTO dto) {
        Stream s = new Stream();
        s.setId(dto.id());
        s.setNome(dto.nome());
        s.setTipoAssinatura(dto.tipoAssinatura());
        s.setValorAssinatura(dto.valorAssinatura());
        s.setAnime(dto.anime());
        return s;
    }
    public static Stream fromDTO(StreamDTO dto) {
        Stream s = new Stream();
        s.setId(dto.id());
        s.setNome(dto.nome());
        s.setTipoAssinatura(dto.tipoAssinatura());
        s.setValorAssinatura(dto.valorAssinatura());
        return s;
    }

    public static Stream fromCadastro(StreamCadastroDTO dto, Anime anime){
        Stream s = new Stream();
        s.setId(dto.id());
        s.setNome(dto.nome());
        s.setTipoAssinatura(dto.tipoAssinatura());
        s.setValorAssinatura(dto.valorAssinatura());
        s.setAnime(anime);
        return s;
    }
}
