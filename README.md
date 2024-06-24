# Conversor de Moedas
=====================

Um aplicativo Java para converter valores entre diferentes moedas utilizando a API Exchangerate-API.

## Funcionalidades

* Converte valores entre diferentes moedas (ex: EUR, USD, BRL, etc.)
* Utiliza a API Exchangerate-API para obter taxas de conversão atualizadas
* Permite ao usuário inserir o valor a ser convertido e as moedas de origem e destino
* Exibe o resultado da conversão com a taxa de conversão utilizada

## Requisitos

* Java 11 ou superior
* API Key da Exchangerate-API (obtida gratuitamente no site da Exchangerate-API)

## Como usar

1. Clone o repositório e compile o projeto utilizando o comando `javac`.
2. Execute o aplicativo utilizando o comando `java ConversorDeMoedas`.
3. Insira o valor a ser convertido e as moedas de origem e destino quando solicitado.
4. O aplicativo exibirá o resultado da conversão com a taxa de conversão utilizada.

## Arquitetura do Projeto

* `ConversorDeMoedas.java`: classe principal do aplicativo que realiza a conversão de moedas.
* `HttpClient`: utilizado para realizar requisições HTTP à API Exchangerate-API.
* `JsonParser`: utilizado para parsear a resposta JSON da API Exchangerate-API.
* `JsonObject`: utilizado para armazenar e manipular os dados da resposta JSON.

## Contribuição

Se você deseja contribuir para o projeto, por favor, faça um fork do repositório e envie um pull request com suas alterações.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## Contato

Se você tiver alguma dúvida ou precisar de ajuda, por favor, entre em contato comigo através do email orlandovfo@gmail.com .
