package stepDefs;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStepDef {
	WebDriver driver;

@Given("User is on Login Page")
public void user_is_on_login_page() {
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://the-internet.herokuapp.com/login");
}
//@When("User enters Credentials")
//public void user_enters_credentials() {
//	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//	driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//	driver.findElement(By.cssSelector("button.radius")).click();
//	
//   
//}


//@When("User enters {string} and {string}")
//public void user_enters_and(String strname, String strpwd) {
//	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strname);
//	driver.findElement(By.name("password")).sendKeys(strpwd);
//	driver.findElement(By.cssSelector("button.radius")).click();
//}


//datatable as Lists
//@When("User enters credentials")
//public void user_enters_credentials(DataTable dataTable) {
//	List<List<String>> user= dataTable.asLists();
//    String strname = user.get(0).get(0);
//    String strpwd = user.get(0).get(1);
//    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strname);
//	driver.findElement(By.name("password")).sendKeys(strpwd);
//	driver.findElement(By.cssSelector("button.radius")).click();
    		
//}

//datatable as Map
@When("User enters credentials")
public void user_enters_credentials(DataTable dataTable) {
	List<Map<String, String>> user = dataTable.asMaps();
	//List<Map<String,String>> user= dataTable.asMaps();
    String strname = user.get(0).get("username");
    String strpwd = user.get(0).get("password");
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strname);
	driver.findElement(By.name("password")).sendKeys(strpwd);
	driver.findElement(By.cssSelector("button.radius")).click();
}
@Then("Should display home page")
public void should_display_home_page(DataTable dataTable) {
	List<List<String>> data= dataTable.asLists();
	String expectedMsg = data.get(0).get(0);
	WebElement msg = driver.findElement(By.cssSelector("div.success"));
	String actualMsg=msg.getText();
	Assert.assertEquals(actualMsg,expectedMsg);
}

}
