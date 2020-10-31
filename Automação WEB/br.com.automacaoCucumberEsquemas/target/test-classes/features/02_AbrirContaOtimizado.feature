#language: pt

Funcionalidade: Cadastrar uma nova conta
  Eu como um usuário
  Eu quero cadastrar uma nova conta

  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "rodrigo@terra.com.br"
    E a senha "rodrigo"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar

    Esquema do Cenário: Deve validar regras contas
      Quando iinformo a conta "<conta>"
      E seleciono Salvar
      Então recebo a mensagem <mensagem>
      Exemplos:
      |conta             |mensagem                           |
      |conta de teste    | Conta adicionada com sucesso!     |
      |                  | Conta adicionada com sucesso!     |
      | Conta mesmo nome | Conta adicionada com sucesso!     |
