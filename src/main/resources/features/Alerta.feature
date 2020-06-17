#language: pt
#encoding: utf-8

Funcionalidade: Menu de Alerta

  @alert
  Cenario: Deve confirmar alerta
    Dado que acesso o menu aerta
    Quando confirmo o alerta de confirmacao
    Então valido que voltei pra tela de alertas

  @alertSimples
  Cenario: Devo clicar fora de um alerta simples
    Dado que acesso o menu aerta
    Quando seleciono o alerta simples e clico fora dele
    Então valido que voltei pra tela de alertas