<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>	
<%@ page import="com.board.bean.*" %>
<%@ page import="java.util.ArrayList" %>
<!-- jstl을 사용하기 위해 ,라이브러리 사용 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>본격! 게시판 - 게시글 리스트</title>		<!-- 윈도우 상단에 뜨는 내용입니다. -->
<style type="text/css">
	table, td, th
{
	border:1px solid green;
}
	th
{
	background-color:green;
	color:white;
}
</style>
</head>
<%
	try{
		String driverName = "com.mysql.jdbc.Driver";	
		String url = "jdbc:mysql://localhost:3306/board_test";
		String id = "root";
		String pwd = "1234";
		ResultSet rs = null;
	 
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url,id,pwd);
		out.println("Oracle Database Connection Success.");
	 
		Statement stmt = con.createStatement();			
		String sql = "select * from board_test order by idx desc";
		rs = stmt.executeQuery(sql);
		
		ArrayList<Board> articleList = new ArrayList<Board>();
		
		while(rs.next()){
			Board article = new Board();	//articleList 의 Board객체를 담기위해 Board article을 생성
			article.setIdx(rs.getInt("idx"));
			article.setTitle(rs.getString("title"));
			article.setWriter(rs.getString("writer"));
			article.setRegdate(rs.getString("regdate"));
			article.setCount(rs.getInt("count"));
			articleList.add(article); // 셋팅된 빈을 리스트에 추가
		}
		request.setAttribute("articleList", articleList);	//셋팅된 리스트를 뷰에 포워드
		con.close();
	} catch (Exception e) {
		out.println("Mysql Database Connection Something Problem. <hr>");
		out.println(e.getMessage());
		e.printStackTrace();
	}
%> 


<body>											<!-- HTML문서의 주 내용이 들어가는 부분입니다. -->
	<h1>게시글 리스트</h1>						<!-- 헤드라인 글씨를 표현하는 태그입니다. -->
	<table>										<!-- 표 형식의 데이터를 표현하는 태그입니다. -->
		<tr>									<!-- table태그 내에서 행을 정의할때 쓰는 태그입니다. -->
			<th>번호</th>						<!-- Table Header의 약자로 table태그 내에서 -->
			<th>제목</th>						<!-- 강조하고싶은 컬럼을 나타낼때 쓰는 태그입니다. -->
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${articleList }" var="article">
			<tr>
				<td>${article.idx }</td>	<!-- jstl의 표현식은 스크립트릿과 속성이 같아서 어디에 쓰나 우선됨 -->
				<td>${article.title }</td>
				<td>${article.writer }</td>
				<td>${article.regdate }</td>
				<td>${article.count }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="write.jsp">글쓰기</a>
</body>
</html>









