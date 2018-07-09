package July_8th_Selenium_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoductsPage {
	public PoductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr/td[1]")
	public List<WebElement> productName;
	
	@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr")
	public List<WebElement>  productsRows;
}
