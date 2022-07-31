# Desafio it'spay

Protótipo de API utilizando Java, Spring e H2 em memória para gerenciamento de uma carteira de cartões.
Utiliza Gradle, Java 17, Spring 2.7.2.
Dependências: Spring Boot DevTools, Spring Web, H2 Database, Validation

## Funções
1) Criar cartão. POST em /cartoes:

Recebe um JSON no formato:
```
{
    "numero":"1111-1111-1111-1111",
    "nomeUsuario": "nome",
    "codigoSeguranca": "111",
    "dataValidade": "11/1111"
}
```

Resposta no formato:
```
"cartao": {
        "id": 2,
        "numero": "1111-1111-1111-1111",
        "nomeUsuario": "nome",
        "codigoSeguranca": "111",
        "dataValidade": "11/1111"
    },
    "response": {
        "mensagem": "Cartão criado com sucesso.",
        "statusCode": 200
    }
```

2) Consultar um cartão. GET em /cartoes/{id}
Resposta no formato:
```
{
    "cartao": {
        "id": 1,
        "numero": "1111-1111-1111-1111",
        "nomeUsuario": "ronaldo",
        "codigoSeguranca": "111",
        "dataValidade": "11/1111"
    },
    "response": {
        "mensagem": "Cartão encontrado.",
        "statusCode": 200
    }
}
```


3) Consultar todos os cartões. GET em /cartoes
```
Resposta no formato
{
    "cartao": [
        {
            "id": 1,
            "numero": "1111-1111-1111-1111",
            "nomeUsuario": "nome",
            "codigoSeguranca": "111",
            "dataValidade": "11/1111"
        },
        {
            "id": 2,
            "numero": "1111-1111-1111-1111",
            "nomeUsuario": "nome",
            "codigoSeguranca": "111",
            "dataValidade": "11/1111"
        }
    ],
    "response": {
        "mensagem": "Cartões encontrados!",
        "statusCode": 200
    }
}
```


4) Editar um cartão. PUT em /cartoes/{id}.
Resposta no formato:
```
{
    "cartao": {
        "id": 2,
        "numero": "2222-2222-2222-2222",
        "nomeUsuario": "nome",
        "codigoSeguranca": "222",
        "dataValidade": "22/2222"
    },
    "response": {
        "mensagem": "Cartão atualizado.",
        "statusCode": 200
    }
}
```

5) Deletar um cartão. Delete em /cartoes/{id}
Resposta no formato:
```
{
    "cartao": null,
    "response": {
        "mensagem": "Cartão deletado com sucesso.",
        "statusCode": 200
    }
}
```

Observações: não foi possível retornar conteúdo com o HttpStatus 204 (NO_CONTENT)

## Correções principais a serem feitas:
- As datas de validade não estão sendo tratadas com o tipo Date, apenas como String
- Foram adicionadas algumas Annotations de validação, mas as mensagens de erro não estão sendo retornadas corretamente nas mensagens de resposta
- Adequação do formato das respostas.
