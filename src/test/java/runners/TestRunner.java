package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "html:target/cucumber-report.json"
        }
        ,tags = "@InvalidSearch"
        , monochrome = true



)
public class TestRunner extends AbstractTestNGCucumberTests {
}

