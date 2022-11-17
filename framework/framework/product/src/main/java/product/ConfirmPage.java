package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {

	WebDriver driver;
	
	public ConfirmPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (id="finish")
	WebElement Btn_finish;

	
	public void finish()
	{
		Btn_finish.click();
	}
	
}
