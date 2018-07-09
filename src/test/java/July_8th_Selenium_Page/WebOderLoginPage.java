package July_8th_Selenium_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOderLoginPage {
	public WebOderLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_MainContent_username")
	public WebElement userName;
	
	@FindBy(id="ctl00_MainContent_password")
	public WebElement passWord;
	
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement LoginButton;
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement invalidUserNameErrMsg;
	
	public void login(String uid,String pwd) {
		userName.sendKeys(uid);
		passWord.sendKeys(pwd);
		LoginButton.click();
	}
}
