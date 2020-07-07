package br.com.guilhermeevangelista.appium.core.driver;

import br.com.guilhermeevangelista.appium.core.utils.report.screenshot.ScenarioRepository;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import static br.com.guilhermeevangelista.appium.core.driver.DriverFactory.getDriver;

public class BasePage {

    public static void tirarPrint(){
        ScenarioRepository.screenShot();
    }

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    private void clicarElemento(By by){
        getDriver().findElement(by).click();
    }

    public Boolean isElementoPresente(MobileElement mobileElement){
        return mobileElement.isDisplayed();
    }

    public void esconderTeclado(){
        getDriver().hideKeyboard();
    }

    protected void clicarElemento(MobileElement mobileElement){
        mobileElement.click();
    }

    public void back(){
        getDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));
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

    protected void tap(double x, double y){
        JavascriptExecutor js = getDriver();
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("X", x);
        tapObject.put("Y", y);
        js.executeScript("mobile:tap", tapObject);
    }

    public String getTextoAlerta() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public boolean isAlertaPresente() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert();
        return true;
    }

    public void aceitarAlerta() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }

    public void recusarAlerta() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().dismiss();
    }

    protected boolean existeElementoPorTexto(String texto){
        return getDriver().findElements(By.xpath("//*[@text='"+texto+"']")).size() > 0;
    }

    protected boolean existeElementoNaTela(MobileElement mobileElement){
        return mobileElement.isDisplayed();
    }

    protected MobileElement obterElementoPorText(String texto) throws MalformedURLException {
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

    public void clicarDemorado(MobileElement mobileElement) {
        TouchAction touch = new TouchAction<>(getDriver());
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withElement(ElementOption.element(mobileElement));
        touch.longPress(longPressOptions).release().perform();
    }

    public void clicarDemorado(int x, int y) {
        TouchAction touch = new TouchAction<>(getDriver());
        PointOption pointOption = new PointOption<>();
        pointOption.withCoordinates(x, y);
        touch.longPress(pointOption).release().perform();
    }

    public void swipe(double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = getDriver();
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void scrollDown(int swipeTimes, int durationForSwipe) {
        Dimension dimension = getDriver().manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.5);
            int end = (int) (dimension.getHeight() * 0.3);
            int x = (int) (dimension.getWidth() * .5);


            new TouchAction(getDriver()).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    public void scrollUp(int swipeTimes, int durationForSwipe) {
        Dimension dimension = getDriver().manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.3);
            int end = (int) (dimension.getHeight() * 0.5);
            int x = (int) (dimension.getWidth() * .5);


            new TouchAction(getDriver()).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    protected void selecionarComboBox(String nome, String opcao) throws MalformedURLException {
        this.clicarElemento(By.xpath("//android.widget.Spinner[@content-desc='"+nome+"']"));
        this.clicarElemento(By.xpath("//android.widget.CheckedTextView[@text='"+opcao+"']"));
    }

    protected void aguardarElementoSumir(MobileElement mobileElement) throws MalformedURLException {
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

    public void setNetworkConnection(boolean wifi, boolean data) {
        long mode = 1L;
        if (wifi) { mode = 2L; } else if (data) { mode = 4L; }
        ConnectionState connectionState = new ConnectionState(mode);
        getDriver().setConnection(connectionState);
        System.out.println("Your current connection settings are :" + getDriver().getConnection());
    }

}
