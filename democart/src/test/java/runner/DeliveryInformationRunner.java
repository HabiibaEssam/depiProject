package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/DeliveryInformation.feature",
        glue = {"StepDefinitons"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/deliveryInformation.html",
                "json:target/cucumber-reports/deliveryInformation.json"
        },
        monochrome = true
)
public class DeliveryInformationRunner extends AbstractTestNGCucumberTests {
}
