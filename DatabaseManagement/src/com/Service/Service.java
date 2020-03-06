package com.Service;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.StudentModel.Model;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Service {

	public void displayData() {
		try {
			Connection con = getConnection();
			String sql = "SELECT * FROM nepdroid_class";
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			displayTable();
			System.out.format("| %-5s | %-15s | %-15s | %-5s | %-10s | %-8s | %-10s | %-15s | %-15s |\n","SN","FIRST_NAME","LAST_NAME","BATCH","FEE","SEMESTER","SHIFT","PHONE","ADDRESS");
			while(result.next()) {
				displayTable();
				System.out.format("| %-5d | %-15s | %-15s | %-5d | %-10d | %-8d | %-10s | %-15s | %-15s |\n",result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8),result.getString(9));
			}displayTable();

			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void displayTable() {
		System.out.print("|");
		for(int i = 0;i<124;i++) {
			System.out.print("-");
		}System.out.println("|");
	}

	private Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nepdroid_class","root","");
			return con;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
		return null;
	}

	public void insertData(Model model) {
		try {
			Connection con = getConnection();
			String sql = "INSERT INTO nepdroid_class(FIRST_NAME,LAST_NAME,BATCH,MONTHLY_FEE,SEMESTER,SHIFT,PHONE,ADDRESS)VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, model.getFname());
			pstm.setString(2, model.getLname());
			pstm.setInt(3, model.getBatch());
			pstm.setInt(4, model.getFee());
			pstm.setInt(5, model.getSemester());
			pstm.setString(6, model.getShift());
			pstm.setString(7, model.getPhone());
			pstm.setString(8, model.getAddress());
			pstm.execute();
			System.out.println("Successfully inserted data.");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void updateRow(int sN, Model model) {
		try {
			Connection con = getConnection();
			String sql = "UPDATE nepdroid_class SET FIRST_NAME = ? ,LAST_NAME = ?, BATCH =? ,MONTHLY_FEE= ? ,SEMESTER = ? , SHIFT = ?,PHONE = ?,ADDRESS= ? WHERE SN = ?";
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, model.getFname());
			pstm.setString(2, model.getLname());
			pstm.setInt(3, model.getBatch());
			pstm.setInt(4, model.getFee());
			pstm.setInt(5, model.getSemester());
			pstm.setString(6, model.getShift());
			pstm.setString(7, model.getPhone());
			pstm.setString(8, model.getAddress());
			pstm.setInt(9, sN);
			pstm.execute();
			System.out.println("Succesfully updated");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void deleteRow(int sN) {
		try {
			Connection con = getConnection();
			String sql = "DELETE FROM nepdroid_class WHERE SN = ?";
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setInt(1, sN);
			pstm.execute();
			System.out.println("Successfully deleted row");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
