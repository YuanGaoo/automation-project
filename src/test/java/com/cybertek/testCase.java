package com.cybertek;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase {
	WebDriver driver;
	@BeforeMethod
	public void DriverRun() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	@AfterMethod
	public void CloseDriver() {
		//driver.close();
	}
	@Test
	public void amazonSearchOne() throws InterruptedException {
	driver.get("http://amazon.com");
	String str="Selenium book";
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str+Keys.ENTER);
	String xpath="//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
	Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		// isDispalyed() ---> returns true of the element we located is displayed on the page
	driver.findElement(By.id("twotabsearchtextbox")).clear();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA book"+Keys.ENTER);
//	Thread.sleep(2000);
	try {
		Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		// if the element is still in the html , this line will be handle
	} catch (NoSuchElementException e) {
		// if the element is not in the html at all , exception will be 
		e.printStackTrace();
	}
	}
	
	
	
}
