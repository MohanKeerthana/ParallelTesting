package com.validateLinks;

public class Good {

	public static void main(String[] args) {
		int num = 12;
		String s1;
		String var1 = "GoodMorning";
		String var2 = "GoodNight";
		//Single line conditional statements.
		 s1= ((num%3==0)? var1 : var2);
		System.out.println(s1);
		
		if(num%3==0) {
			System.out.println(var1);
		}else {
			System.out.println(var2);
		}
	}
}
