package July_8th_Selenium_Page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrderTests {
	Faker faker = new Faker();
	WebDriver driver;
	WebOderLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	PoductsPage productsPage;
	WebOrderOrderLink OrderPage;
	MethodClass method;
	ViewAllOdersPage viewOrderPage;
	String userName = "Tester";
	String passWord = "test";

	public int RandomNumber = faker.number().numberBetween(100, 1000);
	public String RandomName = faker.name().fullName();
	public String street = faker.address().streetAddress();
	public String city = faker.address().city();
	public String state = faker.address().state();
	public String zipcode = faker.address().zipCode();
	public String selectText = "";
	public String cardTypeText = "";
	String expireDate = "";

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setUpApplicatgion() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOderLoginPage(driver);

	}

	 @Test(priority = 1, description = "Verify labels and tab links are displayed")
	public void labelsVerication() {

		assertEquals(driver.getTitle(), "Web Orders Login", "loginPage is not displayed , application is done");
		loginPage.userName.sendKeys(userName);
		loginPage.passWord.sendKeys(passWord);
		loginPage.LoginButton.click();
		allOrdersPage = new AllOrdersPage(driver);
		assertTrue(allOrdersPage.webOrder.isDisplayed(), "Web Orders is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(), "listOfAllOrders is not displayed");
		// assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout",
		// ""),"Welcome, " + userId + "!");
		assertEquals(allOrdersPage.welcomMsg.getText().replace(" | Logout", ""), "Welcome, " + userName + "!");
		assertTrue(allOrdersPage.OrderTabs.isDisplayed(), "orderTab is not displayed");
		allOrdersPage.logout();
	}

	@Test(priority = 2, description = "Verify default Products and prices ")
	public void avaliableProductsTest() {
		loginPage.login(userName, passWord);
		allOrdersPage = new AllOrdersPage(driver);
		allOrdersPage.ViewAllProducts.click();
		/*
		 * MyMoney FamilyAlbum ScreenSaver
		 */
		productsPage = new PoductsPage(driver);
		List<String> expProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();

		productsPage.productName.forEach(elem -> actProducts.add(elem.getText()));

	
		assertEquals(actProducts, expProducts);

		for (WebElement row : productsPage.productsRows) {
			String prodData[] = row.getText().split(" ");
			switch (prodData[0]) {
			case "MyMoney":
				assertEquals(prodData[1], "$100");
				assertEquals(prodData[2], "8%");
				break;
			case "FamilyAlbum":
				assertEquals(prodData[1], "$80");
				assertEquals(prodData[2], "15%");
				break;
			case "ScreenSaver":
				assertEquals(prodData[1], "$20");
				assertEquals(prodData[2], "10%");
				break;
			}

		}

	}
//---------------------home work--------------------
	@Test(priority = 3, description = "type in information and submit")
	public void sendInformationsToOrder() {

		MethodClass methodUse = new MethodClass();
		// LOGIN NEW PAGE
		allOrdersPage = new AllOrdersPage(driver);
		loginPage.login(userName, passWord);

		// FIND ORDERTABS AND GO IN
		allOrdersPage.OrderTabs.click();
		OrderPage = new WebOrderOrderLink(driver);
		Select select = new Select(OrderPage.selectProducts);
		select.selectByIndex(faker.number().numberBetween(0, 3));
		selectText = select.getFirstSelectedOption().getText();

		OrderPage.Quantity.clear();
		OrderPage.Quantity.sendKeys("" + RandomNumber);
		OrderPage.Calcuate.click();
		OrderPage.name.sendKeys(RandomName);
		OrderPage.streetAddress.clear();
		OrderPage.streetAddress.sendKeys(street);
		OrderPage.City.sendKeys(city);
		OrderPage.State.sendKeys(state);
		OrderPage.Zipcode.sendKeys(zipcode.substring(0, 5));
		method = new MethodClass();
		method.TypeCard(driver).click();
		method.CardNumbers(OrderPage.cardNumber, driver);
		expireDate = method.randomDate() + "/" + faker.number().numberBetween(17, 30);
		OrderPage.ExpireDate.sendKeys(expireDate);
		OrderPage.Process.click();
		viewOrderPage = new ViewAllOdersPage(driver);
		viewOrderPage.viewAllOderTable.click();
		
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(), "listOfAllOrders is not displayed");
		List<String> ExpectedPersonInfo = personInfo();
		List<String> ActualPersonInfo = method.rowInfo(viewOrderPage.rowsInfo, driver);
		System.out.println(ExpectedPersonInfo);
		System.out.println(ActualPersonInfo);
		assertEquals(ActualPersonInfo, ExpectedPersonInfo,"two List not same ");

	}

	public List<String> personInfo() {
		List<String> personInfo = new ArrayList<>();
		String date = LocalDate.now().toString();
		String[] arr = date.split("-");
		String newDate = "";
		int num = Integer.parseInt(arr[2]);
		if (num < 10) {
			newDate = arr[1] + "/0" + (num) + "/" + arr[0];
		} else
			newDate = arr[1] + "/" + (num) + "/" + arr[0];

		personInfo.add(RandomName);
		personInfo.add(selectText);
		personInfo.add("" + RandomNumber);
		personInfo.add(newDate);
		personInfo.add(street);
		personInfo.add(city);
		personInfo.add(state);
		personInfo.add(zipcode.substring(0, 5));
		personInfo.add(method.CardText());
		personInfo.add(method.cardNumber());
		personInfo.add(expireDate);

		return personInfo;
	}

}
