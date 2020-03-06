package com.MainClass;

import java.util.Scanner;

public class ShoeNew {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 10;
		for(int k = 0; ((num < 0 || num > 8) || num == 7 ); k++) {
			System.out.print("No. of stripes :(0-8) ");
			num = scan.nextInt();
		}
		System.out.print(" ");
		for(int i = 0;i<10;i++) {
			System.out.print("_");
		}
		System.out.println();
		String begin = "|";
		String end = "|";
		int space = 11;
		for(int i = 0;i <9;i++) {
			if(i==0) {
				begin = "/";
				end = "\\";
			}else {
				begin ="|";
				end = "|";
			}
			if( i < 6)end = "\\";
			System.out.print(begin);
			if(i ==4)System.out.print("    ");
			if (i > 4)space = 26;
			for(int j = 0;j<space;j++) {
				System.out.print(" ");
			}
			if (i > 0 && i < 4) {
				for(int x = 0;x<i;x++) {
					System.out.print(" ");
				}
			}
			if(i != 4){
				System.out.println(end);
			}else {
				System.out.print(end);
				for(int k = 0; k < 7;k++) {
					if(k == 4)System.out.print("Oo");
					System.out.print("_");
				}
				System.out.println();
			}
		}
		System.out.print("\\");
		int stripe = num +1;
		int interval = 26 / stripe;
		int[] inters = new int[stripe];
		if (stripe > 3)interval -= 1;
		for(int i = 1; i <stripe;i++) {
			inters[i] = (interval*i);
		}
		int total = 28;
		if(num == 7)total = 30;
		for(int i = 0;i <(total-(2*stripe));i++) {
			for(int _inters : inters) {
				if (_inters == i && i != 0) {
					System.out.print("/\\");
					continue;
				}
			}
			System.out.print("_");
		}
		System.out.println("/");
	}
}
