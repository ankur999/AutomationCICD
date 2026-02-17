package ankurgoyal.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ankurgoyal.pageObjects.CartCatalogue;
import ankurgoyal.pageObjects.OrdersConfirmationPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// click on add to cart driver.findElement(By.xpath("//button[@routerlink =
	// '/dashboard/cart']")).click();

	@FindBy(xpath = "//button[@routerlink = '/dashboard/cart']")
	WebElement addToCartClick;

	// click on orders page

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersClick;

	// this will be the parent class for all page objects classes as it is holding
	// re-usable code

	public void waitForElementtoAppear(By findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(findby));
	}

	public void waitForWebElementtoAppear(WebElement findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void waitForElementtoDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public CartCatalogue goToCartPage() {

		addToCartClick.click();

		CartCatalogue cc = new CartCatalogue(driver);
		return cc;
	}

	public OrdersConfirmationPage goToOrdersPage() {

		ordersClick.click();
		
	OrdersConfirmationPage ocp=new OrdersConfirmationPage(driver);
		return ocp;

	}

}
