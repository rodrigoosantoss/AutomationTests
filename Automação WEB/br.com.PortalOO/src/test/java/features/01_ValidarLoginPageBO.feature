#language: pt
#encoding: utf-8

Funcionalidade: Validar a funcionalidade de login_logout  na página BO Auttar
#  Como um usuário
#  Eu quero efetuar login com os meus dados
#  Para encerrar a sessão inicializada

  @First
  Cenário: 01_Acessar página de Login BO Auttar
    Dado que acesso a pagina de login do BO Auttar
    Então valido se a pagina de login carregou corretamente

  Cenário: 02_Acessar BO Auttar com Login
    Dado que estou na pagina de login do BO Auttar
    E insiro "usuario" no campo usuário
    E insiro "senha" no campo senha
    Quando clico no botão "Entrar" na tela de login
    Então a tela principal do BO deverá ser exibida

  @Last
  Cenário: 03_Efetuar logOut página BO
    Dado que estou na pagina principal do BO
    E levo o mouse ate o elemento "IconUser"
    Quando clico no submenu "sair"
    Então a tela de login do BO sera exibido

