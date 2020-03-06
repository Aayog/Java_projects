package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MathsGame {
	public static void main(String[] args) throws Exception {
		String flag;
		JOptionPane.showMessageDialog(null, "Welcome to the Math game.\n\nClick OK to continue.");
		createTable();
		do {
			String name = JOptionPane.showInputDialog(null,"Enter your name : ",JOptionPane.QUESTION_MESSAGE);
			int i=0;
			int count =0;
			String choice = JOptionPane.showInputDialog(null,"Choose question type:\n1)Addition\n2)Subtraction\n3)Multiplication",JOptionPane.QUESTION_MESSAGE);
			int choice_made= Integer.parseInt(choice);
			String sign="+";
			
			if(choice_made ==2) {
				sign = "-";
			}else if(choice_made==1) {
				sign = "+";
			}else
				sign = "X";
			
			String game_option = JOptionPane.showInputDialog(null,"Difficulty level:\n1)Easy\n2)Medium\n3)Difficult",JOptionPane.QUESTION_MESSAGE);
			int game_level = Integer.parseInt(game_option);
			int lev = 0;
			if(game_level == 1)lev = 10;
			else if(game_level==2)lev = 50;
			else lev = 500;
			JOptionPane.showMessageDialog(null, "Click OK to start game");
			long startTime = System.currentTimeMillis();
			
			while(i<10) {
				int num1 = (int) (Math.random()*lev+1);
				int num2 = (int) (Math.random()*lev+1);
				int result=0;
				String ans = "";
				ans = JOptionPane.showInputDialog(null,num1+sign+num2,"Find the answer.",JOptionPane.QUESTION_MESSAGE);
				System.out.println(ans);
				if(ans == "break")break;
				if (ans != "")result = Integer.parseInt(ans);
				int calc = num1 +num2;
				if (sign == "-")calc = num1-num2;
				else if (sign =="X")calc = num1*num2;
				else calc = num1+num2;
				if (result == calc)count +=1;
				i++;
			}
			long endTime = System.currentTimeMillis();
			int timeTaken = (int) ((endTime-startTime)/1000);
			post(name,timeTaken);
			JOptionPane.showMessageDialog(null,count+" correct answers and time taken is "+timeTaken +" seconds.");
			String exitChoice = JOptionPane.showInputDialog("Do you want to play again or quit?\n1)Play Again\n2)Quit");
			int sel = Integer.parseInt(exitChoice);
			flag = (sel == 1)? "true":"false";
			get();
		}while(flag == "true");
		JOptionPane.showMessageDialog(null, "Thanks For Playing....");
	}
	public static void get() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM `maths_game` WHERE 1 ORDER BY `PLAYER_TIME` ASC");
			ResultSet result = statement.executeQuery();
			String toPrint ="Name    Time\n";
			while(result.next()) {
				toPrint+=result.getString("NAME");
				toPrint+="  ";
				toPrint+=result.getString("PLAYER_TIME");
				toPrint+="\n";
			}
			JOptionPane.showMessageDialog(null, toPrint);
			System.out.println("All records have been selected.");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void post(String name,int time) throws Exception{
		final String var1 = name;
		final int charTime = time;
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO `maths_game` (`NAME`,`PLAYER_TIME`) VALUES('"+var1+"','"+charTime+"');";
			//INSERT INTO `maths_game` (`NAME`, `PLAYER_TIME`) VALUES ('Ram', '10');
			System.out.println(sql);
			PreparedStatement posted = conn.prepareStatement(sql);
			posted.executeUpdate();
			System.out.println("Insert completed");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void createTable() throws Exception{
		Scanner scan = new Scanner(System.in);
		try {
			Connection conn = getConnection();
			String sql = "CREATE TABLE IF NOT EXISTS maths_game(`NAME` varchar(255), `PLAYER_TIME` int);";
			PreparedStatement create = conn.prepareStatement(sql);
			create.executeUpdate();

			
		}catch(Exception e) {System.out.println(e);}
		finally{
			System.out.println("Function has been completed.");
		}
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
