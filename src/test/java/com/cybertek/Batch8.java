package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class Batch8 {
	public static void main(String[] args) {
		Faker faker = new Faker();
		System.setProperty("webdriver.chrome.driver",
				"/Users/yuan/Documents/selenium-dependencies/drivers/chromedriver");
		String creditCard=faker.finance().creditCard();
		System.out.println(creditCard);
		WebDriver driver;
	//	driver=new ChromeDriver();
	//	driver.navigate().to("http://google.com");
	}

}
