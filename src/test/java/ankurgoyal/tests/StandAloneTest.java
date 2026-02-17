package ankurgoyal.tests;

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

import ankurgoyal.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		//ankur786@gmail.com
		//9898989898
		//Ankur@123
		String productItem = "ADIDAS ORIGINAL";
		//new comments are added

		// Browser Initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Implicit wait Initialization
		

		//Login
		
		
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage lp= new LandingPage(driver);
		
		
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("ankur786@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ankur@123");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		// Making list and selecting desired product out of it.
		List <WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		
//		for(int i=0;i<productList.size();i++) {
//			
//			if(productList.get(i).getText().contains(productItem)) {
//				driver.findElements(By.cssSelector(".card-body button:last-of-type")).get(i).click();
//			}
//		}
//		

		WebElement prod =productList.stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(productItem)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		

		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
		
		//Traversing cart items
		List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productItem));
		Assert.assertTrue(match);
		
		driver.findElement(By.xpath("//li/button[@type='button']")).click();
		
		//handle auto-suggestive drop-down at check-out page
		
		WebElement auto=driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		Actions a=new Actions(driver);
		a.sendKeys(auto, "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU For THE ORDER."));
		driver.close();
		
		
//		List<WebElement> auto=driver.findElements(By.xpath("//span[@class='ng-star-inserted']/i"));
//		
////		for(WebElement option:auto) {
////			if(option.getText().equalsIgnoreCase(" Indonesia"));
////			option.click();
////			break;
////		}
////			
////		}
	
}
}

