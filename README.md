# DSCommerce 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)

# Sobre o projeto
Dscommerce é uma aplicação fullstack desenvolvida com Spring Boot e React. O objetivo do projeto é permitir a visualização de produtos, realizar pedidos, gerenciar esses pedidos e controlar o fluxo de estoque. Durante o desenvolvimento, aprofundei meus conhecimentos em Spring Security, OAuth2, implementação na nuvem, modelagem de banco de dados e criação de APIs.

Front End: https://github.com/Ital023/DSCommerce-FrontEnd

## Layout mobile
![Mobile 1](/assertsReadme/mobile1.png) ![Mobile 2](/assertsReadme/mobile2.png) ![Mobile 3](/assertsReadme/mobile3.png) ![Mobile 4](/assertsReadme/mobile4.png)


## Layout web

![Web 6](/assertsReadme/desktop6.png)
![Web 5](/assertsReadme/desktop5.png)
![Web 4](/assertsReadme/desktop4.png)
![Web 3](/assertsReadme/desktop3.png)
![Web 2](/assertsReadme/desktop2.png)
![Web 1](/assertsReadme/desktop1.png)




## Modelo conceitual
![Modelo Conceitual](/assertsReadme/diagrama.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Front end
- HTML / CSS / JS / TypeScript
- ReactJS
## Implantação em produção
- Back end: Heroku
- Front end web: Netlify
- Banco de dados: Postgresql

# Rotas
&#9679;	Produtos

| Método | Caminho                      | Descrição                                           | Role Necessária                  |
| ------ | ---------------------------- | -------------------------------------------------- | -------------------------------- |
| GET    | /products/{id}             | Retorna um produto específico pelo ID.              | Nenhuma                          |
| GET    | /products                  | Retorna uma lista paginada de produtos, podendo filtrar pelo nome. | Nenhuma            |
| POST   | /products                  | Adiciona um novo produto.                           | ROLE_ADMIN                     |
| PUT    | /products/{id}             | Atualiza os dados de um produto específico pelo ID. | ROLE_ADMIN                     |
| DELETE | /products/{id}             | Remove um produto específico pelo ID.               | ROLE_ADMIN                     |

&#9679;	Pedidos
| Método | Caminho                      | Descrição                                           | Role Necessária                      |
| ------ | ---------------------------- | -------------------------------------------------- | ------------------------------------ |
| GET    | /orders/{id}               | Retorna uma ordem específica pelo ID.              | ROLE_ADMIN ou ROLE_CLIENT        |
| POST   | /orders                    | Cria uma nova ordem.                               | ROLE_CLIENT                        |

&#9679;	Categorias
| Método | Caminho          | Descrição                                      | Role Necessária |
| ------ | ---------------- | --------------------------------------------- | --------------- |
| GET    | /categories    | Retorna a lista de todas as categorias.       | Nenhuma         |

&#9679;	Usuario
| Método | Caminho        | Descrição                                        | Role Necessária                      |
| ------ | -------------- | ----------------------------------------------- | ------------------------------------ |
| GET    | /users/me    | Retorna as informações do usuário autenticado.  | ROLE_ADMIN ou ROLE_CLIENT        |


# Como executar o projeto

## Back end
Pré-requisitos: Java 21

```bash
# clonar repositório
git clone https://github.com/Ital023/DSCommerce.git

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: npm / yarn

```bash
# clonar repositório
git clone https://github.com/Ital023/DSCommerce-FrontEnd.git

# instalar dependências
yarn install

# executar o projeto
yarn start
```
## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Ital023" title="Github do Ítalo Miranda">
        <img src="https://avatars.githubusercontent.com/u/113559117?v=4" width="100px;" alt="Foto do Ítalo Miranda no GitHub"/><br>
        <sub>
          <b>Ítalo Miranda</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
