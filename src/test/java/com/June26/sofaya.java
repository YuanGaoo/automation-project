package com.June26;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class sofaya {
	WebDriver driver;

	@BeforeClass public void setUpMethod() 
	{ WebDriverManager.chromedriver().setup(); 
	driver = new ChromeDriver(); driver.get("https://learn.letskodeit.com/p/practice"); 
	//driver.manage().window().fullscreen();
	driver.manage().window().maximize(); 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Radio() throws InterruptedException {
		
		Button("//input[@type='checkbox']");
		Button("//input[@type='radio']");
		SelectE("carselect");
		SelectE("multiple-select-example");

	}
	@Test
	public void WebTable() {
		////*[last()-1][name()='E']
		List <WebElement> CourseList=driver.findElements(By.xpath("//table[@id='product']//td[2]"));
		for(WebElement each:CourseList) {
			
		}
		
	}
	
	
	public void Button(String xpath) throws InterruptedException {
		List<WebElement> rButton=driver.findElements(By.xpath(xpath));
		//rButton=driver.findElements(By.xpath(xpath));
		for(WebElement each:rButton) {
			each.click();
			Thread.sleep(500);
		}
	}
	public void SelectE(String id) throws InterruptedException {
		Select select=new Select(driver.findElement(By.id(id)));
		List<WebElement> allop= select.getOptions();
		for(WebElement each: allop) {
			select.selectByVisibleText(each.getText());
			Thread.sleep(500);
		}
	}

}
