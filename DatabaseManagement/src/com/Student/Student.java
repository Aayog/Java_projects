package com.Student;

import java.util.Scanner;

import com.Service.Service;
import com.StudentModel.Model;

public class Student {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean status;
		do {
			status = mainMenu();
			
		}while(status);
	}

	private static boolean mainMenu() {
		Service serv = new Service();
		System.out.println("Main menu : ");
		System.out.println("Press 'V' to view data.");
		System.out.println("Press 'I' to insert new row.");
		System.out.println("Press 'U' to update row.");
		System.out.println("Press 'D' to delete row.");
		System.out.println("Press 'Q' to quit.");
		String choice = scan.next();
		if(choice.equals("Q")) {
			System.out.println("Thanks for using.");
			return false;
		}else if(choice.equals("V")) {
			serv.displayData();
		}else if(choice.equals("I")) {
			serv.displayData();
			Model model = insertAsk();
			serv.insertData(model);
			serv.displayData();
		}else if(choice.equals("U")) {
			serv.displayData();
			System.out.println("Which row do you want to update? Enter its SN : ");
			int SN = scan.nextInt();
			Model model = insertAsk();
			serv.updateRow(SN,model);
			serv.displayData();
		}else if(choice.equals("D")) {
			serv.displayData();
			System.out.println("Which row do you want to delete? Enter its SN : ");
			int SN = scan.nextInt();
			serv.deleteRow(SN);
			serv.displayData();
		}else {
			System.out.println("Invalid choice! Try again.");
		}
		
		return true;
	}

	private static Model insertAsk() {
		Model model = new Model();
		System.out.print("Enter first name : ");
		model.setFname(scan.next());
		System.out.print("Enter last name : ");
		model.setLname(scan.next());
		System.out.print("Enter your batch : ");
		model.setBatch(scan.nextInt());
		System.out.print("Enter your monthly fee : ");
		model.setFee(scan.nextInt());
		System.out.print("Enter your semester : ");
		model.setSemester(scan.nextInt());
		System.out.print("Enter shift : ");
		model.setShift(scan.next());
		System.out.print("Enter phone number : ");
		model.setPhone(scan.next());
		System.out.print("Enter address : ");
		model.setAddress(scan.next());
		return model;
	}
}
