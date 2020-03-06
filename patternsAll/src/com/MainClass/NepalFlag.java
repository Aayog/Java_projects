package com.MainClass;

import java.util.Scanner;

public class NepalFlag {
	public static void main(String[] args) {
		String a = "*";
		Scanner scan = new Scanner(System.in);
		System.out.print("height : ");
		int num = scan.nextInt();
		for(int k = 0; k < 2; k++) {
			for (int i = 0 ; i <num; i++) {
				for(int j = 0 ; j <=i;j++) {
					System.out.print(a);
				}
				System.out.println("\\");
			}
			System.out.print(" ");
			for(int x = 0; x < num;x++) {
				System.out.print("-");
			}
			System.out.println();
		}
		for(int k = 0; k< num;k++) {
			System.out.println(a);
		}
	}
}
		
