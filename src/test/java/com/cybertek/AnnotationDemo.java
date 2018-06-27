package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AnnotationDemo {
	@AfterMethod
	public void tearDown() {
		System.out.println("clear up");
	}
	@Test
	public void testOne() {
		String a="ASD";
		String b="ASDfa";
		System.out.println("asserting first");
		Assert.assertTrue(false);
		System.out.println("done asserting first"); 
	}
	@Test
	public void testTwo() {
		String a="ASD";
		String b="ASDfa";
		System.out.println("asserting second");
		Assert.assertTrue(true);
		System.out.println("done asserting second"); 
	}
}
