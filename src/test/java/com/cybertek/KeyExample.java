package com.cybertek;

import com.github.javafaker.Faker;

public class KeyExample {
	public static void main(String[] args) {
		Faker data=new Faker();
		int num=data.number().numberBetween(1, 4);
		int secondCertification;
		while((secondCertification= data.number().numberBetween(1, 4))==num) {}; 
		System.out.println(num);
		System.out.println(secondCertification);
	}
	

}
