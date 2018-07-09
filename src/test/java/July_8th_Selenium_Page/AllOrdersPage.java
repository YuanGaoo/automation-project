package July_8th_Selenium_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {
	public AllOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[.='Web Orders']")
	public WebElement webOrder;
	
	@FindBy(css=".login_info")
	public WebElement welcomMsg;
				//"//h2[contains(.,'List of All Orders')]"
	@FindBy(xpath="//h2[contains(.,'List of All Orders')]")
	public WebElement listOfAllOrders;
	
	@FindBy(linkText="View all products")
	public WebElement ViewAllProducts;
	
	@FindBy(linkText="Order")
	public WebElement OrderTabs;
	
	@FindBy(id="ctl00_logout")
	public WebElement logoutLink;
	
	public void logout() {
		logoutLink.click();
	}

}
