package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		createTable();
		get();
	}
	public static void createTable() throws Exception{
		Scanner scan = new Scanner(System.in);
		try {
			Connection conn = getConnection();
			String sql = "CREATE TABLE IF NOT EXISTS MY_TABLE(C_ID int NOT NULL AUTO_INCREMENT, NAME varchar(255), AGE int,PRIMARY KEY(C_ID));";
			PreparedStatement create = conn.prepareStatement(sql);
			create.executeUpdate();

			
		}catch(Exception e) {System.out.println(e);}
		finally{
			System.out.println("Function has been completed.");
		}
	}
	public static void post() throws Exception{
		final String var1 = "Harry";
		final int age = 19;
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO MY_TABLE(NAME,AGE) VALUES('"+var1+"',"+age+")";
			PreparedStatement posted = conn.prepareStatement(sql);
			posted.executeUpdate();
			System.out.println("Insert completed");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static ArrayList<String> get() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT NAME, AGE FROM MY_TABLE WHERE 1 ORDER BY AGE");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("Name"));
				System.out.print(" ");
				System.out.println(result.getString("Age"));
				array.add(result.getString("Name"));
			}
			System.out.println("All records have been selected.");
			return array;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url  = "jdbc:mysql://localhost:3306/nepdroid_class";
			String user = "root";
			String password = "";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
