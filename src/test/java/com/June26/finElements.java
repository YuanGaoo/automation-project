package com.June26;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class finElements {
	WebDriver driver;
	Faker fake= new Faker();
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	/* Homework:
        *  Loop through each inputbox and enter random names
        *  Loop through each dropDown and randomly select by index
        *  Loop through each checkBoxes and select each one
        *  Loop through each radioButton and click one by one by waiting one second intervals
        *  click all buttons
        */
	@Test
	public void seleniumWebElementform() throws InterruptedException {
		driver.get("https://forms.zohopublic.com/murodil/form/"
				+ "SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> inputBoxes= driver.findElements(By.cssSelector("input[type='text']"));
		System.out.println(inputBoxes.size());
		List<WebElement> checkBoxes= driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(checkBoxes.size());
		List<WebElement> radioButtons= driver.findElements(By.cssSelector("input[type='radio']"));
		System.out.println(radioButtons.size());
		List<WebElement> dropDowns= driver.findElements(By.tagName("select"));
		System.out.println(dropDowns.size());
		List<WebElement> buttons= driver.findElements(By.cssSelector("button[value='submit']"));
		System.out.println(buttons.size());
		System.out.println("==========================");
		
		
		for(WebElement each:inputBoxes) {
			each.sendKeys(fake.name().firstName());
			Thread.sleep(1234);
		}
		
		for(WebElement each:checkBoxes) {
			each.click();
			Thread.sleep(1234);
		}
		for(WebElement each:checkBoxes) {
			each.click();
			Thread.sleep(1234);
		}
		
		for(WebElement each:radioButtons) {
			each.click();
			Thread.sleep(1234);
			
		}
		
		for(WebElement each:dropDowns) {
			Select st= new Select(each);
			st.selectByIndex(fake.number().numberBetween(1, 4));
		}
		
//		List<WebElement> element= driver.findElements(By.tagName("input"));
//		List<WebElement> element= driver.findElements(By.tagName("input"));
	}
	

//	@Test
//	public void slideShow() throws InterruptedException {
//		driver.get("https://www.hbloom.com/Gifts/birthday-flowers");
//		List<WebElement> images = driver.findElements(By.tagName("img"));
//		List<String> srcs = new ArrayList<>();
//		
//		for(WebElement flower: images) {
//			srcs.add(flower.getAttribute("src"));
//		}
//		
//		for (String link : srcs) {
//			driver.get(link);
//			Thread.sleep(1234);
//		}
//		
//	}
	
	
	
	
}
