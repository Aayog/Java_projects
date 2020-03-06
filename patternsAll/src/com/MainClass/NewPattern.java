package com.MainClass;

import java.util.Scanner;

public class NewPattern extends PattSpace{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Height  : ");
		int num = scan.nextInt();
		for(int i = 1; i <=num ; i++) {
			System.out.println(sp(num-i)+pa(i));
		}
		for(int i = 0; i < num ;i++) {
			System.out.print(sp(num));
			System.out.println(pa(num-i));
		}
	}
	
}
