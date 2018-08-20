<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>	
<!-- jstl을 사용하기 위해 ,라이브러리 사용 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>본격! 게시판 - 게시글 조회</title>		
</head>
<%
	String idx = request.getParameter("idx");
	try {
		String driverName = "com.mysql.jdbc.Driver";	
		String url = "jdbc:mysql://localhost:3306/board_test";
		String id = "root";
		String pwd = "1234";
		ResultSet rs = null;
	 
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url,id,pwd);
		out.println("Mysql Database Connection Success.");
	 
		Statement stmt = con.createStatement();			
		String sql = "select * from board_test where idx = " + idx ;
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			request.setAttribute("idx",rs.getString("idx"));	
			request.setAttribute("title",rs.getString("title"));
			request.setAttribute("writer",rs.getString("writer"));
			request.setAttribute("regdate",rs.getString("regdate"));
			request.setAttribute("count",rs.getString("count"));
			request.setAttribute("content",rs.getString("content"));
			request.setAttribute("regip",rs.getString("regip"));
			request.setAttribute("filename",rs.getString("filename"));
		}
		con.close();
	}catch (Exception e) {
		out.println("Oracle Database Connection Something Problem. <hr>");
		out.println(e.getMessage());
		e.printStackTrace();
	}
%> 


<body>											
	<h1>게시글 조회</h1>						
	<table border="1">							<!-- border은 테두리를 표시하는 속성입니다. -->
		<tr>									
			<th>번호</th>						
			<td>${idx}</td>
			<th>작성자</th>
			<td>${writer}</td>
			<th>날짜</th>
			<td>${regdate }</td>
			<th>조회수</th>
			<td>${count }</td>
		</tr>
		<tr>
			<th colspan="2">제목</th>						<!-- colspan은 행병합 속성입니다. -->
			<td colspan="6">${title }</td>
		</tr>
		<tr>
			<th colspan="2">내용</th>						
			<td colspan="6">${content }</td>
		</tr>
	</table>
	<a href="delete.jsp?idx=${idx }">게시글삭제</a>
	<a href="index.jsp">목록으로</a> 
</body>
</html>