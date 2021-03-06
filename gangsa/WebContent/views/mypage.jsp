<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>마이 페이지</title>
</head>
<body>

	마이페이지 입니다.
	<div>
	<form action="${pageContext.request.contextPath}/member/detail.do">
		<table style="border: 1px solid blue;width: 100%;height: 300px;background-color: yellow;
			 border-collapse: collapse;" >
				<tr class="row" style="border: 1px solid blue;height: 20%;">
					<th>이름</th>
					<th>아이디</th>
					<th>나이</th>
					<th>성별</th>
				</tr>
				<tr>
				<!-- JSTL 문법 -->
				<!-- ${name} 을 EL(Expression Language ) 이라고 하며 
					이렇게 표현하기 위해서는 JSTL.JAR 와 STANDARD.JAR 가 필요하다.	
				-->
					<td><%=request.getAttribute("name") %></td>
					<td><%=request.getAttribute("id") %></td>
					<td><%=request.getAttribute("age") %></td>
					<td><%=request.getAttribute("gender") %></td>
				</tr>
				
		</table>
	</form>
	</div>
	<div>
		<h3><a href="${pageContext.request.contextPath}/image/page.do">
			이미지 올리기 바로가기
		</a></h3>
	</div>
	<div>
		<label for="updatePwd"> 비밀번호 변경</label>
		<form action="${pageContext.request.contextPath }/member/updatePwd.do">
			<label for="pwd">수정할 비밀번호 :</label>
			<input type="password" id="pwd" name="pwd" />
			<input type="submit" value="전 송" />
		</form>
	</div>
	<div>
		<label for="updatePwd"> 내 정보 변경</label>
		<form action="${pageContext.request.contextPath }/member/updateInfo.do">
			
			<label for="name">이 름 :</label>
			<input type="text" id="name" name="name" />
			<label for="age">나 이 :</label>
			<input type="text" id="age" name="age" />
			<input type="submit" value="전 송" />
		</form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/member/remove.do" >회원탈퇴</a>
	</div>
</body>
</html>