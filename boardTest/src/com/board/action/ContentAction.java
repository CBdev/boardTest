package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Board article = BoardDao.getInstance().getArticle(idx); 
		request.setAttribute("article", article);
		
		/*
		String idx = request.getParameter("idx");
		try {
			String driverName = "com.mysql.jdbc.Driver";	
			String url = "jdbc:mysql://localhost:3306/board_test";
			String id = "root";
			String pwd = "1234";
			ResultSet rs = null;
		 
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,id,pwd);
			System.out.println("Mysql Database Connection Success.");
		 
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
			System.out.println("Mysql Database Connection Something Problem. <hr>");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		*/
		return "content.jsp";
	}
}
