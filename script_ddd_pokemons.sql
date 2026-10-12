-- Rode este script no Oracle (SQL Developer) antes de testar a API

CREATE TABLE ddd_pokemons (
    codigo          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome            VARCHAR2(50) NOT NULL,
    tipo            VARCHAR2(30) NOT NULL,
    nivel           NUMBER(3)    NOT NULL,
    peso            NUMBER(6,2)  NOT NULL,
    data_da_captura DATE         NOT NULL
);

INSERT INTO ddd_pokemons (nome, tipo, nivel, peso, data_da_captura)
VALUES ('Pikachu', 'Elétrico', 25, 6.0, DATE '2025-03-10');

INSERT INTO ddd_pokemons (nome, tipo, nivel, peso, data_da_captura)
VALUES ('Charmander', 'Fogo', 12, 8.5, DATE '2025-06-21');

INSERT INTO ddd_pokemons (nome, tipo, nivel, peso, data_da_captura)
VALUES ('Bulbasaur', 'Planta', 8, 6.9, DATE '2026-01-05');

COMMIT;

SELECT * FROM ddd_pokemons;
