package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage {

	WebDriver driver;
	
	public ThankyouPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//*[@id=\"checkout_complete_container\"]/h2")
	WebElement thankyouMsg;
	
	@FindBy (xpath="//*[@id=\"checkout_complete_container\"]/div")
	WebElement orderMsg;

}
