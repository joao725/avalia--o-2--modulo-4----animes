CREATE TABLE catalogo_animes.anime(
    id text UNIQUE PRIMARY KEY NOT NULL, 
    nome text NOT NULL,
    genero text NOT NULL,
    anoDeLancamento SMALLINT NOT NULL,
    autor text NOT NULL
);