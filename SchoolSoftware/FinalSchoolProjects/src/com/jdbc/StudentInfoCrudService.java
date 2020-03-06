package com.jdbc;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.jdbc.Connection;
import com.studentModel.Student_Crud_Model;

public class StudentInfoCrudService {
	

	public boolean insertData(Student_Crud_Model model) {
		boolean status = false;
		String mode="I";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfinal", "root",
					"431501ak");

			CallableStatement cs = null;

			cs = con.prepareCall("{call STUDENT_INFO_CRUD_FINAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, mode);
			cs.setInt(2, -1);
			cs.setString(3, model.getFirstName());
			cs.setString(4, model.getMiddleName());
			cs.setString(5, model.getLastName());
			cs.setBinaryStream(6, model.getImage());
			cs.setString(7, model.getPhone());
			cs.setString(8, model.getAddress());
			cs.setString(9, model.getEmail());
			cs.setInt(10, model.getClash());
			cs.setInt(11, model.getRoll());
			cs.setString(12, model.getCreatedBy());
			cs.setString(13, model.getAdmitionDate());
			cs.setString(14, "");
			cs.setString(15,"");
			cs.setString(16, "");
			cs.setString(17, model.getParent());
			cs.registerOutParameter(2, Types.INTEGER);
			
			boolean rslt=cs.execute();
			System.out.println(rslt);
			status = true;
		} catch (Exception ex) {
			System.out.println(ex.toString() + "from StudentInfoCrudServices");
		}
		return status;
	}

}
