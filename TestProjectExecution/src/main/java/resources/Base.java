package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*Invoking driver in a single class any change in the browser can be done here and can be called 
 * in all test cases
 * Based on browser given we will invoke the respective driver
 * Browser information is in data.properties*/

public class Base {
	
	public WebDriver driver ;
	public Properties properties = new Properties();
	public FileInputStream file = null;
	
	public WebDriver iniatlizeDriver() throws IOException
	{
		file = new FileInputStream("C:\\Users\\GinSun\\eclipse-workspace\\TestProjectExecution\\src\\main\\java\\resources\\data.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GinSun\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\GinSun\\eclipse-workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\GinSun\\eclipse-workspace\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String searchText()
	{
		
		return properties.getProperty("searchText");
		
	}
	
	public void checkPageIsReady() {

		  JavascriptExecutor js = (JavascriptExecutor)driver;


		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
	
	

}
