package July_8th_Selenium_Page;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class MethodClass {
	Faker faker = new Faker();
	int number = faker.number().numberBetween(0, 3);
	String visa = faker.finance().creditCard(CreditCardType.VISA).replaceAll("-", "");
	String master = faker.finance().creditCard(CreditCardType.MASTERCARD).replaceAll("-", "");
	String amex = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS).replaceAll("-", "");
	// table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td[2]

	public WebElement TypeCard(WebDriver driver) {
		switch (number) {
		case 0:

			return driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));

		case 1:
			return driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));

		case 2:
			return driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));

		}
		return null;

	}

	public String cardNumber() {
		if (number == 0)
			return visa;
		if (number == 1)
			return master;
		else
			return amex;

	}

	public String CardText() {
		if (number == 0)
			return "Visa";
		if (number == 1)
			return "MasterCard";
		else
			return "American Express";
	}

	public void CardNumbers(WebElement element, WebDriver driver) {
		switch (number) {
		case 0:
			element.sendKeys(visa);
			break;
		case 1:
			element.sendKeys(master);
			break;
		case 2:
			element.sendKeys(amex);
			break;
		}

	}

	public String randomDate() {
		int num = faker.number().numberBetween(1, 13);
		if (num < 10)
			return "0" + num;
		return "" + num;
	}

	// table[@class='SampleTable']/tbody/tr[2]/td[12] 2--12
	public List<String> rowInfo(List<WebElement> elements, WebDriver driver) {
		List<String> all = new ArrayList<>();
		for (int i = 1; i < elements.size() - 1; i++) {
			all.add(elements.get(i).getText());
		}

		return all;
	}

}
