# Compartilhando

Compartilhadno é um projeto de uma micro rede social que permite compartilhar imagens e textos, com interações entre os usuários atraves de curtidas, 
comentários e a ação de seguir outro usuário

### Este repositório contém a API do sistema, o front-end será implementado em react com bootstrap 

### Requisitos para executar o projeto
-   Kit de desenvolvimento JAVA  `jdk-8` ([[https://java.com/pt_BR/]](https://java.com/pt_BR/%5D))
-   Uma IDE que execute projetos Java com SpringBoot, (recomendo o Spring tool suite)

#### Clonar o repositório

Para realizar um clone do projeto, execute:
```
git clone https://github.com/gustals/Compartilhando.git
```
#### Definir path das imagens

- Abrir o arquivo application.properties (src/main/resource/application.properties)
- Alterar as variaves locais para que apontem para as mesmas pastas do projeto na sua mquina:
- compartilhando.imagens.raiz
- compartilhando.imagens.fotos.perfilPadrao
- compartilhando.imagens.fotos.postPadrao

#### Executar projeto

- Abra o projeto na IDE
- Escolha a opção de execução (Run as): "Executar como Spring Boot App"
- Acesse a documenrtação da Api pelo navegador: [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

OBS.: PRETENDO ALTERAR A DOCUMENTAÇÃO DA API PARA O POSTMAN, O SWAGGER DIFICULTA BASTANTE O UPLOAD DE IMAGENS

``

