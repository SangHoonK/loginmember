package com.smarthomepage.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.smarthomepage.login.LoginDAO;
import com.smarthomepage.util.DBmanager;

public class SearchPwdDAO {
	Connection conn; 
	Statement stmt; 
	ResultSet rs;   
	PreparedStatement pstmt;
	public SearchPwdDAO() {
		conn = DBmanager.getConnection();
	}
	private static SearchPwdDAO instance = new SearchPwdDAO();
	public static SearchPwdDAO getInstance(){
		return instance;
	}
	
	
	public String searchPwdByName(String name){
		String pwd = "";
		String sql = "select pwd from member where name = '"+name+"'";
		try{
			/*
			 * 쿼리문에서 변수를 ? 로 대체할 때는 pstmt 로 하고,
			 * 변수를 파라미터에서 바로 받을 때는 stmt 로 한다.
			 * */
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// "pwd" 는 DB에서 컬럼명과 일치해야 한다.
				pwd = rs.getString("pwd");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("SearchPwdDAO 에서 에러가 났음 !!");
		}
		return pwd;
	}
}
