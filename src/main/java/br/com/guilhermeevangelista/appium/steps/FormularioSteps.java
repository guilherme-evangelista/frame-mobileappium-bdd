package br.com.guilhermeevangelista.appium.steps;

import br.com.guilhermeevangelista.appium.page.FormularioPage;
import br.com.guilhermeevangelista.appium.page.MenuPage;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static br.com.guilhermeevangelista.appium.core.BasePage.tirarPrint;

public class FormularioSteps{

    private final MenuPage menuPage = new MenuPage();
    private final FormularioPage formularioPage = new FormularioPage();

    private static String nome;
    private static String data;

    @Dado("que acesso o menu formulario")
    public void queAcessoOMenuFormulario() {
        menuPage.acessarFormulario();
    }

    @Quando("preencho o campo nome com {string}")
    public void ePreenchoOCampoNomeCom(String text) {
        nome = text;
        formularioPage.escreverCampoNome(nome);
    }

    @Então("valido que o campo foi preenchido")
    public void validoQueOCampoFoiPreenchido() {
        tirarPrint();
        Assertions.assertEquals(nome, formularioPage.getTextoCampoNome());
    }

    @Quando("preencho os todos os campos e salvo")
    public void preenchoOsTodosOsCamposESalvo() {
        formularioPage.escreverCampoNome("Guilherme Gomes");

        formularioPage.selecionarConsole("Nintendo Switch");

        formularioPage.selecionarCheck();
        formularioPage.selecionarSwitch();

        formularioPage.clicarSalvar();
    }

    @Quando("preencho os todos os campos e salvo demorado")
    public void preenchoOsTodosOsCamposESalvoDemorado() {
        formularioPage.escreverCampoNome("Guilherme Gomes");

        formularioPage.selecionarConsole("Nintendo Switch");

        formularioPage.selecionarCheck();
        formularioPage.selecionarSwitch();

        formularioPage.clicarSalvarDemorado();
    }

    @Quando("escolho a data {string}{string}{string}")
    public void escolhoAData(String dia, String mes, String ano) {
        data = Integer.valueOf(dia)+"/"+Integer.valueOf(mes)+"/"+ano;
        formularioPage.clicarNoCampoDeData();
        formularioPage.selecionarAno(Integer.parseInt(ano));
        formularioPage.selecionarMes(Integer.parseInt(mes));
        formularioPage.selecionarDia(Integer.parseInt(dia));
        formularioPage.clicarNoBotaoOk();
    }

    @Então("valido que os campos salvos correnpondem aos inseridos")
    public void validoQueOsCamposSalvosCorrenpondemAosInseridos() {
        Assertions.assertEquals("Nome: Guilherme Gomes", formularioPage.getNomeCadastrado());
        Assertions.assertEquals("Console: switch", formularioPage.getConsoleCadastrado());
        Assertions.assertTrue(formularioPage.getCheckBoxCadastrado().endsWith("Marcado"));
        Assertions.assertTrue(formularioPage.getSwitchCadastrado().endsWith("Off"));
    }

    @Então("valido que o menu do formulario esta sendo exibido")
    public void validoQueOMenuDoFormularioEstaSendoExibido() {
        Assertions.assertTrue(menuPage.isFormularioVisivel());
        tirarPrint();
    }

    @Entao("valido que a data selecionada no formulario esta sendo exibida")
    public void validoQueADataSelecionadaNoFormularioEstaSendoExibida() {
        Assert.assertTrue(formularioPage.verificarPresencaDeElementoPorText(data));
        tirarPrint();
    }

    @E("escolho a hora {int}:{int}")
    public void escolhoAHora(int hora, int minutos) {
        
    }
}
