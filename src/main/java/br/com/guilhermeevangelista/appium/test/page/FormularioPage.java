package br.com.guilhermeevangelista.appium.test.page;

import br.com.guilhermeevangelista.appium.core.driver.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;

import java.net.MalformedURLException;

public class FormularioPage extends BasePage {
    @AndroidFindBy(accessibility = "nome")
    private MobileElement cmpNome;

    @AndroidFindBy(xpath = "//android.widget.Spinner/android.widget.TextView")
    private MobileElement txtTextoSelectBox;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='switch']")
    private MobileElement btnSwitch;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='check']")
    private MobileElement btnCheck;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Nome:')]")
    private MobileElement nomeCadastrado;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Console:')]")
    private MobileElement consoleCadastrado;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Slider:')]")
    private MobileElement seekCadastrado;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Switch:')]")
    private MobileElement switchCadastrado;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Checkbox:')]")
    private MobileElement checkboxCadastrado;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Previous month']")
    private MobileElement voltarMes;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Next month']")
    private MobileElement avancarMes;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2000' and @index='2']")
    private MobileElement ano2000;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc='slid']")
    private MobileElement seekBar;



    public void clicarSalvar() throws MalformedURLException {
        tirarPrint();
        super.clicarElementoPorTexto("SALVAR");
    }

    public void selecionarCheck(){
        super.clicarElemento(btnCheck);
    }
    public void selecionarSwitch(){
        super.clicarElemento(btnSwitch);
    }

    public void selecionarConsole(String console) throws MalformedURLException {
        super.selecionarComboBox("console", console);
    }

    public void escreverCampoNome(String nome){
        super.escreverElemento(cmpNome, nome);
        tirarPrint();
    }

    public boolean isSwitchChecked(){
        return super.isChecked(btnSwitch);
    }
    public boolean isCheckChecked(){
        return super.isChecked(btnCheck);
    }

    public String getTextoCampoNome(){
        return super.getText(cmpNome);
    }
    public String getTextoSelectBox(){
        return super.getText(txtTextoSelectBox);
    }

    public String getNomeCadastrado(){
        return super.getText(nomeCadastrado);
    }
    public String getConsoleCadastrado(){
        return super.getText(consoleCadastrado);
    }
    public String getCheckBoxCadastrado(){
        return super.getText(checkboxCadastrado);
    }
    public String getSwitchCadastrado(){
        tirarPrint();
        return super.getText(switchCadastrado);
    }

    public String getSliderCadastrado(){
        tirarPrint();
        return super.getText(seekCadastrado);
    }

    public void clicarNoCampoDeData() throws MalformedURLException {
        super.clicarElementoPorTexto("01/01/2000");
    }

    public void selecionarAno(int ano) throws MalformedURLException {
        super.clicarElementoPorTexto("2000");
        if (ano == 2000) {
            super.clicarElemento(ano2000);
        } else {
            clicarElementoPorTexto(String.valueOf(ano));
        }
    }

    public void selecionarMes(int mes){
        if (mes>=1 && mes<=12){
            if (mes<2) super.clicarElemento(voltarMes);
            else if(mes>2) super.clicarElemento(avancarMes, mes - 2);
        }
        else throw new IllegalArgumentException("Valor de mês invalido, selecionar entre 1 e 12");
    }

    public void selecionarDia(int dia) throws MalformedURLException {
        if (dia>=1 && dia<=31){
            super.clicarElementoPorTexto(String.valueOf(dia));
        }
        else throw new IllegalArgumentException("Valor de dia invalido, selecionar entre 1 e 31");
        tirarPrint();
    }

    public void clicarSalvarDemorado() throws MalformedURLException {
        tirarPrint();
        super.clicarElementoPorTexto("SALVAR DEMORADO");
    }

    public void clicarNoBotaoOk() throws MalformedURLException {
        super.clicarElementoPorTexto("OK");
    }

    public boolean verificarPresencaDeElementoPorText(String texto) throws MalformedURLException {
        return existeElementoPorTexto(texto);
    }

    public void moverSeekBar(double porcentagem) throws MalformedURLException {
        int delta = 40;
        Assert.assertTrue(porcentagem >= 0 && porcentagem <= 100);
        int xInicial = seekBar.getLocation().x + delta;
        int y = seekBar.getLocation().y + (seekBar.getSize().height/2);
        int x = (int) (xInicial + ((seekBar.getSize().width - 2 * delta) * (porcentagem/2)));
        super.tap(x, y);
        esperar(2);
    }
}
