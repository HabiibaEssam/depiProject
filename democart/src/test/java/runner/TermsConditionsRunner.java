package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/TermsandCondtions.feature",
        glue = {"StepDefinitons"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/termsConditions.html",
                "json:target/cucumber-reports/termsConditions.json"
        },
        monochrome = true
)

public class TermsConditionsRunner extends AbstractTestNGCucumberTests {
}
