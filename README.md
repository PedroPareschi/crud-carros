# crud-carros

# API de CRUD de Carros

Feita em Spring Boot com banco de dados PostgreSQL

Como usar:

1. Colocar um valor aleatório no secret do application.properties
2. Fazer cadastro no endpoint "/clientes" nesse formato: 
```json
{
    "nome": "João da Silva",
    "senha": "Abc123",
    "cpf":"12345678901",
    "dataDeNascimento":"1999-01-01"
}
```
3. Fazer login realizando um post para a endpoing /login usando cpf e senha
4. A partir dai, cadastrar carros novos, fazer agendamento e fazer pagamento
