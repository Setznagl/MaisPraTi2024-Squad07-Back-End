# Alucar — Back-end

Projeto back-end em Java (Spring Boot) responsável pela lógica e APIs do sistema Alucar.

**Resumo:** Aplicação RESTful construída com Spring Boot (3.4.0) e Java 17. Fornece endpoints para gestão de anúncios, usuários, veículos e contratos de aluguel. Inclui configuração para execução local com o Maven Wrapper e exemplos de orquestração via Docker Compose.

## Índice
- Visão geral
- Tecnologias
- Pré-requisitos
- Execução (desenvolvimento e produção)
- Testes
- Banco de dados com Docker
- Estrutura do projeto
- Documentação da API
- Contribuição
- Licença

## Visão geral
Este repositório contém a aplicação back-end do projeto Alucar. A pasta principal da aplicação está em `Alucar/`.

## Tecnologias
- **Linguagem:** Java 17
- **Framework:** Spring Boot 3.4.0
- **Build:** Maven (Maven Wrapper incluído)
- **Banco de dados (runtime):** MySQL (opcional via Docker Compose)

## Pré-requisitos
- Java Development Kit 17 (OpenJDK, Amazon Corretto, Azul Zulu, etc.)
- Git (opcional)
- Docker & Docker Compose (opcional, recomendado para rodar o banco de dados)

## Execução
Recomenda-se utilizar o Maven Wrapper fornecido no diretório `Alucar/`.

Windows (PowerShell):
```
cd Alucar
.\mvnw.cmd spring-boot:run
```

Linux / macOS:
```
cd Alucar
./mvnw spring-boot:run
```

Para empacotar a aplicação (gera o JAR):
```
cd Alucar
./mvnw -DskipTests package    # Unix
# ou
.\mvnw.cmd -DskipTests package  # Windows PowerShell
```

Após o build, o artefato estará em `Alucar/target/` com nome aproximado `Alucar-1.0.0.jar` (conforme `pom.xml`). Execute com:
```
java -jar Alucar/target/Alucar-1.0.0.jar
```

## Testes
Executar a suíte de testes com:
```
cd Alucar
./mvnw test
# ou Windows PowerShell
.\mvnw.cmd test
```

## Banco de dados com Docker
O projeto fornece arquivos de orquestração Docker para facilitar a criação do banco MySQL. O compose para produção encontra-se em:
```
Alucar/Docker/Alucar_Production/docker-compose.yml
```

Inicie os serviços (a partir da pasta que contém o `docker-compose.yml`):
```
docker compose up -d
```

Verifique as instruções e variáveis no README local dentro da pasta Docker, se existir.

## Estrutura do projeto (resumo)
Conteúdo relevante dentro de `Alucar/`:
- `src/main/java/com/maisprati/codifica/alucar/` — código-fonte principal
	- `Controller/` — controllers organizados por método HTTP (GET, POST, PUT, DELETE)
	- `Services/` — lógica de negócio
	- `Repository/` — integração com persistência
	- `Models/` — entidades e DTOs
	- `Exceptions/` — exceções customizadas e handler global
	- `Config/` — configurações (ex.: CORS)
- `src/main/resources/application.properties` — propriedades de configuração
- `Docker/Alucar_Production/` — compose e README para orquestração do banco

## Documentação da API
Documentação (Postman ou similar) vinculada ao repositório:

- Postman / Documenter: https://documenter.getpostman.com/view/37433733/2sAYk7S479

## Contribuição
- Abra issues para bugs e solicitações de funcionalidades.
- Para contribuições via PR: crie uma branch a partir de `main`, faça commits claros e abra um Pull Request descrevendo as alterações.

## Licença
Verifique o arquivo de licença em `Alucar/LICENSE`.
