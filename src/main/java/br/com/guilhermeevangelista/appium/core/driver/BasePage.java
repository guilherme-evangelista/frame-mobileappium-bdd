package br.com.guilhermeevangelista.appium.core.driver;

import br.com.guilhermeevangelista.appium.core.utils.report.screenshot.ScenarioRepository;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.guilhermeevangelista.appium.core.driver.DriverFactory.getDriver;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public static void tirarPrint(){
        ScenarioRepository.screenShot();
    }

    private void clicarElemento(By by){
        getDriver().findElement(by).click();
    }

    protected void clicarElemento(MobileElement mobileElement){
        mobileElement.click();
    }

    protected void clicarElemento(MobileElement mobileElement, int vezes){
        for (int i = 0; i < vezes; i++) {
            mobileElement.click();
            esperar(1/2);
        }
    }

    protected void clicarElementoPorTexto(String text){
        clicarElemento(By.xpath("//*[@text='"+text+"']"));
    }

    protected void tap(int x, int y){
        esperar(1);
        TouchAction touchAction = new TouchAction(DriverFactory.getDriver());
        touchAction.press(new PointOption().withCoordinates(x, y)).perform();
    }

    protected boolean existeElementoPorTexto(String texto){
        return getDriver().findElements(By.xpath("//*[@text='"+texto+"']")).size() > 0;
    }

    protected boolean existeElementoNaTela(MobileElement mobileElement){
        return mobileElement.isDisplayed();
    }

    protected MobileElement obterElementoPorText(String texto){
        return getDriver().findElement(By.xpath("//*[@text='"+texto+"']"));
    }

    protected void escreverElemento(MobileElement mobileElement, String valor){
        mobileElement.sendKeys(valor);
    }

    protected String getText(MobileElement mobileElement){
        return mobileElement.getText();
    }

    protected boolean isChecked(MobileElement mobileElement){
        return mobileElement.getAttribute("checked").equals("true");
    }

    protected void selecionarComboBox(String nome, String opcao){
        this.clicarElemento(By.xpath("//android.widget.Spinner[@content-desc='"+nome+"']"));
        this.clicarElemento(By.xpath("//android.widget.CheckedTextView[@text='"+opcao+"']"));
    }

    protected void aguardarElementoSumir(MobileElement mobileElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(mobileElement));
    }

    protected void esperar(long sec){
        try {
            Thread.sleep(sec *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
