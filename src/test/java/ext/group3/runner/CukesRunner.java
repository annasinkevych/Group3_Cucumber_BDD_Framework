package ext.group3.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "ext/group3/step_definitions",
        dryRun = false,
        tags = "@docuportLeadsVerify",
        monochrome = false,
        publish = false
)

public class CukesRunner {
}