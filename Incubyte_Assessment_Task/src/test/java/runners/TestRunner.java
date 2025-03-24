package test.java.runners;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to feature files
    glue = "stepDefinitions", // Package where step definitions are located
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", // Generates HTML report
        "json:target/cucumber.json", // Generates JSON report
        "junit:target/cucumber.xml" // Generates JUnit XML report
    },
    monochrome = true, // Improves console output readability
    dryRun = false // Set to true to check if step definitions are missing
)
public class TestRunner {
}
