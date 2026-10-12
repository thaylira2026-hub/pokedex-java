# ⚡ Pokédex API

API RESTful para cadastro de Pokémon capturados, desenvolvida em **Java com Spring Boot** e banco de dados **Oracle**, seguindo a arquitetura em camadas **Resource → BO → DAO → TO**.

Projeto desenvolvido como atividade prática ("Praticando") das aulas 41 e 42 da disciplina **Domain Driven Design Using Java** da **FIAP**.

---

## 📋 Funcionalidades

- Listar todos os Pokémon cadastrados
- Buscar um Pokémon pelo código
- Cadastrar um novo Pokémon, com validação dos dados (Bean Validation)
- Excluir um Pokémon pelo código

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem |
| Spring Boot 4 (Web MVC) | Criação da API REST |
| Spring Boot Validation | Bean Validation (Hibernate Validator) |
| JDBC + Oracle (ojdbc17) | Acesso ao banco de dados |
| Maven | Gerenciamento de dependências |
| Insomnia | Testes das requisições |

## 🏗️ Arquitetura

```
src/main/java/br/com/fiap
├── PokedexApplication.java     → classe principal (sobe a API)
├── resource/PokemonResource    → recebe as requisições HTTP (endpoints)
├── bo/PokemonBO                → regras de negócio
├── dao/PokemonDAO              → comandos SQL no banco
├── dao/ConnectionFactory       → conexão com o Oracle
└── to/PokemonTO                → objeto de transferência (com as validações)
```

Uma requisição percorre as camadas nesta ordem:
**Cliente → Resource → BO → DAO → Banco**, e a resposta volta pelo mesmo caminho.

## 🔗 Endpoints

URL base: `http://localhost:8080/pokedex`

| Verbo | Endpoint | Descrição | Respostas |
|---|---|---|---|
| `GET` | `/pokedex` | Lista todos os Pokémon | `200 OK` |
| `GET` | `/pokedex/{codigo}` | Busca um Pokémon pelo código | `200 OK` / `404 Not Found` |
| `POST` | `/pokedex` | Cadastra um Pokémon | `201 Created` / `400 Bad Request` |
| `DELETE` | `/pokedex/{codigo}` | Exclui um Pokémon | `204 No Content` / `404 Not Found` |

### Exemplo de corpo (POST)

```json
{
  "nome": "Squirtle",
  "tipo": "Água",
  "nivel": 10,
  "peso": 9.0,
  "dataDaCaptura": "2026-05-02"
}
```

## ✅ Validações (Bean Validation)

| Campo | Regra | Anotação |
|---|---|---|
| `nome` | obrigatório, até 50 caracteres | `@NotBlank` `@Size(max = 50)` |
| `tipo` | obrigatório, até 30 caracteres | `@NotBlank` `@Size(max = 30)` |
| `nivel` | obrigatório, entre 1 e 100 | `@NotNull` `@Min(1)` `@Max(100)` |
| `peso` | obrigatório, maior que zero | `@NotNull` `@Positive` |
| `dataDaCaptura` | obrigatória, hoje ou no passado | `@NotNull` `@PastOrPresent` |

Se algum campo não respeitar a regra (por exemplo, `"nivel": 150`), a API responde `400 Bad Request` e o Pokémon não é salvo.

## 🗄️ Banco de dados

O script `script_ddd_pokemons.sql` cria a tabela e insere alguns Pokémon de exemplo:

```sql
CREATE TABLE ddd_pokemons (
    codigo          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome            VARCHAR2(50) NOT NULL,
    tipo            VARCHAR2(30) NOT NULL,
    nivel           NUMBER(3)    NOT NULL,
    peso            NUMBER(6,2)  NOT NULL,
    data_da_captura DATE         NOT NULL
);
```

## ▶️ Como rodar

1. Rode o `script_ddd_pokemons.sql` no Oracle (SQL Developer, tecla F5).
2. Clone o repositório e abra a pasta do projeto (a que tem o `pom.xml`) no IntelliJ.
3. Clique em **Sync Maven Changes** para baixar as dependências.
4. Em `dao/ConnectionFactory.java`, coloque a URL, o usuário e a senha do seu banco Oracle.
5. Rode a classe `PokedexApplication`, que fica em `src/main`.
6. A API fica disponível em `http://localhost:8080/pokedex`.

## 🧪 Testando com o Insomnia

O arquivo `insomnia_pokedex.json` tem as requisições prontas (findAll, findByCodigo, save e delete).
No Insomnia, vá em **Import**, escolha o arquivo e teste.

---

👨‍💻 Desenvolvido por **[Seu nome]** · FIAP · Domain Driven Design Using Java
