package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	public WebDriver driver;
	
	By increaseQuantity = By.cssSelector(".cv-link.form-number-plus");
	By addToCart 		= By.className("cv-add-to-cart");
	By cartDetails		= By.cssSelector(".cv-ico-general-cart");
	By successMessage	= By.cssSelector(".notification-message");
	By checkoutButton	= By.cssSelector(".cv-checkout");
	
	
	
	
	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}


	public WebElement getIncreaseQuantity()
	{
		
		return driver.findElement(increaseQuantity);
	}
	
	public WebElement getaddToCart()
	{
		
		return driver.findElement(addToCart);
	}
	
	public WebElement getSuccessMeggase()
	{
		return driver.findElement(successMessage);
	}
	
	public WebElement getCartDeatils()
	{
		
		return driver.findElement(cartDetails);
	}
	
	public WebElement getCheckoutButton()
	{
		return driver.findElement(checkoutButton);
	}
	


}
