package br.com.guilhermeevangelista.appium.core.screenshot.impl;

import br.com.guilhermeevangelista.appium.core.screenshot.exceptions.ScreenshotException;
import com.google.common.base.Function;


public class RunScreenshot {

	public <V, T> V take(Function<? super T, V> isTrue) {
		try {
			return isTrue.apply(null);
		} catch (Exception e) {
			throw new ScreenshotException(e);
		}
	}
}
