package July_8th_Selenium_Page;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOderLoginTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Ignore
	@Test
	public void postiveloginTest() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	
	
	@Test(priority=2)
	public void poistiveLoginUsingPOM() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		WebOderLoginPage longinPage= new WebOderLoginPage(driver);
		longinPage.userName.sendKeys("Tester");
		longinPage.passWord.sendKeys("test");
		longinPage.LoginButton.click();
	}
	
	@Test(priority=1)
	public void invalidUserNameTest() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOderLoginPage longinPage= new WebOderLoginPage(driver);
			longinPage.userName.sendKeys("inVaload");
			longinPage.passWord.sendKeys("test");
			longinPage.LoginButton.click();
			String errMsg= longinPage.invalidUserNameErrMsg.getText();
			assertEquals(errMsg, "Invalid Login or Password.");
	}
	
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

}
