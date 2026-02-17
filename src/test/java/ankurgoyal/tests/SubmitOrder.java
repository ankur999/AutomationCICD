package ankurgoyal.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ankurgoyal.TestComponents.BaseTest;
import ankurgoyal.TestComponents.Retry;
import ankurgoyal.pageObjects.CartCatalogue;
import ankurgoyal.pageObjects.CheckOutPage;
import ankurgoyal.pageObjects.ConfirmationPage;
import ankurgoyal.pageObjects.LandingPage;
import ankurgoyal.pageObjects.OrdersConfirmationPage;
import ankurgoyal.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {
	
	String productItem = "ADIDAS ORIGINAL";

	@Test(dataProvider="getData",groups= {"Purchase"},retryAnalyzer=Retry.class)
	public void SubmitOrder(HashMap<String,String> input) throws IOException {
		

		
		String countryName = "india";
		LandingPage lp=launchApplication();

		ProductCatalogue pc = lp.loginApplication(input.get("email"), input.get("pass")); // instead of creating multiple
																						// object

		// ProductCatalogue pc=new ProductCatalogue(driver);
		List<WebElement> products = pc.getProductList();

		// pc.getProductByName(productItem);
		pc.addProductToCart(productItem);
		CartCatalogue cc = pc.goToCartPage();

		// CartCatalogue cc=new CartCatalogue(driver);
		Boolean match = cc.getCartList(productItem);

		Assert.assertTrue(match);
		CheckOutPage cp = cc.goToCheckout();

		// CheckOutPage cp=new CheckOutPage(driver);
		cp.handleDropDown(countryName);
		ConfirmationPage confirm = cp.placeOrder();

		// ConfirmationPage confirm=new ConfirmationPage(driver);
		String msgConfirm = confirm.confirmation();
		Assert.assertTrue(msgConfirm.equalsIgnoreCase("THANKYOU For THE ORDER."));
		//confirm.closeBrowser();

	}
	@Test(dependsOnMethods="SubmitOrder")
	public void OrderHistoryTest() throws IOException {
		LandingPage lp=launchApplication();

		ProductCatalogue pc = lp.loginApplication("ankur786@gmail.com", "Ankur@123");
		OrdersConfirmationPage ocp=pc.goToOrdersPage();
		Assert.assertTrue(ocp.getOrdersList(productItem));
		
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//suppose there are 10-15 param you want to send the better is by using Hashmap
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "ankur786@gmail.com");
//		map.put("pass", "Ankur@123");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "goyal@gmail.com");
//		map1.put("pass", "Ankur@123");
		
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ankurgoyal//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		//return new Object[][] {{"ankur786@gmail.com","Ankur@123"},{"goyal@gmail.com","Ankur@123"}};
	}

}
