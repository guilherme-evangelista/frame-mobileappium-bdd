#language: pt
#encoding: utf-8

Funcionalidade: Menu de Splash

  @splash
  Cenario: Deve preencher campo de nome
    Dado que acesso o menu splash
    Quando a tela de splash sumir
    Então valido que o menu do formulario esta sendo exibido