package com.validateLinks;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter arrray size : ");
		int asize = sc.nextInt();

		int[] ar = new int[asize];
		for (int i = 0; i < asize; i++) {
			System.out.println("enter arrray value of "+i + " : ");
			ar[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(ar));
	}

}
