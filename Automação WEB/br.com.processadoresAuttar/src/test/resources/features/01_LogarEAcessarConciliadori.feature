#language: pt

  Funcionalidade: Logar e Acessar EDI
    Eu como usuário do sistema
    Eu quero Logar no sistema e acessar o menu EDI

  Cenário: Deve Logar no sistema Auttar Dev
    Dado que acessei site Auttar conciliador-dev.auttar
    E informo o usuario "rs73053"
    E senha "Mov@@202011"
    E clico no botão entrar
    E clico no menu "Conciliador"




   #acesso site
  #digito login //input[@id='loginUsuario']
  #digito senha //input[@id='loginSenha']
  #clico no botão entrar  //span[normalize-space()='Entrar']
  #clico no menu EDI //a[@id='formMenu:j_idt38']//span[@class='head-icon head-doc-gear']
  #clico em consultas //ul[@class='nav nav-tabs nav-stacked']//span[@class='text'][normalize-space()='Consultas']
  #clico em consulta processamento arquivo //a[@id='formMenu:forPaiFilhoLinkMenuItem5224']//span[@class='text'][normalize-space()='Consulta Processamento de Arquivos']
