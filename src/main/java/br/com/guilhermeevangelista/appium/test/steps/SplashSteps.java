package br.com.guilhermeevangelista.appium.test.steps;

import br.com.guilhermeevangelista.appium.test.page.MenuPage;
import br.com.guilhermeevangelista.appium.test.page.SplashPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.net.MalformedURLException;

import static br.com.guilhermeevangelista.appium.core.driver.BasePage.tirarPrint;

public class SplashSteps {

    private final MenuPage menuPage = new MenuPage();
    private final SplashPage splashPage = new SplashPage();

    @Dado("que acesso o menu splash")
    public void queAcessoOMenuSplash() {
        tirarPrint();
        menuPage.acessarSplash();
    }

    @Quando("a tela de splash sumir")
    public void aTelaDeSplashSumir() throws MalformedURLException {
        Assert.assertTrue(splashPage.verificarSplashNaTela());
        tirarPrint();
        splashPage.aguardarSplashSumir();
    }
}
