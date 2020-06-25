#language: pt
#encoding: utf-8

  @regressivo
Funcionalidade: Menu de Splash

  @splash @mobile
  Cenario: Deve preencher campo de nome
    Dado que acesso o menu splash
    Quando a tela de splash sumir
    Então valido que o menu do formulario esta sendo exibido