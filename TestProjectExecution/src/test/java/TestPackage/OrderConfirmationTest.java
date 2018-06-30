package TestPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.Assert;

import pageObjects.CheckoutPage;
import pageObjects.GuestCheckoutpage;
import pageObjects.HomePage;
import pageObjects.OrderConfirmed;
import pageObjects.ProductPage;
import pageObjects.ProductSearch;
import resources.Base;

public class OrderConfirmationTest extends Base{
	
	public WebDriverWait wait,wait2 = null;
	public HomePage hm = null;
	ProductPage pp = null;
	ProductSearch ps =null;
	CheckoutPage cp = null;
	GuestCheckoutpage gc = null;
	OrderConfirmed oc = null;
	
	WebElement search,searchButton,increaseQuantity,product,addToCart
			   ,cartDetails,checkoutButton,checkoutSubmitButton,acceptMessage
			   ,guestCheckoutButton,deliveryRadioButton,suburb;
	Actions a = null;
	JavascriptExecutor js ;
	
	
  @BeforeTest
  /* This block of code will do initializations
   * enter the search=racquet (which is present in properties files
   * 
   * and will click on search button
   * All the elements used in this class are stored as part of pageObjects classes
   * which can be later used too*/
  public void basepage() throws IOException {
		 driver = iniatlizeDriver();
		 driver.get(properties.getProperty("url"));
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		js = (JavascriptExecutor) driver;
		 
		
		 wait = new WebDriverWait(driver, 6);
		 wait = new WebDriverWait(driver, 10);
	 
		 
		 
		 hm = new HomePage(driver);
		 search = hm.getSearchInputText();
		 a = new Actions(driver);
	 
		 a.moveToElement(search).click().sendKeys(searchText()).build().perform();	
	 
		 searchButton = hm.getSearchButton();
		 searchButton.click();
	 

  }
  
  @Test(priority=0)
  /*
   * This code get the selected product CV116 and will add the quantity
   * Add to cart*/
  public void addToCart()
  {
	  
		 ps = new ProductSearch(driver);
		 product = wait.until(ExpectedConditions.elementToBeClickable(ps.getSelectedProduct()));
		 product.click();
		 
		 pp = new ProductPage(driver);
		 increaseQuantity  = pp.getIncreaseQuantity();
		 increaseQuantity.click();
		 
		 addToCart = pp.getaddToCart();
		 addToCart.click();
		 wait.until(ExpectedConditions.visibilityOf(pp.getSuccessMeggase()));
  }
  
  @Test(priority=1)
  /*
   * This will hover to the add to cart bar
   * and click on checkout option*/
  public void proceedToCheckOut()
  {
	  
		 cartDetails  = pp.getCartDeatils();
		 a.moveToElement(cartDetails).click().build().perform();
		// if(wait.until(ExpectedConditions.elementToBeClickable(pp.getCheckoutButton())) != null)
		// pp.getCheckoutButton().click();
		 
		 

		 
  }
  
  @Test(priority=2)
  /*
   * This is checkout page
   * checkout button will be selected and the meassage will be accepted for checkout*/
  public void checkoutPage()
  {
	    cp = new CheckoutPage(driver);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(cp.getCheckoutSubmitButton())).click();

	    WebElement element = cp.getAcceptMessageButton();
	    wait.until(ExpectedConditions.elementToBeClickable
				(element)).click();

  }
  

  @Test(priority=3)
  /*
   * In this page we are entering all the value without hardcoding
   * guestcheckout is selected 
   * test details are used for this peice of code
   * Find all the keys in properties file*/
  public void guestCheckout() throws InterruptedException
  {
	    gc = new GuestCheckoutpage(driver);
	    if(wait.until(ExpectedConditions.visibilityOf(gc.getGuestCheckout())) != null)
	    	gc.getGuestCheckout().click();
	  	
	  	deliveryRadioButton = gc.getDeliveryButton();
	  	if(deliveryRadioButton.isSelected())
	  	{
	  		gc.getCustomerRef().sendKeys(properties.getProperty("customerref"));
	  		gc.getEmail().sendKeys(properties.getProperty("custemail"));
	  		gc.getContactName().sendKeys(properties.getProperty("contactname"));
	  		gc.getphoneNumber().sendKeys(properties.getProperty("phonenumber"));
	  		gc.getAddress().sendKeys(properties.getProperty("address"));
	  		suburb = gc.getSuburb();
	  		suburb.sendKeys(properties.getProperty("suburb"));
	  		Thread.sleep(3000L);
	  		suburb.sendKeys(Keys.ARROW_DOWN);
	  		suburb.sendKeys(Keys.ENTER);
	  		
	  		gc.getDelInstruction().sendKeys(properties.getProperty("deliveryinst"));
	  		gc.getOrderComment().sendKeys(properties.getProperty("ordercomment"));
	  		
	  		gc.getCardNumber().sendKeys(properties.getProperty("cardnumber"));
	  		
	  	//	a.moveToElement(target)
	  		for(int i=0;i<gc.getExpiryMonthYear().size();i++)
	  		{
	  			if((gc.getExpiryMonthYear().get(i).getText()).equalsIgnoreCase("select month"))
	  			{
	  				
	  				a.moveToElement(gc.getExpiryMonthYear().get(i)).click().sendKeys(Keys.ARROW_DOWN)
	  				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  				break;
	  					
	  			}
	  		}
	  		for(int i =0;i<gc.getExpiryMonthYear().size();i++)
			{
	  			if((gc.getExpiryMonthYear().get(i).getText()).equalsIgnoreCase("select year"))
	  			{
	  				
	  				a.moveToElement(gc.getExpiryMonthYear().get(i)).click().sendKeys(Keys.ARROW_DOWN)
	  				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  				break;
	  			
	  			}
	  		
	  		}
	  		
	  		gc.getCvv().sendKeys(properties.getProperty("cvv"));
	  	//	if(wait.until(ExpectedConditions.elementToBeSelected(gc.getCardName()())))
	  		gc.getCardName().sendKeys(properties.getProperty("cardname"));
	  		
	  		gc.getProcessPaymentButton().click();
	  		
	  	
		
	  	}	
  }
   
   @Test(priority=4)
   /*
    * This is the final page 
    * It will check if the orderm was confirmed or not
    * and will take a screenshot for the same or we can also create a listener for the success or failure*/
   public void OrderConfirmation()
   {
 	  oc = new OrderConfirmed(driver);
 	  
 	  checkPageIsReady();
 	    
 	  if((oc.getOrderConfirmation().getText()).equalsIgnoreCase("Order Successful!"))
 		Assert.assertTrue(true);
 	  else
 		  Assert.assertTrue(false);
 	  }
  
  @AfterTest
  /*
   * And finally closing thw browser*/
  public void teardown()
  {		

	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src,new File("D://screenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.close();
  }
 
}
