package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankLoginScenario {
	
public WebDriver driver;

	@Given("user is navigating to the bank url")
	public void user_is_navigating_to_the_bank_url() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriverr\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		System.out.println("Bank home page is launched successfully");
	}

	@When("username and password are entered")
	public void username_and_password_are_intered() {
	   driver.findElement(By.name("username")).sendKeys("nxtgendemo");
	   driver.findElement(By.name("password")).sendKeys("nxtgendemo");
		 System.out.println("Valid user name and password entered");
	}

	@And("click on login button")
	public void click_on_login_button() {
	  driver.findElement(By.xpath("//input[@class='button']")).click();
		 System.out.println("Click on login button");
	}
	
	
	@Then("display the user home page")
	public void display_the_user_home_page() {
	 boolean status=driver.findElement(By.partialLinkText("New Account")).isDisplayed();
	if (status) {
		 System.out.println("User home page is displayed");
	}	 
	 

	}

	@And("close the application")
	public void close_the_application() {
	    driver.close();
	    System.out.println("Application is closed");
	}

	@When("invalid username and password are entered")
	public void invalid_username_and_password_are_entered() {
		 driver.findElement(By.name("username")).sendKeys("nxtgendemosssd");
		   driver.findElement(By.name("password")).sendKeys("");
		 System.out.println("Invalid login and password intered");
	}
	
	@Then("unable to login")
	public void unable_to_login() {
	   WebElement errorMsg=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
		 System.out.println("Unable to login.Error Message is "+errorMsg.getText());
	}
	
}
