package com.data;

public class CompGuessPro {
	public static void main(String[] args) {
		int pick = (int)(Math.random() * 100);
		int comp_guess;
		int min = 0;
		int max = 100;
		int count = 1;
		System.out.println("To Guess : "+pick);
		while(true) {
			comp_guess = (int)(min + Math.random()*(max-min));
			System.out.print(comp_guess + " ");
			if (comp_guess == pick) {
				System.out.println("\nGuessed it!! ");
				break;
			}else if(comp_guess > pick) {
				max = comp_guess -1;
			}else {
				min = comp_guess +1;
			}
			count++;
		}
		System.out.println("Took "+count+" number of guesses");
	}
}
