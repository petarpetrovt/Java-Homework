package com.SortArrayofStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortArrayofStrings {

	public static void main(String[] args) {
		int br;

		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			br = Integer.parseInt(s);

			String[] arr = new String[br];

			for (int i = 0; i < br; i++) {
				arr[i] = bufferRead.readLine();
			}

			Arrays.sort(arr);

			for (int i = 0; i < br; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
