package com.springmvcflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.springmvcflow.model.StudentModel;
import com.utils.DBConnection;

interface StudentDao {
	public void addStudent(StudentModel stud);
}

public class StudentDaoImpl implements StudentDao {

	public void addStudent(StudentModel stud) {
		// TODO Auto-generated method stub
		Connection con  = DBConnection.getConnection();
		String sql = "insert into student (name,email,profession) values(?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, stud.getName());
			ps.setString(2, stud.getEmail());
			ps.setString(3, stud.getProfession());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args)
	{
		StudentModel m=new StudentModel();
		m.setEmail("rehan@gmail.com");
		m.setName("Rehan Qureshi");
		m.setProfession("Soft Developer");
		StudentDaoImpl dao=new StudentDaoImpl(); 
		
		dao.addStudent(m);
			
			}

}
