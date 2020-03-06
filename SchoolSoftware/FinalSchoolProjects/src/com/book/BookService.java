package com.book;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.jdbc.Connection;

public class BookService {
	
	public boolean jdbcHandle(SubjectModel model, String mode) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfinal", "root",
					"431501ak");

			CallableStatement cs = null;

			cs = con.prepareCall("{call SUBJECT_CRUD(?,?,?,?)}");
			cs.setString(1, mode);
			cs.setString(2, model.getSubject_Name());
			cs.setInt(3, model.get_class());
			if (mode.equals("I")) cs.setInt(4, -1);
			else cs.setInt(4, model.getSubject_ID());
			cs.registerOutParameter(4, Types.INTEGER);
			
			boolean rslt=cs.execute();
			System.out.println(rslt);
			status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
}
