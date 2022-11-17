package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChartPage{

	
WebDriver driver;
	
	public ChartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement title;
	
	@FindBy (id="continue-shopping")
	WebElement contShopping;
	
	@FindBy (id="checkout")
	WebElement checkout;
	
	
	public void contShopping()
	{
		contShopping.click();
	}
	
	public void checkout()
	{
		checkout.click();
	}
	public void title()
	{
		title.click();
	}
	
	
}
