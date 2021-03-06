package br.com.guilhermeevangelista.appium.test.page;

import br.com.guilhermeevangelista.appium.core.driver.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.net.MalformedURLException;

public class AlertPage extends BasePage {

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement tituloAlert;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement mensagemAlert;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRMAR']")
    private MobileElement btnConfirmar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEGAR']")
    private MobileElement btnNegar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SAIR']")
    private MobileElement btnSair;

    public void clicarAlertaSimples() throws MalformedURLException {
        super.clicarElementoPorTexto("ALERTA SIMPLES");
    }

    public void clicarAlertaConfirm() throws MalformedURLException {
        super.clicarElementoPorTexto("ALERTA CONFIRM");
    }

    public void clicarForaDoAlert() throws MalformedURLException {
        esperar(1);
        super.tap(100, 150);
    }

    public String getTituloAlert(){
        return super.getText(tituloAlert);
    }

    public String getMensagemoAlert(){
        return super.getText(mensagemAlert);
    }

    public void clicarBotaoSair(){
        tirarPrint();
        super.clicarElemento(btnSair);
    }

    public void clicarBotaoConfirmar(){
        tirarPrint();
        super.clicarElemento(btnConfirmar);
    }

    public void clicarBotaoNegar(){
        tirarPrint();
        super.clicarElemento(btnNegar);
    }

    public boolean estouNoMenu() throws MalformedURLException {
        return super.existeElementoPorTexto("ALERTA CONFIRM");
    }


}
