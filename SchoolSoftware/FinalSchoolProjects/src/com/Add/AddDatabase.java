package com.Add;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AddDatabase {
	public boolean insertExamInfo(AddSubjectModel model) {
		boolean status = false;
		String mode = "I";
		try {
			Connection con = getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{call ADD_SUBJECT_CRUD(?,?,?,?,?,?,?,?)}");
			cs.setString(1, mode);
			cs.setString(2, model.getExam_name());
			cs.setInt(3, model.get_class() );
			cs.setString(4, model.getSubject());
			cs.setInt(5, model.getTheory_FM());
			cs.setInt(6, model.getTheory_PM());
			cs.setInt(7, model.getPractical_FM());
			cs.setInt(8, model.getTheory_PM());
			
			boolean rslt=cs.execute();
			System.out.println(rslt);
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
	public ResultSet selectRow(String column_name,String table_name, String column_search,String variable_search) {
		try {
			Connection con = getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{CALL SUBJECT_EXAM_VIEW_ALL(?,?,?,?,?,?,?)}");
			cs.setString(1, column_name);
			cs.setString(2, table_name);
			cs.setString(3, column_search);
			cs.setString(4, variable_search);
			cs.setString(5, "");
			cs.setString(6, "");
			cs.setString(7, "");
			ResultSet result = cs.executeQuery();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfinal", "root",
					"431501ak");
			return con;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet selectRowWithTwoColumn(String column_name,String second_column_name,String table_name, String column_search,String variable_search,String second_column_search,String second_variable_search) {
		try {
			Connection con = getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{CALL SUBJECT_EXAM_VIEW_ALL(?,?,?,?,?,?,?)}");
			cs.setString(1, column_name);
			cs.setString(2, table_name);
			cs.setString(3, column_search);
			cs.setString(4, variable_search);
			cs.setString(5, second_column_search);
			cs.setString(6, second_variable_search);
			cs.setString(7, second_column_name);
			ResultSet result = cs.executeQuery();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getRollNumber(int v_Class, String subject ) {
		try {
			Connection con = getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{CALL GET_ROLL_NUMBER(?,?)}");
			System.out.println(cs.toString());
			cs.setInt(1, v_Class);
			cs.setString(2, subject);
			ResultSet result = cs.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

