package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Board article = BoardDao.getInstance().getArticle(idx);
		String regip = request.getRemoteAddr();	//현재 조회를 요청한 사용자의 ip를 받음
		
		//System.out.println("regip : "+regip);
		//System.out.println("article.getRegip : "+article.getRegip());

		if(!regip.equals(article.getRegip())) {
			//System.out.println("!11111111111111111111111");
			int count = article.getCount();
			//System.out.println("count++ : "+(count++));
			article.setCount(++count);
			//System.out.println("article.count : "+article.getCount());
			BoardDao.getInstance().updateArticleCount(article);
		}
		request.setAttribute("url", "content.do?idx="+idx);
		return "redirect2.jsp";
	}
}
