$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Teste.feature");
formatter.feature({
  "name": "Obter Valor da tabela FIPE do veículo de marca GM",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Executar requisição para obter valor tabela FIPE de um veículo",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que eu sei a marca do carro",
  "keyword": "Dado "
});
formatter.match({
  "location": "TesteSteps.queEuSeiAMarcaDoCarro()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o modelo",
  "keyword": "E "
});
formatter.match({
  "location": "TesteSteps.oModelo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o ano do veículo",
  "keyword": "E "
});
formatter.match({
  "location": "TesteSteps.oAnoDoVeiculo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu realizar uma consulta",
  "keyword": "Quando "
});
formatter.match({
  "location": "TesteSteps.euRealizarUmaConsulta()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "é possivel obter o seu atual valor de mercado",
  "keyword": "Então "
});
formatter.match({
  "location": "TesteSteps.ePossivelObterOSeuAtualValorDeMercado()"
});
formatter.result({
  "status": "passed"
});
});