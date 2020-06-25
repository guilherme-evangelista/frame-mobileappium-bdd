#language: pt
#encoding: utf-8

@regressivo
Funcionalidade: Menu de Alerta

  @alert @mobile
  Cenario: Deve confirmar alerta
    Dado que acesso o menu aerta
    Quando confirmo o alerta de confirmacao
    Então valido que voltei pra tela de alertas

  @alertSimples @mobile
  Cenario: Devo clicar fora de um alerta simples
    Dado que acesso o menu aerta
    Quando seleciono o alerta simples e clico fora dele
    Então valido que voltei pra tela de alertas