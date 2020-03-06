package com.data;

import java.util.Scanner;

public class ComputerGuess {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a number between 0-100, let the computer guess what it is.");
		System.out.print("Press enter to start.");
		scan.nextLine();
		int guessed;
		int high =100;
		int low = 0;
		int count = 1;
		while(true) {
			guessed = low + (int)(Math.random() * ((high - low) + 1));
			System.out.println("Is this your number? : "+guessed);
			System.out.println("Option\n1)Correct\n2)Lower\n3)Higher.");
			int user_choice = scan.nextInt();
			if (user_choice==1) {
				System.out.println("Yay! guessed it.");
				break;
			}else if(user_choice==2) {
				high = guessed-1;
			}else {
				low = guessed+1;
			}
			count++;
		}
		System.out.println("It took me "+count+" guesses.");
	}
}
