package com.StudentServices;

import com.StudentModel.StudentModel;

public class Service {
	public void printData(StudentModel model) {
		System.out.println("Printed from Service Class. ");
		System.out.println("First Name : "+model.getFname());
		System.out.println("Last Name : "+model.getLname());
		System.out.println("Phone Number : "+model.getPhone());
		System.out.println("Roll Number : "+model.getRoll());
		System.out.println("City Number : "+model.getCityNum());

	}
}
