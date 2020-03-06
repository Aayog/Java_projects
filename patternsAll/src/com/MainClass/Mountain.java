package com.MainClass;

import java.util.Scanner;

public class Mountain {
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height : ");
		int num = scan.nextInt();
		System.out.print("No. of peaks : ");
		int peak = scan.nextInt();
		for(int i = 1; i <=num;i++) {
			for (int m = 0 ;m <peak;m++) {
				for(int j = num; j > i;j--) {
					System.out.print(" ");
				}
				for(int k = 1;k < i*2;k ++) {
					System.out.print("*");
				}
				for(int k = num;k > i;k--) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
