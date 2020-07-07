package br.com.guilhermeevangelista.appium.test.steps;

import br.com.guilhermeevangelista.appium.test.page.AlertPage;
import br.com.guilhermeevangelista.appium.test.page.MenuPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.net.MalformedURLException;

public class AlertSteps {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Dado("que acesso o menu aerta")
    public void queAcessoOMenuAerta() {
        menuPage.acessarAlerta();
    }

    @Quando("confirmo o alerta de confirmacao")
    public void confirmoOAlertaDeConfirmacao() throws MalformedURLException {
        alertPage.clicarAlertaConfirm();

        Assert.assertEquals("Confirma a operação?", alertPage.getMensagemoAlert());
        Assert.assertEquals("Info", alertPage.getTituloAlert());

        alertPage.clicarBotaoConfirmar();

        Assert.assertEquals("Confirmado", alertPage.getMensagemoAlert());
        alertPage.clicarBotaoSair();
    }


    @Quando("seleciono o alerta simples e clico fora dele")
    public void selecionoOAlertaSimplesEClicoForaDele() throws MalformedURLException {
        alertPage.clicarAlertaSimples();
        alertPage.clicarForaDoAlert();
    }

    @Então("valido que voltei pra tela de alertas")
    public void validoQueVolteiPraTelaDeAlertas() throws MalformedURLException {
        Assert.assertTrue(alertPage.estouNoMenu());
    }
}
