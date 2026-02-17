package ankurgoyal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ankurgoyal.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement dropdown;
	
	
	By dropdownVisible=By.cssSelector("section.ta-results");
	
	//dropdown element click: driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement dropdownElementClick;
	
	//click on place order driver.findElement(By.xpath("//div[@class='actions']/a")).click();
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placOrderClick;
	
	
	public void handleDropDown(String countryName) {
		
		WebElement auto=dropdown;
		Actions a=new Actions(driver);
		a.sendKeys(auto, countryName).build().perform();
		
		waitForElementtoAppear(dropdownVisible);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results")));
		
		dropdownElementClick.click();
		
		
		
		
		
	}
	
	public ConfirmationPage placeOrder() {
		
		placOrderClick.click();
		ConfirmationPage confirm=new ConfirmationPage(driver);
		return confirm;
		
		
	}



}
