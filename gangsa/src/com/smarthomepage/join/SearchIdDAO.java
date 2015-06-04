package com.smarthomepage.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.smarthomepage.util.DBmanager;

public class SearchIdDAO {
	Connection conn; // 자바에서 멤버필드의 멤버변수는 초기화
	Statement stmt; // 하지 않아도 된다.단 지역변수라면
	ResultSet rs;   // 초기화 해야 한다.
	PreparedStatement pstmt;

	private SearchIdDAO() {
		conn = DBmanager.getConnection();
	}
	private static SearchIdDAO instance = new SearchIdDAO();
	public static SearchIdDAO getInstance(){
		return instance;
	}
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	public String searchId(String name){
		System.out.println("DAO 로 넘어온 이름 :" + name);
		String id = "";
		String sql = "select id from member where name = '"+name+"'";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getString("id");
				System.out.println("DAO 에서 받은 ID :"+ id);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("SearchIdDAO 에서 에러발생 !!");
		}
		return id;
	}
}













