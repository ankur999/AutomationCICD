package ankurgoyal.stepdefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import ankurgoyal.TestComponents.BaseTest;
import ankurgoyal.pageObjects.CartCatalogue;
import ankurgoyal.pageObjects.CheckOutPage;
import ankurgoyal.pageObjects.ConfirmationPage;
import ankurgoyal.pageObjects.LandingPage;
import ankurgoyal.pageObjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefImp extends BaseTest{
	
	public LandingPage lp;
	public ProductCatalogue pc;
	public CheckOutPage cp ;
	public ConfirmationPage confirm;
	
	@Given("I landed on Ecomm page")
	public void I_landed_on_Ecomm_page() throws IOException {
		lp=launchApplication();
		
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	public void Given_logged_in_with_username_and_password(String username, String password){
		pc = lp.loginApplication(username,password);
		
	}
	
	@When("^I add product (.+) to the cart$")
	public void Add_product_to_the_cart(String productName) {
		
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productName);
	}
	
	@And("^checkout (.+) is checked out and submit the order$")
	public void Checkout_and_submit_the_order(String productname) {
		
		CartCatalogue cc = pc.goToCartPage();
		Boolean match = cc.getCartList(productname);
		Assert.assertTrue(match);
		cp = cc.goToCheckout();
		cp.handleDropDown("india");
		confirm = cp.placeOrder();
		
	}
	
	@Then("Verify {string} is displayed or not")
	public void Verify_message_is_displayed_or_not(String msg) {
		String msgConfirm = confirm.confirmation();
		Assert.assertTrue(msgConfirm.equalsIgnoreCase(msg));
		driver.close();
		
	}
	
	@Then("Verify incorrect {string} is displayed or not")
	public void Verify_incorrect_message_is_displayed_or_not(String msg1) {
		//lp.loginApplication("ankur786@gmail.com", "Ankur@1234"); // instead of creating multiple
		
		AssertJUnit.assertEquals(msg1, lp.getErrorMsg());
		driver.close();
		
	}
	
	

}
