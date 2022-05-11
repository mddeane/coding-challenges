package com.revature;

public class RecursiveMultiply {

	public static void main(String[] args) {
		int a = 50;
		int b = 5;
		System.out.println("Recursive multiply " + a + " and " + b + " without using * operator.");
		System.out.println(multiply(50,5));
	}
	
	static int multiply(int x, int y) {
		if (y > 0) {
			return multiply(x, y-1) + x;
		}
		return 0;
	}
}
