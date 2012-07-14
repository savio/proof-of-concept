package com.indhio.math;

public class Round {
	
	public static void main(String[] args) {
		int num_secreto = 1 + (int) (Math.random() * 65536);
		//System.out.println(num_secreto);
		ssh();
	}
	
	public static void ssh() {
		int num1 = 1 + (int) (Math.random() * 6);
		int num2 = 1 + (int) (Math.random() * 5);
		int num3 = 1 + (int) (Math.random() * 9);
		int num4 = 1 + (int) (Math.random() * 9);
		int num5 = 1 + (int) (Math.random() * 9);
		System.out.println("ssh = " + num1 + num2 + num3 + num4 + num5);
		
	}

}

// 41450
// 55477
// 30020
// 16269
// 15275
// 29244
// 15647

// 25712