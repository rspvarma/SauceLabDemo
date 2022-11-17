package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement username()
	{
		WebElement username=driver.findElement(By.id("user-name"));
		return username;
	}
	
	public WebElement password()
	{
		WebElement password=driver.findElement(By.id("password"));
		return password;
	}

	public WebElement login()
	{
		WebElement loginbtn=driver.findElement(By.id("login-button"));
		return loginbtn;
	}


}
