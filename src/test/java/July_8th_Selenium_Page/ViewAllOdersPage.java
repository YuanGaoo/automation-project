package July_8th_Selenium_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOdersPage {
	public ViewAllOdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="View all orders")
	public WebElement viewAllOderTable;
	
	@FindBy(xpath="//h2[contains(.,'List of All Orders')]")
	public WebElement ListOfAlOrderText;
	
	@FindBy(xpath="//table[@class='SampleTable']/tbody/tr[2]/td")
	public List<WebElement> rowsInfo;
}
