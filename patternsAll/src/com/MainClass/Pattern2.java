package com.MainClass;

import java.util.Scanner;

public class Pattern2 {
	public static void main(String[] args) {
		String a = "*";
		Scanner scan = new Scanner(System.in);
		System.out.print("height : ");
		int num = scan.nextInt();
		for (int i = 0 ; i < num; i++) {
			for(int j = num ; j >i;j--) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}
