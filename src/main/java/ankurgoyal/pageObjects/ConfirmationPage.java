package ankurgoyal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ankurgoyal.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMsg;
	
	public String confirmation() {
		
		String msg=confirmationMsg.getText();
		return msg;
		//Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU For THE ORDER."));
		//driver.close();
	}
	
//	public void closeBrowser() {
//		driver.close();
//	}

}
