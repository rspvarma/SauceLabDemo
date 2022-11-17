package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (id="user-name")
	WebElement username;
	
	@FindBy (id="password")
	WebElement password;
	
	@FindBy (id="login-button")
	WebElement loginbtn;
	
	// Error Objects
	@FindBy (xpath="//*[@id='login_button_container']/div/form/div[3]/h3")
	WebElement errorObj;
	
	

	
	public String errmsg()
	{
	   String msg=errorObj.getText();
			   return msg;
	}
	
	
	
	public void uname(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void login()
	{
	   loginbtn.click();
	}
	
	

}
