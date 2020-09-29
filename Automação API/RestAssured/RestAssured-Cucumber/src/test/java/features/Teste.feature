#language: pt
  #encoding: utf-8


Funcionalidade: Obter Valor da tabela FIPE do veículo de marca GM

  Cenário: Executar requisição para obter valor tabela FIPE de um veículo
    Dado que eu sei a marca do carro
    E o modelo
    E o ano do veículo
    Quando eu realizar uma consulta
    Então é possivel obter o seu atual valor de mercado
