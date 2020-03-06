package com.mainClass;

import java.util.Scanner;

import com.StudentModel.StudentModel;
import com.StudentServices.Service;

public class StudentMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentModel model = new StudentModel();
		System.out.print("Enter your first name : ");
		model.setFname(scan.next());
		System.out.print("Enter your last name : ");
		model.setLname(scan.next());
		System.out.print("Enter your phone no. : ");
		model.setPhone(scan.next());
		System.out.print("Enter your roll no. : ");
		model.setRoll(scan.nextInt());
		System.out.print("Enter your city no. : ");
		model.setCityNum(scan.nextInt());
		Service serv = new Service();
		serv.printData(model);
	}
}
