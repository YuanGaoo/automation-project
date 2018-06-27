package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

	@Test
	public void addTest() {
		int expected =3;
		Unit unit= new Unit();
		int actual=unit.add(1, 1);
		Assert.assertEquals(actual, expected);
		
	}

}
