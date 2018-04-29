package stepDefinition;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	
	public static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreedevi Pratap\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.store.demoqa.com");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}

	/*@When("^User enters Credentials to LogIn \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_enters_Credentials_to_LogIn(String uname, String pwd) throws Throwable {
		driver.findElement(By.id("log")).sendKeys(uname); 
		 
		//This is to get the first data of the set (First Row + Second Column)
	    driver.findElement(By.id("pwd")).sendKeys(pwd);
 
	    driver.findElement(By.id("login")).click();
	}*/
	@When("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(List<Credentials> usercredentials) throws Throwable {
		//Write the code to handle Data Table
		//Credentials credentials = new Credentials();
				//List<List<String>> data = usercredentials.raw();
		 for( Credentials credentials : usercredentials) {
				//This is to get the first data of the set (First Row + First Column)
				driver.findElement(By.id("log")).sendKeys(credentials.getUsername()); 
				Thread.sleep(3000);
				//This is to get the first data of the set (First Row + Second Column)
			    driver.findElement(By.id("pwd")).sendKeys(credentials.getPassword());
			    Thread.sleep(3000);
			    driver.findElement(By.id("login")).click();
			    Thread.sleep(3000);
		 }
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}
 
	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}

}
