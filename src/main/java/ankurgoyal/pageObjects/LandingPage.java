package ankurgoyal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankurgoyal.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);//this will give knowledge of driver to its parent AbstractComponents
		this.driver=driver;
		PageFactory.initElements(driver, this);//here this represent to current class driver.
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	//PageFactory Design pattern
	@FindBy(id="userEmail")//this will constructed like driver.findElement at the run time
	WebElement userEmail;//and will assign to a variable which we declared above.
	
	//driver.findElement(By.id("userPassword"))
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errorMsg;
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		
		submit.click();
		
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
		
	}
	
	public String getErrorMsg() {
		
		waitForWebElementtoAppear(errorMsg);
		
		String error=errorMsg.getText();
		return error;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
