#language: pt

Funcionalidade: Cadastrar uma nova conta
  Eu como um usuário
  Eu quero cadastrar uma nova conta


  Cenário: Deve Logar e inserir uma conta com sucesso
    Dado que estou acessando a aplicação
    Quando informo o usuário "rodrigo@terra.com.br"
    E a senha "rodrigo"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E iinformo a conta Conta de Teste15
    E seleciono Salvar
    Então a conta é inserida com sucesso
