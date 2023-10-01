CREATE TABLE catalogo_animes.stream(
    id text unique PRIMARY KEY NOT NULL,
    nome text NOT NULL,
    tipoAssinatura text NOT NULL,
    valorAssinatura real NOT NULL,
    anime_id text NOT NULL,

    CONSTRAINT fk_stream_anime FOREIGN KEY(anime_id) REFERENCES catalogo_animes.anime(id)
);
