package com.MainClass;

import java.util.Scanner;
public class OppositeFlag {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height : ");
		int num  = scan.nextInt();
		for(int x =0;x<2;x++) {
			for(int i = 1; i <= num;i++) {
				for(int j = num; j > i; j--) {
					System.out.print(" ");
				}
				for(int k = 0; k < i ; k++) {
					if(k == (num/2) && i == (num/3)) continue;
					System.out.print("*");
				}
				System.out.println();
			}
		}
		for(int i = 1;i<num;i++) {
			for(int j = 1;j <num;j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
}
