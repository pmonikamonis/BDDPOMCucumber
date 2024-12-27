package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src//test//resources//feature//UserLogin.feature",
		glue= {"stepDefs"},
		monochrome=true,
		plugin= {"pretty",
				"html:target/reports/HTMLReport.html",
				 "rerun:target/failedscenario.txt"
		}
//				"usage:target/reports/UsageReport",
//				"json:target/reports/JSONReport.json",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class GooglePageRunner extends AbstractTestNGCucumberTests {
 
}
