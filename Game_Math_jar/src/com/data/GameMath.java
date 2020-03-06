package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GameMath {
	public static void main(String[] args) throws Exception {
		display("Welcome to the Maths game. ");
		createTable();
		String choice;
		int choosen = 0;
		do {
			String user_name = getInput("Enter your name : ");
			String difficulty = getInput("Difficulty level :\n1) Easy\n2) Medium\n3) Difficult");
			int hard = Integer.parseInt(difficulty);
			if (difficulty.equals(""))hard =1;
			int level=0;
			if(hard==1)level=10;
			else if (hard==2)level = 50;
			else level = 500;
			String questionType = getInput("What type of questions you want?\n1) Addition\n2) Subtraction\n3) Multiplication");
			int type = Integer.parseInt(questionType);
			String sign ="";
			if(type==3)sign = "X";
			else if(type==2)sign="-";
			else sign = "+";
			
			playGame(user_name,level,sign);
			displayData(sign);
			choice = getInput("Want to play again? 1) Yes or 2) No");
			try {
				choosen = Integer.parseInt(choice);
			}catch(Exception e) {
				System.out.println(e);
			}
			if (choice.equals(""))choosen=1;
		}while(choosen == 1);
		
	}
	private static void displayData(String type) {
		String toPrint="";
		toPrint += "Scores for the type : '"+type+"'\n";
		try {
			Connection conn = getConnection();
			String sql = "SELECT `NAME`,`PLAYER_TIME`,`CORRECT_ANS` FROM `game_maths` WHERE `GAME_TYPE` = '"+type+"' ORDER BY `CORRECT_ANS` DESC, `PLAYER_TIME` ASC";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			toPrint +="Name          Time        Correct\n";
			String name,time,ans;
			while(result.next()) {
				name=result.getString("NAME");
				time=result.getString("PLAYER_TIME");
				ans=result.getString("CORRECT_ANS");
				toPrint += name;
				for(int i = 0;i < (15-name.length());i++) {
					toPrint +=" "; 
				}
				toPrint += time;
				for(int i = 0;i <10;i++) {
					toPrint +=" "; 
				}
				toPrint += ans;
				toPrint+="\n";
			}
			display(toPrint);
			System.out.println("All records have been selected.");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private static void insertTable(String user_name, int timeTaken,int correct,String type) {
		final String var1 = user_name;
		final int charTime = timeTaken;
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO `game_maths` (`NAME`,`PLAYER_TIME`,`CORRECT_ANS`,`GAME_TYPE`) VALUES('"+var1+"','"+charTime+"','"+correct+"','"+type+"');";
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
			String sql = "CREATE TABLE IF NOT EXISTS game_maths(`NAME` varchar(255), `PLAYER_TIME` int,`CORRECT_ANS` int,`GAME_TYPE` varchar(255));";
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
	public static void display(String prompt) {
		JOptionPane.showMessageDialog(null, prompt);
	}
	public static String getInput(String prompt) {
		String ans = JOptionPane.showInputDialog(prompt);
		return ans;
	}	
	public static void playGame(String name,int lev,String sign) {
		int count = 0;
		long startTime = System.currentTimeMillis();
		String type = sign; 
		for(int i =0;i<10;i++) {
			int num1 = (int) (Math.random()*lev+1);
			int num2 = (int) (Math.random()*lev+1);
			int result = 0;
			String ans = getInput(num1+" "+sign+" "+num2);
			int gotAns;
			try {
				gotAns = Integer.parseInt(ans);
			}catch(Exception ex) {
				gotAns = 0;
			}
			if(ans.equals(""))gotAns =0;
			if (sign =="+")result = num1 + num2;
			else if(sign=="-")result = num1-num2;
			else result = num1*num2;
			if(gotAns == result)count++;
		}
		long endTime = System.currentTimeMillis();
		int timeTaken = (int)(endTime-startTime)/1000;
		display(count +" correct answers in "+timeTaken+" seconds.");
		insertTable(name,timeTaken,count,type);
	}
	
}
