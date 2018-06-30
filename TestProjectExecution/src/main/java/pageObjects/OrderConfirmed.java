package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmed {
	
	public WebDriver driver;
	
	By confirmation = By.cssSelector(".alert-box.success");
	
	
	public OrderConfirmed(WebDriver driver) {

		this.driver = driver;
	}



	public WebElement getOrderConfirmation()
	{
		return driver.findElement(confirmation);
	}
	

}
