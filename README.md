# ⛽ FuelControl API

O **FuelControl** é uma API construída em Spring Boot (Java) para gestão de gasolineiras, preços de combustíveis e descontos associados.

Nesta fase inicial, o projeto utiliza uma base de dados em memória (`BaseDadosMemoria`) para validar a lógica de negócio e os endpoints da API. O objetivo final é criar um sistema inteligente que ajude os utilizadores a pouparem dinheiro, calculando qual a bomba mais barata com base nos cartões de desconto que possuem. Utilizando uma base de dados MySQL.

## 🚀 Funcionalidades Atuais (Fase 1)
- **Gestão de Preços:**
    - Alterar o preço de um combustível específico (Gasolina 95, 98, Gasóleo Simples, Aditivado) numa gasolineira.
    - Consultar o preçário completo de uma gasolineira.
- **Gestão de Descontos:**
    - Consultar todos os descontos ativos associados a uma marca (ex: BP, Galp).
- **Documentação:**
    - Interface Swagger / OpenAPI ativa para testes dos endpoints.

## 🗺️ Roadmap (Próximos Passos)
- [ ] **Persistência de Dados:** Migrar a `BaseDadosMemoria` para uma base de dados real (MySQL) utilizando o Spring Data JPA.
- [ ] **Gestão de Utilizadores:** Implementar o modelo `Utilizador` e associar os cartões de desconto (ex: Cartão Benfica, Cartão Pingo Doce) ao perfil de cada pessoa.
- [ ] **Algoritmo de Poupança (Smart Choice):** Criar um serviço que, dado um `Utilizador` e a sua localização, cruze os preços base das gasolineiras com os descontos que ele tem no perfil, devolvendo a opção mais barata em tempo real.

## 🛠️ Tecnologias Utilizadas
* Java 25
* Spring Boot 4.0.6
* Lombok (Redução de boilerplate code)
* SpringDoc OpenAPI (Swagger UI)

## ⚙️ Como testar a aplicação
1. Executar a classe `FuelControlApplication`.
2. Abrir o navegador no endereço: `http://localhost:8080/swagger-ui/index.html`
3. Utilizar a interface para enviar pedidos GET e POST.