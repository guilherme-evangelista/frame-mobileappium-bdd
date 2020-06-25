package br.com.guilhermeevangelista.appium.core.utils.report.screenshot;

import br.com.guilhermeevangelista.appium.core.utils.report.screenshot.impl.RunScreenshot;
import br.com.guilhermeevangelista.appium.core.utils.report.screenshot.impl.UntilScreenShot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Screenshot {
	public static byte[] take(AndroidDriver<MobileElement> androidDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotMobile(androidDriver));
	}
}
