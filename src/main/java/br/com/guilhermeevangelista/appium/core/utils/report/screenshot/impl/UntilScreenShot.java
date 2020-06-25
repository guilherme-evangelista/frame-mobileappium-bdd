package br.com.guilhermeevangelista.appium.core.utils.report.screenshot.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UntilScreenShot {
	public static IScreenshot<byte[]> screenShotMobile(final AndroidDriver<MobileElement> androidDriver) {
		return input -> ScrrenshotUtils.screenshot(androidDriver);
	}
}
