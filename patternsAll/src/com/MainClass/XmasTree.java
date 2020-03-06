package com.MainClass;

import java.util.Scanner;

public class XmasTree {
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height : ");
		int num = scan.nextInt();
		for (int l = 0; l<2;l++) {
			for(int i = 0; i <= num-1;i++) {
				for(int j = num; j > i; j--) {
					System.out.print(" ");
				}
				for(int k = 0; k < i ; k++) {
					System.out.print("*");
				}
				for(int j = 0 ; j <=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		for(int i = 0; i < num;i++) {
			for(int j = 0; j < num ; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}


}
