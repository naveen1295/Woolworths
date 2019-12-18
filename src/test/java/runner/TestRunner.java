package runner;

import org.junit.After;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions" }, tags = { "" }, plugin = {
		"pretty", "json:target/cucumber-reports/Cucumber.json",
		"html:target/cucumber-reports" }, monochrome = false, dryRun = false, strict = false)
public class TestRunner {
	@After
	public static void writeCucumberHtmlReport() {

	}
}