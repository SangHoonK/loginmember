package com.smarthomepage.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.smarthomepage.join.MemberBean;

import com.smarthomepage.util.DBmanager;

public class DetailMemberDAO {
	Connection conn; 
	Statement stmt; 
	ResultSet rs;   
	PreparedStatement pstmt;
	public DetailMemberDAO() {
		conn = DBmanager.getConnection();
	}
	private static DetailMemberDAO instance = new DetailMemberDAO();
	public static DetailMemberDAO getInstance(){
		return instance;
	}
	public MemberBean getMemberInfo(String id){
		
		String sql = "select * from member where id = '"+id+"'";
		MemberBean bean = new MemberBean();
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getString("age"));
				bean.setGender(rs.getString("gender"));
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DetailMemberDAO 에서 에러남!");
		}
		return bean;
	}
}
