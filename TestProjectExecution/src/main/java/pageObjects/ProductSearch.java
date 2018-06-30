package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearch {
	
	public WebDriver driver;
	
	By selectedProduct = By.xpath("//a[@data-product-link='CV116']");
	
	public ProductSearch(WebDriver driver) {

		this.driver = driver;
	}



	public WebElement getSelectedProduct()
	{
		return driver.findElement(selectedProduct);
	}
	

}
