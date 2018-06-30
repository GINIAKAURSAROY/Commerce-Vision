package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	public WebDriver driver;
	
	By messageAccept = By.xpath("//button[contains(@data-bind,'areAllCheckoutMessagesConfirmed')]");
	By checkoutSubmitButton = By.cssSelector(".checkout-progress[data-bind*='submitOrder']");
	
	
	
	
	
	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
	}


	public WebElement getAcceptMessageButton()
	{
		
		return driver.findElement(messageAccept);
	}
	
	public WebElement getCheckoutSubmitButton()
	{
		return driver.findElement(checkoutSubmitButton);
	}
	
	

	

}
