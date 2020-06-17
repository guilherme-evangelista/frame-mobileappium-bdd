#language: pt
#encoding: utf-8

  Funcionalidade: Menu de formulario

    @formulario @campoNome
    Cenario: Deve preencher campo de nome
      Dado que acesso o menu formulario
      Quando preencho o campo nome com "Guilherme Gomes"
      Então valido que o campo foi preenchido

    @formulario @completo
    Cenario: Deve preencher o formulario completo e validar o cadastro
      Dado que acesso o menu formulario
      Quando preencho os todos os campos e salvo
      Então valido que os campos salvos correnpondem aos inseridos

    @formulario @completo @demorado
    Cenario: Deve preencher o formulario completo salvando de forma demorada e validar o cadastro
      Dado que acesso o menu formulario
      Quando preencho os todos os campos e salvo demorado
      Então valido que os campos salvos correnpondem aos inseridos

    @dateTime
    Cenario: Deve escolher uma data e hora no formulario
      Dado que acesso o menu formulario
      Quando escolho a data "18""04""2000"
      E escolho a hora 10:30
      Entao valido que a data selecionada no formulario esta sendo exibida
