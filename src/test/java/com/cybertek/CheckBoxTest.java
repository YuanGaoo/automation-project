package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//TC 2: Verify checkbox functionality1.
//Open browser2.
//Go to http://the-internet.herokuapp.com/checkboxes3.
//	Verify that the first checkbox is not selected4.
//	Verify that the second checkbox is selected5.
//	Click on the first checkbox6.
//	Verify that the first checkbox is selected7.
//	Verify that the second checkbox is selected8.
//	Clickon the second checkbox9.
//	Verify that the first checkbox is selected10.
//	Verify that the second checkbox is not selected
//	
public class CheckBoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		WebElement firstOne= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		firstOne.click();
		WebElement secondOne= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		secondOne.click();
		
		
		System.out.println(firstOne.isSelected());
		System.out.println(secondOne.isSelected());
		
		            
	}

}
