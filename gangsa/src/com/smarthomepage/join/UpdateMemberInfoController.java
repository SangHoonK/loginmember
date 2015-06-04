package com.smarthomepage.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/updateInfo.do")
public class UpdateMemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		System.out.println("파라미터로 넘어온 NAME :" + name);
		String age = String.valueOf(request.getParameter("age"));
		System.out.println("파라미터로 넘어온 AGE :" + age);
		UpdateMemberInfoServiceImpl.getInstance().updateMemberInfo(id, name, age);
		System.out.println("수정 성공 !!");
	}

	
}
