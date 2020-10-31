$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_AbrirConta.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 3,
  "name": "Cadastrar uma nova conta",
  "description": "Eu como um usuário\r\nEu quero cadastrar uma nova conta",
  "id": "cadastrar-uma-nova-conta",
  "keyword": "Funcionalidade"
});
formatter.before({
  "duration": 172900,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Deve Logar e inserir uma conta com sucesso",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-logar-e-inserir-uma-conta-com-sucesso",
  "type": "scenario",
  "keyword": "Cenário"
});
formatter.step({
  "line": 9,
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.step({
  "line": 10,
  "name": "informo o usuário \"rodrigo@terra.com.br\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 11,
  "name": "a senha \"rodrigo\"",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "seleciono entrar",
  "keyword": "E "
});
formatter.step({
  "line": 13,
  "name": "visualizo a página inicial",
  "keyword": "Então "
});
formatter.step({
  "line": 14,
  "name": "seleciono Contas",
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "seleciono Adicionar",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "iinformo a conta Conta de Teste15",
  "keyword": "E "
});
formatter.step({
  "line": 17,
  "name": "seleciono Salvar",
  "keyword": "E "
});
formatter.step({
  "line": 18,
  "name": "a conta é inserida com sucesso",
  "keyword": "Então "
});
formatter.match({
  "location": "AbrirContaSteps.que_estou_acessando_a_aplicação()"
});
formatter.result({
  "duration": 5541774200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo@terra.com.br",
      "offset": 19
    }
  ],
  "location": "AbrirContaSteps.informo_o_usuário(String)"
});
formatter.result({
  "duration": 101291600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo",
      "offset": 9
    }
  ],
  "location": "AbrirContaSteps.a_senha(String)"
});
formatter.result({
  "duration": 67718800,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_entrar()"
});
formatter.result({
  "duration": 691194800,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.visualizo_a_página_inicial()"
});
formatter.result({
  "duration": 31190800,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Contas()"
});
formatter.result({
  "duration": 53586300,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Adicionar()"
});
formatter.result({
  "duration": 752101900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Conta de Teste15",
      "offset": 17
    }
  ],
  "location": "AbrirContaSteps.iinformo_a_conta(String)"
});
formatter.result({
  "duration": 74988800,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Salvar()"
});
formatter.result({
  "duration": 501680900,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.a_conta_é_inserida_com_sucesso()"
});
formatter.result({
  "duration": 89033600,
  "status": "passed"
});
formatter.after({
  "duration": 641182000,
  "status": "passed"
});
formatter.uri("02_AbrirContaOtimizado.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 3,
  "name": "Cadastrar uma nova conta",
  "description": "Eu como um usuário\r\nEu quero cadastrar uma nova conta",
  "id": "cadastrar-uma-nova-conta",
  "keyword": "Funcionalidade"
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Deve validar regras contas",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenário"
});
formatter.step({
  "line": 17,
  "name": "iinformo a conta \"\u003cconta\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 18,
  "name": "seleciono Salvar",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "recebo a mensagem \u003cmensagem\u003e",
  "keyword": "Então "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;",
  "rows": [
    {
      "cells": [
        "conta",
        "mensagem"
      ],
      "line": 21,
      "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;1"
    },
    {
      "cells": [
        "conta de teste",
        "Conta adicionada com sucesso!"
      ],
      "line": 22,
      "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;2"
    },
    {
      "cells": [
        "",
        "Conta adicionada com sucesso!"
      ],
      "line": 23,
      "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;3"
    },
    {
      "cells": [
        "Conta mesmo nome",
        "Conta adicionada com sucesso!"
      ],
      "line": 24,
      "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;4"
    }
  ],
  "keyword": "Exemplos"
});
formatter.before({
  "duration": 34300,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 8,
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.step({
  "line": 9,
  "name": "informo o usuário \"rodrigo@terra.com.br\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "a senha \"rodrigo\"",
  "keyword": "E "
});
formatter.step({
  "line": 11,
  "name": "seleciono entrar",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "visualizo a página inicial",
  "keyword": "Então "
});
formatter.step({
  "line": 13,
  "name": "seleciono Contas",
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "seleciono Adicionar",
  "keyword": "E "
});
formatter.match({
  "location": "AbrirContaSteps.que_estou_acessando_a_aplicação()"
});
formatter.result({
  "duration": 3407302900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo@terra.com.br",
      "offset": 19
    }
  ],
  "location": "AbrirContaSteps.informo_o_usuário(String)"
});
formatter.result({
  "duration": 100984600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo",
      "offset": 9
    }
  ],
  "location": "AbrirContaSteps.a_senha(String)"
});
formatter.result({
  "duration": 66006100,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_entrar()"
});
formatter.result({
  "duration": 1152576700,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.visualizo_a_página_inicial()"
});
formatter.result({
  "duration": 35200900,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Contas()"
});
formatter.result({
  "duration": 60496300,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Adicionar()"
});
formatter.result({
  "duration": 572857900,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Deve validar regras contas",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenário"
});
formatter.step({
  "line": 17,
  "name": "iinformo a conta \"conta de teste\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 18,
  "name": "seleciono Salvar",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "recebo a mensagem Conta adicionada com sucesso!",
  "matchedColumns": [
    1
  ],
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "\"conta de teste\"",
      "offset": 17
    }
  ],
  "location": "AbrirContaSteps.iinformo_a_conta(String)"
});
formatter.result({
  "duration": 83069300,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Salvar()"
});
formatter.result({
  "duration": 499072400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Conta adicionada com sucesso!",
      "offset": 18
    }
  ],
  "location": "AbrirContaSteps.receboAMensagem(String)"
});
formatter.result({
  "duration": 28582800,
  "status": "passed"
});
formatter.after({
  "duration": 1138464800,
  "status": "passed"
});
formatter.before({
  "duration": 29000,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 8,
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.step({
  "line": 9,
  "name": "informo o usuário \"rodrigo@terra.com.br\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "a senha \"rodrigo\"",
  "keyword": "E "
});
formatter.step({
  "line": 11,
  "name": "seleciono entrar",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "visualizo a página inicial",
  "keyword": "Então "
});
formatter.step({
  "line": 13,
  "name": "seleciono Contas",
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "seleciono Adicionar",
  "keyword": "E "
});
formatter.match({
  "location": "AbrirContaSteps.que_estou_acessando_a_aplicação()"
});
formatter.result({
  "duration": 3471265200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo@terra.com.br",
      "offset": 19
    }
  ],
  "location": "AbrirContaSteps.informo_o_usuário(String)"
});
formatter.result({
  "duration": 98157700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo",
      "offset": 9
    }
  ],
  "location": "AbrirContaSteps.a_senha(String)"
});
formatter.result({
  "duration": 80528100,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_entrar()"
});
formatter.result({
  "duration": 895021200,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.visualizo_a_página_inicial()"
});
formatter.result({
  "duration": 37815400,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Contas()"
});
formatter.result({
  "duration": 56565200,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Adicionar()"
});
formatter.result({
  "duration": 246727800,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Deve validar regras contas",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;3",
  "type": "scenario",
  "keyword": "Esquema do Cenário"
});
formatter.step({
  "line": 17,
  "name": "iinformo a conta \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 18,
  "name": "seleciono Salvar",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "recebo a mensagem Conta adicionada com sucesso!",
  "matchedColumns": [
    1
  ],
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "\"\"",
      "offset": 17
    }
  ],
  "location": "AbrirContaSteps.iinformo_a_conta(String)"
});
formatter.result({
  "duration": 75900900,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Salvar()"
});
formatter.result({
  "duration": 422180600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Conta adicionada com sucesso!",
      "offset": 18
    }
  ],
  "location": "AbrirContaSteps.receboAMensagem(String)"
});
formatter.result({
  "duration": 31772100,
  "status": "passed"
});
formatter.after({
  "duration": 1336670000,
  "status": "passed"
});
formatter.before({
  "duration": 129400,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 8,
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.step({
  "line": 9,
  "name": "informo o usuário \"rodrigo@terra.com.br\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "a senha \"rodrigo\"",
  "keyword": "E "
});
formatter.step({
  "line": 11,
  "name": "seleciono entrar",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "visualizo a página inicial",
  "keyword": "Então "
});
formatter.step({
  "line": 13,
  "name": "seleciono Contas",
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "seleciono Adicionar",
  "keyword": "E "
});
formatter.match({
  "location": "AbrirContaSteps.que_estou_acessando_a_aplicação()"
});
formatter.result({
  "duration": 3476225700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo@terra.com.br",
      "offset": 19
    }
  ],
  "location": "AbrirContaSteps.informo_o_usuário(String)"
});
formatter.result({
  "duration": 105756700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rodrigo",
      "offset": 9
    }
  ],
  "location": "AbrirContaSteps.a_senha(String)"
});
formatter.result({
  "duration": 71323000,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_entrar()"
});
formatter.result({
  "duration": 666740400,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.visualizo_a_página_inicial()"
});
formatter.result({
  "duration": 31671700,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Contas()"
});
formatter.result({
  "duration": 52218800,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Adicionar()"
});
formatter.result({
  "duration": 270084100,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Deve validar regras contas",
  "description": "",
  "id": "cadastrar-uma-nova-conta;deve-validar-regras-contas;;4",
  "type": "scenario",
  "keyword": "Esquema do Cenário"
});
formatter.step({
  "line": 17,
  "name": "iinformo a conta \"Conta mesmo nome\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 18,
  "name": "seleciono Salvar",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "recebo a mensagem Conta adicionada com sucesso!",
  "matchedColumns": [
    1
  ],
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "\"Conta mesmo nome\"",
      "offset": 17
    }
  ],
  "location": "AbrirContaSteps.iinformo_a_conta(String)"
});
formatter.result({
  "duration": 80239300,
  "status": "passed"
});
formatter.match({
  "location": "AbrirContaSteps.seleciono_Salvar()"
});
formatter.result({
  "duration": 365486000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Conta adicionada com sucesso!",
      "offset": 18
    }
  ],
  "location": "AbrirContaSteps.receboAMensagem(String)"
});
formatter.result({
  "duration": 30139500,
  "status": "passed"
});
formatter.after({
  "duration": 654083000,
  "status": "passed"
});
});