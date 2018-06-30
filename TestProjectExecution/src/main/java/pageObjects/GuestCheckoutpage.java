package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestCheckoutpage {
	
	public WebDriver driver;
	By guestCheckout = By.id("guest-checkout-toggle");
	By deliveryButton = By.cssSelector("#delivery-mode-delivery[name = 'delivery-mode'][data-bind*='checked']");
	By customerRef = By.cssSelector("input[name='orderReference']");
	By email = By.name("DeliveryEmailAddress");
	By contactName = By.name("SoBillAddr1");
	By phoneNumber = By.cssSelector("[placeholder='Phone Number'][name='SoBillAddr4']");
	By address = By.name("SoBillAddr2");
	By suburb = By.name("SoBillSuburb");
	
	By delInstructions = By.cssSelector("textarea[placeholder*='Delivery']");
	By orderComment = By.xpath("//textarea[contains(@placeholder,'Order')]");
	
	By cardNumber = By.cssSelector("[placeholder*=Credit]");
	By expiryMonthYear = By.xpath("//span[@class = 'k-input']");
	By cvv = By.name("EWAY_CARDCVN");
	By cardName = By.cssSelector("[name='EWAY_CARDNAME']");
	
	By processPayment = By.cssSelector("div.payment-credit-card div:last-child > div > div > button");
	
	
	public GuestCheckoutpage(WebDriver driver) {

		this.driver = driver;
	}


	public WebElement getGuestCheckout()
	{
		
		return driver.findElement(guestCheckout);
	}
	
	public WebElement getDeliveryButton()
	{
		
		return driver.findElement(deliveryButton);
	}
	public WebElement getCustomerRef()
	{
		
		return driver.findElement(customerRef);
	}
	public WebElement getEmail()
	{
		
		return driver.findElement(email);
	}
	public WebElement getContactName()
	{
		
		return driver.findElement(contactName);
	}
	public WebElement getphoneNumber()
	{
		
		return driver.findElement(phoneNumber);
	}
	public WebElement getAddress()
	{
		
		return driver.findElement(address);
	}
	public WebElement getSuburb()
	{
		
		return driver.findElement(suburb);
	}
	
	public WebElement getDelInstruction()
	{
		
		return driver.findElement(delInstructions);
	}
	public WebElement getOrderComment()
	{
		
		return driver.findElement(orderComment);
	}
	
	public WebElement getCardNumber()
	{
		
		return driver.findElement(cardNumber);
	}
	
	public List<WebElement> getExpiryMonthYear()
	{
		
		return driver.findElements(expiryMonthYear);
	}
	
	public WebElement getCvv()
	{
		
		return driver.findElement(cvv);
	}
	
	public WebElement getCardName()
	{
		
		return driver.findElement(cardName);
	}
	
	public WebElement getProcessPaymentButton()
	{
		
		return driver.findElement(processPayment);
	}
	

}
