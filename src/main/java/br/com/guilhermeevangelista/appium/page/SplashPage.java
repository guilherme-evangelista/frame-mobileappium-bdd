package br.com.guilhermeevangelista.appium.page;

import br.com.guilhermeevangelista.appium.core.BasePage;

public class SplashPage extends BasePage {


    public boolean verificarSplashNaTela(){
        return super.existeElementoPorTexto("Splash!");
    }

    public void aguardarSplashSumir(){
        super.aguardarElementoSumir(super.obterElementoPorText("Splash!"));
    }

}
