package com.MainClass;

import java.util.Scanner;

public class Mix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What character do you want to generate pattern of ? : ");
		String pattern = scan.next();
		int len = pattern.length();
		for(int i = 0; i < 5;i++) {
			for(int j = 5*len;j > i*len;j--) {
				System.out.print(" ");
			}
			for(int k = 0 ; k <=i ; k ++) {
				System.out.print(pattern);
			}
			for(int l=0;l<i;l++) {
				System.out.print(pattern);
			}
			System.out.println();
		}
		for(int i = 0;i<=5;i++) {
			for(int j =0; j < i*len;j++) {
				System.out.print(" ");
			}
			for(int k = 5;k >=i;k--) {
				System.out.print(pattern);
			}
			for(int l =5;l >i;l--) {
				System.out.print(pattern);
			}
			System.out.println();
		}
	}

}
