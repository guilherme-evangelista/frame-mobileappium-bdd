package br.com.guilhermeevangelista.appium.core.hooks;

import br.com.guilhermeevangelista.appium.core.DriverFactory;
import br.com.guilhermeevangelista.appium.core.screenshot.ScenarioRepository;
import br.com.guilhermeevangelista.appium.core.utils.AppiumServerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterEach;

public class Hooks {

    @AfterEach
    public void resetApp() {
        DriverFactory.getDriver().resetApp();
    }

    @Before
    public void initializeTest(Scenario scenario) {
        AppiumServerUtils.startServer();
        ScenarioRepository.add(scenario);
    }

    @After
    public static void driverClose(){
        DriverFactory.killDriver();
        ScenarioRepository.remove();
        AppiumServerUtils.stopServer();
    }

}
