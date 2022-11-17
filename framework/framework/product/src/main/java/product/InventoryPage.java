package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	WebDriver driver;
	
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (id="add-to-cart-sauce-labs-backpack")
	WebElement backPack;
	
	@FindBy (id="add-to-cart-sauce-labs-bike-light")
	WebElement bikeLight;
	
	@FindBy (id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement bolt_Tshirt;
	
	@FindBy (id="add-to-cart-sauce-labs-onesie")
	WebElement onesie;
	
	@FindBy (id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement allthings_Tshirt;
	
	@FindBy (xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement chartLink;

	public void backPack()
	{
		backPack.click();
	}
	
	public void bikeLight()
	{
		bikeLight.click();
	}

	
	public void bolt_Tshirt()
	{
		bolt_Tshirt.click();
	}

	public void onesie()
	{
		onesie.click();
	}

	public void allthings_Tshirt()
	{
		allthings_Tshirt.click();
	}

	public void gotoChart()
	{
		chartLink.click();
	}
	
	
	
  


}
