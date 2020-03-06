package com.jdbc;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class StudentInfoViewService {
	
	public ResultSet getStudentRecord() {
		ResultSet result=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfinal", "root", "431501ak");
			
			CallableStatement cs = null;

			cs = con.prepareCall("{call STUDENT_INFO_VIEW_FINAL()}");
			cs.execute();
			result=cs.getResultSet();
		}catch(Exception ex) {
			System.out.println(ex.toString()+" from StudentInfoCrud");
		}
		
		return result;
		
	}

}
