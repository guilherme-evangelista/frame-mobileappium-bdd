package br.com.guilhermeevangelista.appium.core.screenshot.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

public class ScrrenshotUtils {
	private final static String JS_HIGHLITH = "arguments[%d].setAttribute('style', 'border: 4px solid green!important');arguments[%d].focus();arguments[%d].scrollIntoView(true);";
	private final static String JS_UNDO = "arguments[%d].setAttribute('style', '%2$s');";
	
	public static byte[] screenshot(AndroidDriver<MobileElement> androidDriver) {
		return ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static Object executeJavaScript(AndroidDriver<MobileElement> androidDriver, String javaScript, MobileElement... mobileElements)  {
		JavascriptExecutor jse = ((JavascriptExecutor) androidDriver);
		return jse.executeScript(javaScript, (Object[]) mobileElements);
	}
	
	public static String getJavaScriptHighlight(AndroidDriver<MobileElement> androidDriver, MobileElement... mobileElements) {
		StringBuilder js = new StringBuilder();
		for (int i = 0; i < mobileElements.length; i++) {
			if (mobileElements[i].getText() != null)
				js.append(String.format(JS_HIGHLITH, i, i, i));
		}
		return js.toString();
	}

	public static String getJavaScriptUnHighlight(AndroidDriver<MobileElement> androidDriver, MobileElement... mobileElements) {
		StringBuilder js = new StringBuilder();

		for (int i = 0; i < mobileElements.length; i++) {
			if (mobileElements.toString() != null)
				js.append(String.format(JS_UNDO, i, mobileElements[i].getAttribute("style")));
		}
		return js.toString();
	}
}
