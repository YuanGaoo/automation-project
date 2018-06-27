package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//TC 1: Verify Search term1.Open browser2.
//Open Etsy homepage3.Enter search term4.
//Verify the results page title contains the search term5.
//Verify search entry is still saved in the search bar

public class verifySeach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
			driver.get("https://www.etsy.com");
			String searchTerm="fatehrs day gifts";
		WebElement input=	driver.findElement(By.id("search-query"));
			input.sendKeys(searchTerm+Keys.ENTER);
			input=driver.findElement(By.id("search-query"));
			String actual=input.getText();
			System.out.println(actual);
			if(actual.equals(searchTerm)) {
				System.out.println("pass");
			}else {
				System.out.println("fail");
				System.out.println("expected :\t"+searchTerm);
				System.out.println("found:\t"+actual);
			}
		
			
			
			
		
	}

}
