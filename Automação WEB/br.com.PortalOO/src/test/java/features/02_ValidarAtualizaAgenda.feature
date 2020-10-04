#language: pt
#encoding: utf-8

Funcionalidade: Validar a Pesquisa de Agendamento
#  Como um usuário
#  Eu quero validar se o processo de atualização de agendamento da base ativa
#  para confirmar se esta sendo confirmada

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

  Cenário: 03_Acessar página Pesquisar Agendamento
    Dado que estou na pagina principal do BO
    E clico no menu "Administração"
    Quando seleciono o submenu "Agendamento"
    Então a página Pesquisar Agendamento será exibido

  Cenário: 04_Selecionar Base ativa na opção Serviço da página Pesquisar Agendamento
    Dado que estou na página Pesquisar Agendamento
    E clico na comboBox "Serviço"
    Quando seleciono a opção "Base Ativa"
    Então a opção base ativa deve estar selecionada

  Cenário: 05_Selecionar Ativo na opção Ativo da página Pesquisar Agendamento
    Dado que a opção de base ativa deve estar selecionada na página Pesquisar Agendamento
    Quando clico na comboBox "Ativo"
    Então a opção base ativo deve estar selecionado

  Cenário: 06_Efetuar Pesquisa status da Base_Ativa
    Dado que estou na página Pesquisar Agendamento, com base_ativa selecionado e Ativo no comboBox Ativo
    Quando clico no botão "Pesquisar"
    Então status da base_ativa deve ser apresentada

  Cenário: 07_Acessar página Manter Agendamento
    Dado que estou com a base_ativa apresentada na página Pesquisar Agendamento
    Quando clico na Lupa "Pesquisar"
    Então página Manter Agendamento será exibido

  Cenário: 08_Acessar Logs de Pesquisa de Agendamento
    Dado que estou na página Manter Agendamento
    Quando clico no fichário "Logs"
    Então histórico de logs será exibido

  Cenário: 09_Verificar último Log de Pesquisa de Agendamento
    Dado que estou com histórico de logs exibido
    Quando clico no botão {string}
    Então na última linha deverá ser apresentado status do log "Sucesso"

  @Last
  Cenário: 03_Efetuar logOut página BO
    Dado que estou na pagina principal do BO
    E levo o mouse ate o elemento "IconUser"
    Quando clico no submenu "sair"
    Então a tela de login do BO sera exibido