#language: pt
#encoding: utf-8

@regressivo
Funcionalidade: Menu de formulario

    @formulario @campoNome @mobile
    Cenario: Deve preencher campo de nome
      Dado que acesso o menu formulario
      Quando preencho o campo nome com "Guilherme Gomes"
      Então valido que o campo foi preenchido

    @formulario @completo @mobile
    Cenario: Deve preencher o formulario completo e validar o cadastro
      Dado que acesso o menu formulario
      Quando preencho os todos os campos e salvo
      Então valido que os campos salvos correnpondem aos inseridos

    @formulario @completo @demorado @mobile
    Cenario: Deve preencher o formulario completo salvando de forma demorada e validar o cadastro
      Dado que acesso o menu formulario
      Quando preencho os todos os campos e salvo demorado
      Então valido que os campos salvos correnpondem aos inseridos

#    @dateTime @mobile
#    Cenario: Deve escolher uma data e hora no formulario
#      Dado que acesso o menu formulario
#      Quando escolho a data "18""04""2000"
#      E escolho a hora 10:30
#      Entao valido que a data selecionada no formulario esta sendo exibida

#    @seekBar @mobile
#    Cenario: Deve escolher uma data e hora no formulario
#      Dado que acesso o menu formulario
#      Quando movo o seekbar para 25%
#      E clico em salvar
#      Entao valido que o valor do seek cadastrado eh o mesmo selecionado