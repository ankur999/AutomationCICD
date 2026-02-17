package ankurgoyal.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ankurgoyal.AbstractComponents.AbstractComponents;

public class OrdersConfirmationPage extends AbstractComponents{
	WebDriver driver;

	public OrdersConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	
	@FindBy(xpath="//tr//td[2]")
	List<WebElement> orderItems;
	
	

	
	public Boolean getOrdersList(String productItem) {
		
		Boolean match=orderItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productItem));
		return match;
		
		
		
	}
	
	
	
	
	

}
