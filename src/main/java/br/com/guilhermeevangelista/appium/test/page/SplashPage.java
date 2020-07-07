package br.com.guilhermeevangelista.appium.test.page;

import br.com.guilhermeevangelista.appium.core.driver.BasePage;

import java.net.MalformedURLException;

public class SplashPage extends BasePage {


    public boolean verificarSplashNaTela() throws MalformedURLException {
        return super.existeElementoPorTexto("Splash!");
    }

    public void aguardarSplashSumir() throws MalformedURLException {
        super.aguardarElementoSumir(super.obterElementoPorText("Splash!"));
    }

}
