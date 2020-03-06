package com.MainClass;

import java.util.Scanner;

public class Building {
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height : ");
		int num = scan.nextInt();
		for(int i = 1; i <=num;i++) {
			for(int l = 0;l<4;l++) {
				for(int j = 5; j > i;j--) {
					System.out.print(" ");
				}
				for(int k = 1;k < i*2;k ++) {
					System.out.print("*");
				}
				for(int k = num;k > i;k--) {
					System.out.print(" ");
				}
			System.out.println();
			}
		}
	}

}
