# CrudAnimal2
Exercicios de Crud projeto Animal

# CrudAnimalMeli

Este é um projeto Spring Boot que fornece uma API REST para gerenciar informações sobre animais. Ele foi desenvolvido como parte do curso de desenvolvimento de software da Meli.

## Funcionalidades

O projeto fornece as seguintes funcionalidades:

- **Criação de animais**: Você pode criar um novo animal fornecendo seu nome, cor e idade.
- **Busca de animais**: Você pode buscar todos os animais ou buscar um animal específico por seu ID, nome ou cor.
- **Atualização de animais**: Você pode atualizar as informações de um animal existente.
- **Exclusão de animais**: Você pode excluir um animal específico ou todos os animais.

## Como usar

Para usar a API, você pode enviar solicitações HTTP para os seguintes endpoints:

- `POST /animals`: Cria um novo animal.
- `GET /animals`: Retorna uma lista de todos os animais.
- `GET /animals/{id}`: Retorna o animal com o ID especificado.
- `PUT /animals/{id}`: Atualiza o animal com o ID especificado.
- `DELETE /animals/{id}`: Exclui o animal com o ID especificado.
- `DELETE /animals`: Exclui todos os animais.

## Testes

O projeto inclui uma série de testes de unidade que verificam o comportamento dos métodos do serviço `AnimalService`. Esses testes usam a biblioteca Mockito para criar mocks do `AnimalService`.

## Tecnologias usadas

- Java
- Spring Boot
- Mockito
- Maven