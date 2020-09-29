Feature: Teste para QA da Plataforma Digital Sicredi

  Background:
  - A página de simulação carregou corretamente

  Scenario Outline: Teste dinâmico
    Given que o usuário de perfil "<perfil>" quer aplicar "<aplicacao>" reais
    And quer aplicar "<aplicacao por mes>" por mês
    And quer aplicar por "<tempo de aplicacao>" durante "<medida>"
    When ele apertar o botão de simular
    Then ele receberá a "<comportamento esperado>"

    Examples:
      | perfil  | aplicacao | aplicacao por mes | tempo de aplicacao | medida | comportamento esperado                                 |
      | voce    | 5000      | 300               | 3                  | meses  | SUCESSO                                                |
      | voce    | 1500      | 1000              | 3                  | anos   | SUCESSO                                                |
      | voce    | 00        | 1000              | 1                  | meses  | ERRO - Valor Minimo Aplicar                            |
      | voce    | 1500      | 00                | 1                  | meses  | ERRO                                                   |
      | voce    | 1500      | 1000              | 00                 | meses  | ERRO                                                   |
      | voce    | 1500      | 00                | 00                 | meses  | ERRO                                                   |
      | voce    | 00        | 1000              | 00                 | meses  | ERRO - Valor Minimo Aplicar,ERRO - Valor Obrigatorio   |
      | voce    | 00        | 00                | 3                  | meses  | ERRO - Valor Minimo Aplicar,ERRO - Valor Minimo Poupar |
      | voce    | 300       | 19                | 3                  | meses  | ERRO                                                   |
      | voce    | 19        | 300               | 3                  | meses  | ERRO - Valor Minimo Aplicar                            |
      | empresa | 5000      | 300               | 3                  | meses  | SUCESSO                                                |
      | empresa | 1500      | 1000              | 3                  | anos   | SUCESSO                                                |
      | empresa | 00        | 1000              | 1                  | meses  | ERRO - Valor Minimo Aplicar                            |
      | empresa | 1500      | 00                | 1                  | meses  | ERRO                                                   |
      | empresa | 1500      | 1000              | 00                 | meses  | ERRO                                                   |
      | empresa | 1500      | 00                | 00                 | meses  | ERRO                                                   |
      | empresa | 00        | 1000              | 00                 | meses  | ERRO - Valor Minimo Aplicar,ERRO - Valor Obrigatorio   |
      | empresa | 00        | 00                | 3                  | meses  | ERRO - Valor Minimo Aplicar,ERRO - Valor Minimo Poupar |
      | empresa | 300       | 19                | 3                  | meses  | ERRO                                                   |
      | empresa | 19        | 300               | 3                  | meses  | ERRO - Valor Minimo Aplicar                            |
      | empresa | 0         | 300               | 3                  | meses  | ERRO - Valor Minimo Aplicar                            |
      | empresa | 19.99     | 300               | 3                  | meses  | ERRO - Valor Minimo Aplicar                            |