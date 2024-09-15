package ext.group3.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
    created a new directory under resources named features

    right click on features -->copy path reference-->path from content root --> paste above to cucumber options
    repeat for glue - step_definitions
    add LoginFeature.feature to features
    add Hooks to step_definitions
    add class LoginStepDefs to step_definitions

    cucumber runner takes this tag smoke and goes to login defs class to find where the code is

    cucumber helps us to generate code snippets for us

    set dryRun to true - to generate code sniopet for LoginStepDefs doesn't run the code just checks if any steps are missing from step definitions



    DryRun - turns on and off the running of step definitions
            set to true - code inside the snippet does not run
              if we don't want to actually run my codem and just want to my snippets for implementing - set to true
 */
//
@RunWith(Cucumber.class) //run the class as Cucumber BDD tests
@CucumberOptions(
        plugin = {"pretty",
                "html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "ext/group3/step_definitions",
        dryRun = false,
        tags = "@docuportCreateNewClientAnna",
        monochrome = false,
        publish = false
)

public class CukesRunner {

}

/*
    In my framework i use cucumber java and cucumber junit dependencies and runner class from junit with cucumber options that links,  With the helps of runner class I show where my feature file and my step defs code is. The gliue helps connect. Cucumber junit has annotations.

    DryRun generates the snippets or just run code

    plugins help us take screenshots or generate reports

    all possible plugins for cucumber options in my cucumber junit framework


 */