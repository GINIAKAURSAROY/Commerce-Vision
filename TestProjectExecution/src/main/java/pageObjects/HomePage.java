package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By searchInputText = By.id("search-container");
	By searchButton	   = By.cssSelector(".btn.search");
	
	public HomePage(WebDriver driver) {

		this.driver = driver;
	}



	public WebElement getSearchInputText()
	{
		return driver.findElement(searchInputText);
	}
	
	public WebElement getSearchButton()
	{
		return driver.findElement(searchButton);
	}

}
