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
    	/*	BoardDao.java ���Ϸ� �̵���
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
            ArrayList<Board> articleList = new ArrayList<Board>(); // Board�� �迭�������� ����
            while (rs.next()) { 
                Board article = new Board(); // �����͵��� ������� Board��ü�� �޸𸮸� �Ҵ��ϴ� �ڵ��Դϴ�. 
                article.setIdx(Integer.parseInt(rs.getString("idx"))); 
                article.setTitle(rs.getString("title")); 
                article.setWriter(rs.getString("writer")); 
                article.setRegdate(rs.getString("regdate")); 
                article.setCount(Integer.parseInt(rs.getString("count"))); 
                articleList.add(article); // ���õ� ���� ����Ʈ�� �߰��մϴ�. 
            } 
            */
			int page=0;	//�⺻�������� 0
			if(request.getParameter("page") != null){	//�Ѿ�� �Ķ���Ͱ� �ִٸ�
				page = Integer.parseInt(request.getParameter("page"));	//�ش� �Ķ���͸� int������ ĳ���� �� page������ �־���
			}
		
        	ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(page);
            request.setAttribute("articleList", articleList); // ���õ� ����Ʈ�� �信 �������մϴ�.
            request.setAttribute("page", page);	//������ ��ȣ�� �信�� �������� ǥ��
            /*con.close();  //BoardDao.java ���Ϸ� �̵���
        } catch (Exception e) { 
            System.err.println("Mysql Database Connection Something Problem."); 
            System.out.println(e.getMessage()); 
            e.printStackTrace(); 
        }
        */
		return "list.jsp";
	}
}













