package com.data;

public class Maile {
	public static void main(String[] args) {
		for (int i = 0;i<20;i++) {
			if (i==0 || i == 19) {
				System.out.print("+");
			}else {
				System.out.print("--");
			}
		}
		System.out.println();
		for(int i = 0;i<9;i++) {
			for (int j = 0;j<20;j++) {
				if(j ==0 || j ==19) {
					System.out.print("+");
				}else if((i>0&&i<4)&&(j >14 && j < 18) ){
					System.out.print("##");	
				}else if(i==6&&j==5) {
					System.out.print("Aayog  Koirala");
				}else if(i==7&&j==6) {
					System.out.print("Babarmahal,Ktm");
				}else if(i==8&&j==7) {
					System.out.print("Bagmati, 44600");
				}else if ((i>5&&i<9)&&(j>4&&j<12)){
					continue;
				}else {
				System.out.print("  ");
				}
			}
			System.out.println();
		}
		for (int i = 0;i<20;i++) {
			if (i==0 || i == 19) {
				System.out.print("+");
			}else {
				System.out.print("--");
			}
		}
	}
}
