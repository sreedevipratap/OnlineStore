package cucumberTest;
/* Testing if i am in test branch*/

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue = {"stepDefinition"})

public class TestRunner {

}
