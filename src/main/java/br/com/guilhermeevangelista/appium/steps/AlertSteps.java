package br.com.guilhermeevangelista.appium.steps;

import br.com.guilhermeevangelista.appium.page.AlertPage;
import br.com.guilhermeevangelista.appium.page.MenuPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class AlertSteps {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Dado("que acesso o menu aerta")
    public void queAcessoOMenuAerta() {
        menuPage.acessarAlerta();
    }

    @Quando("confirmo o alerta de confirmacao")
    public void confirmoOAlertaDeConfirmacao() {
        alertPage.clicarAlertaConfirm();

        Assert.assertEquals("Confirma a operação?", alertPage.getMensagemoAlert());
        Assert.assertEquals("Info", alertPage.getTituloAlert());

        alertPage.clicarBotaoConfirmar();

        Assert.assertEquals("Confirmado", alertPage.getMensagemoAlert());
        alertPage.clicarBotaoSair();
    }


    @Quando("seleciono o alerta simples e clico fora dele")
    public void selecionoOAlertaSimplesEClicoForaDele() {
        alertPage.clicarAlertaSimples();
        alertPage.clicarForaDoAlert();
    }

    @Então("valido que voltei pra tela de alertas")
    public void validoQueVolteiPraTelaDeAlertas() {
        Assert.assertTrue(alertPage.estouNoMenu());
    }
}
