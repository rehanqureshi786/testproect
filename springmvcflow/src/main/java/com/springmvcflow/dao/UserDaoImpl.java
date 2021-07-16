package com.springmvcflow.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvcflow.model.User;
import com.utils.DBConnection;
import com.utils.UserUtils;

interface UserDao
{
	public boolean addUser(User user);
	public List<User> getUser();
}
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private User user;
	String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	Connection con=DBConnection.getConnection();
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean i=false;
	String addUser=UserUtils.ADD_USER;
	try(CallableStatement cstmt=con.prepareCall(addUser))
	{
	cstmt.setString(1, user.getFname());
	cstmt.setString(2, user.getLname());
	cstmt.setString(3, user.getEmail());
	cstmt.setLong(4, user.getMobile());
	cstmt.setString(5, user.getUsername());
	cstmt.setString(6, user.getPassword());
	cstmt.setString(7, user.getAddress1());
	cstmt.setString(8, user.getAddress2());
	cstmt.setString(9, user.getCity());
	cstmt.setString(10, user.getState());
	cstmt.setString(11, user.getGender());
	i=cstmt.execute();
	System.out.println("User Data Inserted Success!!!");
	return i;
	}
	catch (SQLException e) {
		// TODO: handle exception
		setErrorMessage(e.getMessage());
		System.out.println("User Data Not Inserted!!!!"+errorMessage);
	}
	return i;
	}
		
	
	public List<User> getUser() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql=UserUtils.GET_USER;
		List<User> list = new ArrayList<User>(); 
		try(CallableStatement cst=con.prepareCall(sql)) {
			ResultSet rs=cst.executeQuery();
			while(rs.next())
			{
				User users=new User();
				users.setFname(rs.getString(1));
				users.setLname(rs.getString(2));
				users.setEmail(rs.getString(3));
				users.setMobile(rs.getLong(4));
				users.setUsername(rs.getString(5));
				users.setPassword(rs.getString(6));
				users.setAddress1(rs.getString(7));
				users.setAddress2(rs.getString(8));
				users.setCity(rs.getString(9));
				users.setState(rs.getString(10));
				users.setGender(rs.getString(11));
				list.add(users);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	
}
