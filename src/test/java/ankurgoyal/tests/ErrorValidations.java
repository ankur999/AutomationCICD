package ankurgoyal.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ankurgoyal.TestComponents.BaseTest;
import ankurgoyal.TestComponents.Retry;
import ankurgoyal.pageObjects.CartCatalogue;
import ankurgoyal.pageObjects.CheckOutPage;
import ankurgoyal.pageObjects.ConfirmationPage;
import ankurgoyal.pageObjects.LandingPage;
import ankurgoyal.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {

	@Test(groups={"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {
		
		
		
		
		
		
		
		

		String productItem = "ADIDAS ORIGINAL";
		String countryName = "india";
		LandingPage lp=launchApplication();

		lp.loginApplication("ankur786@gmail.com", "Ankur@1234"); // instead of creating multiple
																	// object
		AssertJUnit.assertEquals("Incorrect email or password.", lp.getErrorMsg());

	}

	@Test
	public void productErrorValidation() throws IOException {
		String productItem = "ADIDAS ORIGINAL";
		LandingPage lp=launchApplication();
		ProductCatalogue pc = lp.loginApplication("ankur786@gmail.com", "Ankur@123"); // instead of creating multiple
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productItem);
		CartCatalogue cc = pc.goToCartPage();
		Boolean match = cc.getCartList("ABIBAS");
		Assert.assertFalse(match);
		
	}

}
