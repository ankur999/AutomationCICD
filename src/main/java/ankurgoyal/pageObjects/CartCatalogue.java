package ankurgoyal.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ankurgoyal.AbstractComponents.AbstractComponents;

public class CartCatalogue extends AbstractComponents{
	WebDriver driver;

	public CartCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartItems;
	
	//checkout button driver.findElement(By.xpath("//li/button[@type='button']")).click();
	
	@FindBy(xpath="//li/button[@type='button']")
	WebElement checkoutClick;
	
	public Boolean getCartList(String productItem) {
		
		Boolean match=cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productItem));
		return match;
		
		
		
	}
	
	public CheckOutPage goToCheckout() {
		
		 checkoutClick.click();
		 
		 CheckOutPage cp=new CheckOutPage(driver);
		 return cp;
		 
	}
	
	
	

}
