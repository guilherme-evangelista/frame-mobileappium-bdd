package br.com.guilhermeevangelista.appium.runner;

import br.com.guilhermeevangelista.appium.core.utils.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"html:target/cucumber-report", "json:target/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/guilhermeevangelista/appium/steps", "br/com/guilhermeevangelista/appium/core/hooks"},
        tags = {"@alertSimples"})

public class RunTest {

    @AfterClass
    public static void gerarRelatorio() {
        Report.gerarRelatio();
    }

}
