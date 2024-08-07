# CRUD de Pessoa e Endereço

    Este projeto foi desenvolvido em Java utilizando o framework Spring Boot para criar um CRUD (Create, Read, Update, Delete) para as entidades Pessoa e Endereço. A relação entre essas entidades é de um-para-muitos, ou seja, uma pessoa pode ter vários endereços.


 ## Funcionalidades

    O sistema oferece as seguintes funcionalidades:

    Listagem de Pessoas e Endereços
    Permite visualizar todas as pessoas cadastradas juntamente com seus respectivos endereços.

    Cadastro de uma Nova Pessoa
    Permite criar uma nova pessoa no sistema, fornecendo informações como nome, data de nascimento e CPF.

    Cadastro de um Novo Endereço
    Permite criar um novo endereço no sistema, fornecendo o CPF da pessoa que você deseja vincular o endereço, a rua, número, bairro , cidade,  estado, CEP e se ele é o endereço principal.

    Atualização de Dados
    Permite atualizar os dados de uma pessoa, incluindo informações pessoais e endereços associados.

    Exclusão de Pessoa
    Permite excluir uma pessoa do sistema, juntamente com todos os seus endereços associados.

    Cálculo da Idade
    Calcula e exibe a idade da pessoa com base na sua data de nascimento.


## Tecnologias Utilizadas

    Java
    Spring Boot
    Spring Boot JPA
    Postgres SQL
    Docker 
    API Rest
    Requisições HTTP
    Json
    DTO
    Bean Validation
    Paginação e Ordenação 
    Testes Unitarios - Junit e Mockito


## Executando o Projeto

    Clone este repositório para sua máquina local.
    Abra o projeto em sua IDE Java preferida.
    Execute o seguinte comando no terminal : "docker compose up -d" para que o banco de dados seja criado remotamente no docker
    Execute a aplicação Spring Boot.
    Acesse a documentação da API Swagger em http://localhost:8080/swagger-ui.html.


## Desenvolvedora Responsável 

    Samara Bastos
    linkedin : https://www.linkedin.com/in/samara-bastos-397375241/
