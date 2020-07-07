package br.com.guilhermeevangelista.appium.test.page;

import br.com.guilhermeevangelista.appium.core.driver.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.net.MalformedURLException;

public class MenuPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
    private MobileElement mnFormulario;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Nativo']")
    private MobileElement mnSeuBarrigaNativo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Híbrido']")
    private MobileElement mnSeuBarrigaHibrido;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Alertas']")
    private MobileElement mnAlertas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash']")
    private MobileElement mnSplash;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Abas']")
    private MobileElement mnAbas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accordion']")
    private MobileElement mnAccordion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cliques']")
    private MobileElement mnCliques;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe']")
    private MobileElement mnSwipe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe List']")
    private MobileElement mnSwipeList;

    public void acessarFormulario(){
        super.clicarElemento(mnFormulario);
        tirarPrint();
    }

    public boolean isFormularioVisivel() throws MalformedURLException {
        return super.existeElementoPorTexto("Formulario");
    }

    public void acessarSeuBarrigaNativo(){
        super.clicarElemento(mnSeuBarrigaNativo);
    }

    public void acessarSeuBarrigaHibrido(){
        super.clicarElemento(mnSeuBarrigaNativo);
    }

    public void acessarSplash(){
        super.clicarElemento(mnSplash);
    }

    public void acessarAlerta(){
        super.clicarElemento(mnAlertas);
        tirarPrint();
    }
    
}
