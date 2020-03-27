package BaseClass;

	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class Utilities
	{
		static WebDriver dr;				//Initializing webdriver
	

		
		public Utilities(WebDriver dr)				//method for constructor class
		{
			this.dr = dr;					//webdriver calling function 
			
		}
			
		public WebElement Explicit_wait(By locator,int timeout)		//method for explicit wait condition
		{
			WebElement u = null;
			try {
				WebDriverWait wait = new WebDriverWait(dr, timeout);
				u = wait.until(
						ExpectedConditions.visibilityOfElementLocated(locator)
						);
				System.out.println("Element Located");
				
			} catch(Exception u1)
			{
				System.out.println("Element not located"+u1);
			}
		
			return u;
		}
		public WebElement ElementToBeCickable(By locator, int timeout)		//method for the element which is to be clickable
		{
			try {
				WebDriverWait wait = new WebDriverWait(dr, timeout);
				WebElement element = wait.until(
						ExpectedConditions.elementToBeClickable(locator)
						);
				System.out.println("Element Located");
				return element;
			} catch (Exception e)
			{
				
				System.out.println("Element not located" + e);
			}
			
			return null;
		}
		
		

		public void ScreenShot(int c1)					//method for taking the screenshots
		{
			
			File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		    File f2=new File("src\\test\\resources\\SCREENSHOT\\"+c1+".png");
		try {
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public WebDriver bb(String b)					//both chrome and firefox web browsers in switch case method
	{
		switch(b)
		{
		
		case "Chrome" :                           //initializing method for chrome browser
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\DRIVER\\chromedriver_v79.exe");
		dr = new ChromeDriver();
		break; 
		case "firefox" :						//initializing method for firefox browser
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\DRIVER\\geckodriver.exe");
		 dr = new FirefoxDriver();
		  break;
		
	}
		dr.get("http://automationpractice.com/index.php");    //webdriver to locate and enter the application in web browser
		dr.manage().window().maximize();    //to maximize the screen
		dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		//implicit wait condition
		return dr;
	}
	}
	