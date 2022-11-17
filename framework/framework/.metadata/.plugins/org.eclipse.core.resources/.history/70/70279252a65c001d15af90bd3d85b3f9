package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement Chktitle;

	@FindBy (id="first-name")
	WebElement firstName;
	
	@FindBy (id="postal-code")
	WebElement postalCode;

	@FindBy (id="last-name")
	WebElement lastName;
	
	@FindBy (id="continue")
	WebElement btncontinue;
	
	public void firstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		lastName.sendKeys(lname);
	}

	public void zipCode(String zipcode)
	{
		postalCode.sendKeys(zipcode);
	}
	
	public void btncontinue()
	{
		btncontinue.click();
	}
	

}
