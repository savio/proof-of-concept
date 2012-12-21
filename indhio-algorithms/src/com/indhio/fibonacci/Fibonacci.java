package com.indhio.fibonacci;

public class Fibonacci {
	
	private static int count = 0;

	public static void main(String[] args) {
		int num = 4;
		fibonacci(5);
//		for (int i = 1; i <= num; i++) {
//			System.out.println("Fibonacci de " + i + " = " + fibonacci(i));
//		}
		System.out.println("count >> " + count);
	}

	public static int fibonacci(int num) {
		count++;
		if (num <= 1) {
			return num;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

}
