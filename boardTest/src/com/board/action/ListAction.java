package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable { 
    	/*	BoardDao.java 파일로 이동됨
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
 
            String sql = "select * from board_test order by idx desc";
 
            rs = stmt.executeQuery(sql);
            ArrayList<Board> articleList = new ArrayList<Board>(); // Board형 배열형식으로 선언
            while (rs.next()) { 
                Board article = new Board(); // 데이터들을 담기위해 Board객체에 메모리를 할당하는 코드입니다. 
                article.setIdx(Integer.parseInt(rs.getString("idx"))); 
                article.setTitle(rs.getString("title")); 
                article.setWriter(rs.getString("writer")); 
                article.setRegdate(rs.getString("regdate")); 
                article.setCount(Integer.parseInt(rs.getString("count"))); 
                articleList.add(article); // 셋팅된 빈을 리스트에 추가합니다. 
            } 
            */
			int page=0;	//기본페이지는 0
			if(request.getParameter("page") != null){	//넘어온 파라미터가 있다면
				page = Integer.parseInt(request.getParameter("page"));	//해당 파라미터를 int형으로 캐스팅 후 page변수에 넣어줌
			}
		
        	ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(page);
            request.setAttribute("articleList", articleList); // 셋팅된 리스트를 뷰에 포워드합니다.
            request.setAttribute("page", page);	//페이지 번호를 뷰에서 보기위해 표시
            /*con.close();  //BoardDao.java 파일로 이동됨
        } catch (Exception e) { 
            System.err.println("Mysql Database Connection Something Problem."); 
            System.out.println(e.getMessage()); 
            e.printStackTrace(); 
        }
        */
		return "list.jsp";
	}
}













