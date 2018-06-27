package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	@AfterClass
	public void setDownClass() {
		System.out.println("runs once After everything in this class");
	}
	@BeforeClass
	public void setUpClass() {
		System.out.println("runs once before everything in this class");
	}
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("runs before every method");
	}
	@Test
	public void testOne() {
		System.out.println("First one");
	}
	@Test
	public void testSecond() {
		System.out.println("Second one");
	}
	@AfterMethod
	public void teardownMethod() {
		System.out.println("runs after every method");
	}
}
