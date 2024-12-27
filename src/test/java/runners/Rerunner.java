package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failedscenario.txt",
		glue= {"stepDefs"},
		monochrome=true)
		
public class Rerunner extends AbstractTestNGCucumberTests{
	

}
