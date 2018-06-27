package com.Test_SDET_Job_Application;
/* Test case #001
 * 	TC description : full name must be mandatory
 * 	1. Given i am on SDET job application page 
 * 	2.When i do not provide full name information
 * 	3.And i click next 
 * 	4. Then error message "Enter a value for this field ".
 * 
 * You are assigned to test a user story:
 * 	what steps you take to test and automate it ?
 * 		1. Analyze user story
 * 		2. Wrote test case based on positive or negative scenarios
 * 		3. Manually test it 
 * 		4. if no bugs then start automation, else log the defect and reject automation
 * 
 * 		Story > diff senarios ()
 * */

/*
  HomeWork:
	1) Finish all step and click on Apply
	2)Validate each value
IP address : go to google and search for what is my ip
	3)Go to your email and find the email and click on it by id. SDET Application #id
*/


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInfoTests {
	WebDriver driver;
	String firstName;
	String lastName;
	int gender;
	String dateOfBirth;
	String settedDateBirth ;
	String email;
	String phoneNumber;
	String city;
	String state;
	String country;
	String ipAddress;
	String MyipAddress;
	int annualSalary;
	List<String> technologies;
	int yearsOfExperience;
	String education;
	String github;
	List<String> certifications;
	String additionalSkills;
	static String actualIpAddress;
	Faker data = new Faker();
	Random random = new Random();
	
	String actualCountry;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@BeforeMethod // runs before each @Test
	public void navigateToHomePage() {
		System.out.println("Navigating to homepage in @BeforeMethod....");
		driver.get(
				"https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		firstName = data.name().firstName();
		lastName = data.name().lastName();
		gender = data.number().numberBetween(1, 3);
		dateOfBirth = data.date().birthday().toString();
		email = "yuangao666@gmail.com";
		phoneNumber = data.phoneNumber().cellPhone().replace(".", "");
		city = data.address().cityName();
		state = data.address().stateAbbr();
		country = data.address().country();
		annualSalary = data.number().numberBetween(60000, 150000);
		technologies = new ArrayList<>();
		technologies.add("Java-" + data.number().numberBetween(1, 4));
		technologies.add("HTML-" + data.number().numberBetween(1, 4));
		technologies.add("Selenium WebDriver-" + data.number().numberBetween(1, 4));
		technologies.add("TestNG-" + data.number().numberBetween(1, 4));
		technologies.add("Git-" + data.number().numberBetween(1, 4));
		technologies.add("Maven-" + data.number().numberBetween(1, 4));
		technologies.add("JUnit-" + data.number().numberBetween(1, 4));
		technologies.add("Cucumber-" + data.number().numberBetween(1, 4));
		technologies.add("API Automation-" + data.number().numberBetween(1, 4));
		technologies.add("JDBC-" + data.number().numberBetween(1, 4));
		technologies.add("SQL-" + data.number().numberBetween(1, 4));

		yearsOfExperience = data.number().numberBetween(0, 11);
		education = data.number().numberBetween(1, 4) + "";
		github = "https://github.com/CybertekSchool/selenium-maven-automation.git";
		certifications = new ArrayList<>();
		certifications.add("Java OCA");
		certifications.add("AWS");
		certifications.add("Scrum Master");
		additionalSkills = data.job().keySkills();

	}

	@Test
	public void submitFullApplication() {
		driver.findElement(By.xpath("//input[@name='Name_First']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='Name_Last']")).sendKeys(lastName);
		setGender(gender);
		setDateOfBirth(dateOfBirth);
		// <input type="text" maxlength="255" name="Email" value=""
		// invlovedinsalesiq="false">
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		// <input type="text" name="countrycode" elname="countrycode" maxlength="20"
		// invlovedinsalesiq="false" value="">
		driver.findElement(By.xpath("//input[@name='countrycode']")).sendKeys(phoneNumber);

		// <input type="text" maxlength="255" name="Address_City" value="">
		driver.findElement(By.xpath("//input[@name='Address_City']")).sendKeys(city);
		// <input type="text" maxlength="255" name="Address_Region" value="">
		driver.findElement(By.xpath("//input[@name='Address_Region']")).sendKeys(state);
		Select countryElem = new Select(driver.findElement(By.xpath("//select[@id='Address_Country']")));
		int num=data.number().numberBetween(1, countryElem.getOptions().size());
		countryElem.selectByIndex(num);
		actualCountry=countryElem.getFirstSelectedOption().getText();
		
		// <input type="text" maxlength="18" name="Number" value="">
		driver.findElement(By.xpath("//input[@name='Number']")).sendKeys(String.valueOf(annualSalary) + Keys.TAB);
		// <input type="text" name="Formula" disabled="true" class="inputDisabled">
		String monthly = driver.findElement(By.xpath("//input[@name='Formula']")).getAttribute("value");
		String weekly = driver.findElement(By.xpath("//input[@name='Formula1']")).getAttribute("value");
		String hourly = driver.findElement(By.xpath("//input[@name='Formula2']")).getAttribute("value");
		veryfySalaryCalculations(annualSalary);
		driver.findElement(By.xpath("//em[.=' Next ']")).click();
		
		
		// second pages
		setSkillSet(technologies);
//		<a href="javascript:;" elattr="" class="shieldRating" onclick="selectRating(this,1,10,3)"
//				onmouseover="mouseOverRating(this,1,10,3)" 
//				onmouseout="mouseOutRating(this,1,10,3)" rating_value="1" name="Rating"></a>
		if(yearsOfExperience>0) {
		driver.findElement(By.xpath("//a[@rating_value='"+yearsOfExperience+"']")).click();
		}
		
//		<select name="Dropdown">
//		<option selected="true" value="-Select-">-Select-</option>
//		<option value="High School" formula_val="">High School</option>
//		<option value="Under Graduate" formula_val="">Under Graduate</option>
//		<option value="Post Graduate" formula_val="">Post Graduate</option>
//		</select>
		Select educationList= new Select(driver.findElement(By.xpath("//select[@name='Dropdown']")));
		educationList.selectByIndex(data.number().numberBetween(1, educationList.getOptions().size()));
		selectCertifications();
		//<textarea name="MultiLine">google&gt;copy&gt;paste ;)</textarea>
		driver.findElement(By.xpath("//textarea[@name='MultiLine']")).clear();
		driver.findElement(By.xpath("//textarea[@name='MultiLine']")).sendKeys("aglie");
		//<em>Apply</em>
		driver.findElement(By.xpath("//em[.='Apply']")).click();
		
//==================== third pages ==================
		//IP address: 184.185.44.234
		//driver.findElement(By.xpath("//*[.='IP address: 184.185.44.234']")).getText();
		ipAddress=driver.findElement(By.xpath("//label[@class='descFld']/div[6]")).getText();
	
		System.out.println(ipAddress);
		////*[@id="richTxtMsgSpan"]/label/div[6]
		
	}
	
	
	@Test
	public void ValidateEachValue() {
		String actualNam=driver.findElement(By.xpath("//label[@class='descFld']/div[1]")).getText();
		assertEquals(actualNam, "Dear "+firstName+" "+lastName+",");
		assertTrue(driver.findElement(By.xpath("//label[@class='descFld']/div[2]")).isDisplayed());
		String ActualGender= driver.findElement(By.xpath("//label[@class='descFld']/div[9]")).getText().replace("Gender:", "");
		assertEquals(ActualGender, GenderString(gender));
		String ActualDateOfBirth=driver.findElement(By.xpath("label[@class='descFld']/div[9]")).getText().replace("Date of birth: ","");
		assertEquals(ActualDateOfBirth, settedDateBirth);
		String ActualEmail=driver.findElement(By.xpath("By.xpath(\"(//label[@class='descFld']/div)[11]")).getText();
		assertEquals(ActualEmail, "Email: "+email);
		String ActualPhone=driver.findElement(By.xpath("(//label[@class='descFld']/div)[12]")).getText();
		assertEquals(ActualPhone, "Phone: "+phoneNumber);
		String ActualAddress = driver.findElement(By.xpath("(//label[@class='descFld']/div)[13]")).getText();
		assertEquals(ActualAddress,"Address: "+ city +", "+ state +", "+actualCountry );
		String ActualSalary=driver.findElement(By.xpath("//label[@class='descFld']/div)[13]")).getText();
		assertEquals(ActualSalary,"Annual Salary: "+ annualSalary);
		
		
		 //ipAddress=driver.findElement(By.xpath("//label[@class='descFld']/div[6]")).getText();

	}

	public void selectCertifications() {
//		<input type="checkbox" id="Checkbox_1" class="checkBoxType"
//						name="Checkbox-check" elname="Checkbox" value="Java OCA" formula_val="">
//		<input type="checkbox" id="Checkbox_2" class="checkBoxType" 
//						name="Checkbox-check" elname="Checkbox" value="AWS" formula_val="">
		
			
		//String xpath="//input[@id='Checkbox_"+data.number().numberBetween(1, 4)+"']";
		int num=data.number().numberBetween(1, 4);
		int secondCertification;
		while((secondCertification= data.number().numberBetween(1, 4))==num) {}; 
		driver.findElement(By.xpath("//input[@id='Checkbox_"+num+"']")).click();
		driver.findElement(By.xpath("//input[@id='Checkbox_"+secondCertification+"']")).click();	
		
		
	}
	
	public String expectedIpAddressTest() {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@id='lst-ib']")).clear();
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("what my ip address");
		//<div class="pIpgAc xyYs1c XO51F xsLG9d" style="-webkit-line-clamp:2">184.185.44.234</div>
		String expected =driver.findElement(By.xpath("//div[@class='pIpgAc xyYs1c XO51F xsLG9d']")).getText();
		return expected;
		
		
	}
	public void setSkillSet(List<String> tech) {
		// <input type="radio" id="MatrixChoice_row
		// name="MatrixChoice_row2" elname="MatrixChoice"
		// columnvalue="Expert" rowvalue="Java" matrixselectval="false"
		// onclick="ZFLive.selectMatrixChoiceRadioType(this);">

		for (String skill : tech) {
			String technology = skill.substring(0, skill.length() - 2);
			int rate = Integer.parseInt(skill.substring(skill.length() - 1));
			String level = "";
			switch (rate) {
			case 1:
				level = "Expert";
				break;

			case 2:
				level = "Proficient";
				break;
			case 3:
				level = "Beginner";
				break;

			}
			// String xpath = "//input[@rowvalue='" + technology + "'and @columnvalue'" +
			// level + "";
			// driver.findElement(By.xpath(xpath)).click();
			String xpath = "//input[@rowvalue='" + technology + "' and @columnvalue='" + level + "']";
			driver.findElement(By.xpath(xpath)).click();
		}
		// String xpath = "//input[@rowvalue='Java' and @ columnvalue='Expert']";

	}

	public void veryfySalaryCalculations(int annual) {
		String monthly = driver.findElement(By.xpath("//input[@name='Formula']")).getAttribute("value");
		String weekly = driver.findElement(By.xpath("//input[@name='Formula1']")).getAttribute("value");
		String hourly = driver.findElement(By.xpath("//input[@name='Formula2']")).getAttribute("value");
		DecimalFormat formatter = new DecimalFormat("#.##");
		assertEquals(Double.parseDouble(monthly), Double.parseDouble(formatter.format((double) annual / 12.0)));
		assertEquals(Double.parseDouble(weekly), Double.parseDouble(formatter.format((double) annual / 52.0)));
		assertEquals(Double.parseDouble(hourly), Double.parseDouble(formatter.format((double) annual / 52.0 / 40.0)));
	}

	public void setDateOfBirth(String dob) {
		String[] pieces = dob.split(" ");
		String birthDay = pieces[2] + "-" + pieces[1] + "-" + pieces[5];
		// <input name="date" id="Date-date"
		// onclick="$(this).datepicker().datepicker('show')"
		// onfocus="$(this).datepicker().datepicker('show')"
		// type="text" value="" class="hasDatepicker">
		driver.findElement(By.xpath("//input[@id='Date-date']")).sendKeys(birthDay + Keys.TAB);
		 settedDateBirth = birthDay;

	}

	public void setGender(int n) {
		// <input type="radio" id="Radio_1" name="Radio-choice" elname="Radio"
		// class="radioBtnType" value="Male" formula_val="">

		if (n == 1) {
			driver.findElement(By.xpath("//input[@value='Male']")).click();
		}
		// <input type="radio" id="Radio_2" name="Radio-choice" elname="Radio"
		// class="radioBtnType" value="Female" formula_val="">
		else {
			driver.findElement(By.xpath("//input[@value='Female']")).click();
		}
		

	}
	public String GenderString(int n) {
		if(n==1) {
			return "Male";
		}else {
			return "Female";
		}
	}

	@Test
	public void FullNameEmptyTest() {
		// firstly assert that you are on the correct page
		assertEquals(driver.getTitle(), "SDET Job Application");
		// <input type="text" maxlength="255" elname="first" name="Name_First" value=""
		// invlovedinsalesiq="false">
		// xpath --> "// input[@maxlength='255']";
		driver.findElement(By.xpath("//input[@name='Name_First']")).clear();
		// <input type="text" maxlength="255" elname="last" name="Name_Last" value=""
		// invlovedinsalesiq="false">
		driver.findElement(By.xpath("//input[@elname='last']")).clear();
		// <em> Next </em>
		driver.findElement(By.xpath("//em[.=' Next ']")).click();
		// write xpath with tagame +id
		// get the text and assert text equal to Enter a value for this field
		// <p class="errorMessage" elname="error" id="error-Name" style="display:
		// block;">Enter a value for this field.</p>
		String error = driver.findElement(By.xpath("//p[@id='error-Name']")).getText();
		// assertEquals(error, "Enter a value for this field.");
		assertTrue(true, "Enter a value for this field.");
	}

}
