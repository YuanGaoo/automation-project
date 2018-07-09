package July_8th_Selenium_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class WebOrderOrderLink {
	
	
	public WebOrderOrderLink(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "ctl00$MainContent$fmwOrder$ddlProduct")
	public WebElement selectProducts;

	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement Quantity;
	
	@FindBy(xpath="//input[@value='Calculate']")
	public WebElement Calcuate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement name;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement streetAddress;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement City;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement State;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement Zipcode;
	
	@FindBy(xpath="//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td")
	public List<WebElement> typeCard;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNumber;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement  ExpireDate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement Process;
	
	
	
	
}