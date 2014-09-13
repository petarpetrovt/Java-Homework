package com.SumTwoNumbers;

import java.util.Scanner;

public class SumTwoNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.next());
		int b = Integer.parseInt(scanner.next());

		System.out.println(a + b);
	}

}
