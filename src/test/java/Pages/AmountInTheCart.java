package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class AmountInTheCart {
	WebDriver dr; 
	Utilities ut;
	public AmountInTheCart(WebDriver dr)
	{
		this.dr=dr;
		ut = new Utilities(dr);
	}
	
	By women = By.xpath("//a[@title='Women']");		//display of all products in shopping............
	By select_product1 = By.xpath("//*[@id='center_column']//ul//li[5]//div//div[2]//h5//child::a");	//selecting first product in the shopping.........
	By add_to_cart = By.xpath("//button[@name='Submit']//child::span");		//adding selected product to the cart.......
	By continue_shopping = By.xpath("//span[@title='Continue shopping']//child::span");		//to continue the shopping........
	By select_product2 = By.xpath("//a[@style='background:#5D9CEC;']");  //selecting the second product in the cart..........
	By select_product3 = By.xpath("//a[@id='color_13']");		//selecting the third product in the cart.......
	By check_out = By.xpath("//a[@title='Proceed to checkout']//child::span");		//proceeding to checkout after the shopping is done........
	
	public void Women()		//method for displaying all the products in shopping........
	{
			WebElement we = ut.WaitForElement(women, 10);
			we = ut.elementToBeClickable(women, 10);
			we.click();
		}
	
	public void Select_Product1()		//method for selecting a product and continue the shopping......
	{
		WebElement we = ut.WaitForElement(select_product1, 10);
		we = ut.elementToBeClickable(select_product1, 10);
		we.click();
		dr.findElement(add_to_cart).click();
		dr.findElement(continue_shopping).click();		
	}
	
	public void Select_Product2()		//method for selecting a product and continue the shopping......
	{
		WebElement we = ut.WaitForElement(select_product2, 10);
		we = ut.elementToBeClickable(select_product2, 10);
		we.click();
		dr.findElement(add_to_cart).click();
		dr.findElement(continue_shopping).click();		
	}
	
	public void Select_Product3()		//method for selecting a product and continue the shopping......
	{
		WebElement we = ut.WaitForElement(select_product3, 10);
		we = ut.elementToBeClickable(select_product3, 10);
		we.click();
		dr.findElement(add_to_cart).click();
		dr.findElement(check_out).click();		
	}
	
	public String AmountInCart()		//method calling all the above methods in a systematic sequence for the execution... 
	{
		this.Women();
		this.Select_Product1();
		this.Select_Product2();
		this.Select_Product3();
		return dr.findElement(By.xpath("//td[@id='total_price_container']//child::span")).getText();
	}
}


