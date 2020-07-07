package br.com.guilhermeevangelista.appium.runner;

import br.com.guilhermeevangelista.appium.core.utils.report.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/guilhermeevangelista/appium/test/steps", "br/com/guilhermeevangelista/appium/core/hooks"},
        tags = {"@regressivo"})

public class RunTest {

    @AfterClass
    public static void gerarRelatorio() {
        Report.gerarRelarotioClueCumber();
    }

}
