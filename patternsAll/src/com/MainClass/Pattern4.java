package com.MainClass;

import java.util.Scanner;

public class Pattern4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height : ");
		int num = scan.nextInt();
		for (int i = 0;i < num;i++) {
			for(int j = 0;j<i;j++) {
				System.out.print(" ");
			}
			for(int l = num;l>i;l--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
