package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestThatCleansUp {
	WebDriver driver;
	@Test
	public void searchGoogle() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.findElement(By.id("lst-id")).sendKeys("selenium cookbook"+Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));
	}
	@Test
	public void searchAmazon() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("me"+Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("me"));
		
	}
//	@Test
//	public void serchAmazon() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.amazon.com");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("me" + Keys.ENTER);
//		Assert.assertTrue(driver.getTitle().contains("me"));
//	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
