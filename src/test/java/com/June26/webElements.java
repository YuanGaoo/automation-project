package com.June26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webElements {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}

	@Test
	public void webElementExamples() {
		driver.get("http://github.com");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		List<String> tostring=new ArrayList<>();
		System.out.println(driver.findElement(By.tagName("a")).getText());
		int numberOfLinksOnGitHub=links.size();
		int count=1;
		for(WebElement print:links) {
			if(!print.getText().isEmpty()) {
			//System.out.println(print.getText()+"---->"+count++);
			tostring.add(print.getText());
			}
		}
		for(String each:tostring) {
			System.out.println(each);
		}
		//System.out.println(numberOfLinksOnGitHub);
	
	
	}
}
