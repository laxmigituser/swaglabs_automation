package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//features/complete_flow.feature",
		glue = "StepDefs",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:reports/report.html"}
		)
public class Runner {

}
