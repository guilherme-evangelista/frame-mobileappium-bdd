package br.com.guilhermeevangelista.appium.steps;

import br.com.guilhermeevangelista.appium.page.MenuPage;
import br.com.guilhermeevangelista.appium.page.SplashPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

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
    public void aTelaDeSplashSumir() {
        Assert.assertTrue(splashPage.verificarSplashNaTela());
        tirarPrint();
        splashPage.aguardarSplashSumir();
    }
}
