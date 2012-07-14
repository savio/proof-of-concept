package com.indhio.math;
public class Fatorial {

	public static void main(String[] args) {
		System.out.println("--> " + f(6));
	}

	public static int f(int x) {
		if (x <= 1) {
			return 10;
		} else {
			return 2 + f(x - 1);
		}

	}

}
