/* Made By AAYOG KOIRALA 
 * Nepal Flag using "*" patterns.
 */
package com.MainClass;

public class NepalMapBetter{
	public static void main(String[ ] args) {
		System.out.println("Map of Nepal : ");
		System.out.println("                                  * * * * *");
		for(int i = 0;i<52;i++) {
			for(int j = -1; j<91;j++) {
				if ((i ==20 && (j == 15 || j == 20)) || (i ==10 && (j == 25 || j == 9))||(i==30 &&(j == 30 || j== 40))) System.out.print("* ");
				else if ((i == 0 && (j == 12 || (j > 15 && j <22))) || (i == 1 && ( j ==11 || j ==12|| j == 13 ||(j > 14 && j < 25))) || (i == 2 && ((j > 8 && j < 28))) || (i == 3 && (j>8 && j <27)) || (i == 4 && (j > 7 && j < 26)) || (i == 5 && (j >7  && j < 28)) || (i == 6 && (j > 6 && j < 30)) || (i == 7 && (j > 5 && j < 33)) || (i == 8 && ((j > 5 && j < 35))) || (i == 9 && (j > 3 && j < 34)) || (i == 10 && (j > 2 && j < 37)) || (i == 11 && (j > 2 && j < 37)) || (i == 12 && (j > 1 && j < 45)) || (i == 13 && (j > 0 && j < 47)) || (i == 14 && (j > 0 && j <47)) || (i == 15 && ((j > 1 && j <48))) || (i == 16 && (j > -1 && j <48)) || (i == 17 && (j > -1 && j <49)) || (i == 18 && (j > -1 && j <49)) || (i == 19 && (j==56||j==55||(j > 2 && j <51))) || (i == 20 && (j > 2 && j < 57)) || (i == 21 && (j > 3 && j <57)) || (i == 22 && (j==63||(j > 6 && j <58))) || (i == 23 && ((j > 5 && j <64))&& j != 61 ) || (i == 24 && (j > 8 && j <65)) || (i == 25 && ((j>69&&j<75)  || (j > 10 && j <66))) || (i == 26 && ((j > 11 && j <76)&& j != 67 && j!=68)) || (i == 27 && (j > 12 && j <77)) || (i == 28 && (j > 16 && j <84)) || (i == 29 && (j > 14 && j <89)) || (i == 30 && (j > 16 && j <90)) || (i == 31 && (j > 17 && j <90)) || (i == 32 && (j > 19 && j <90)) || (i == 33 && (j > 23 && j <89)) || (i == 34 && (j > 25 && j <89)) || (i == 35 && (j > 26 && j <88)) || (i == 36 && (j > 32 && j <87)) || (i == 37 && (j > 32 && j <87)) || (i == 38 && ((j > 35 && j <86)&&j != 42)) || (i == 39 && ((j > 38 && j <88)&& j != 42 && j!=43 && j != 48)) || (i == 40 && (j > 48 && j <87)) || (i == 41 && (j > 48 && j <90)) || (i == 42 && (j > 50 && j <91)) || (i == 43 && (j > 50 && j <91)) || (i == 44 && (j > 52 && j <92)) || (i == 45 && (j >52 && j <92)) || (i == 46 && (j > 54 && j <89)) || (i == 47 && (j > 61 && j <89)) || (i == 48 && (j > 60 && j <89)) || (i == 49 && (j > 67 && j <88)) || (i == 50 && (j > 79 && j <88)) || (i ==51 && (j==86 || j ==87 )))System.out.print("* ");
				else System.out.print("  ");
			}
			System.out.println();
		}
	}
}
