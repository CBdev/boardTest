package com.board.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("euc-kr");
		
		MultipartRequest multi = null;
		int sizeLimit = 10*1024*1024;
		String savePath = request.getRealPath("/upload");
		try {
			multi = new MultipartRequest(request,savePath,sizeLimit,"euc-kr",new DefaultFileRenamePolicy());
		}catch(Exception e) {
			e.printStackTrace();
		}
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		int count = 0;
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		String regip = request.getRemoteAddr();
		

		if(title == "" ||title == null) System.out.println("title is null");
		
		if(writer == "" ||writer == null) System.out.println("writer is null");	
		//else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))System. out.println("no e-mail.");
		
		if(content == "" ||content == null)System. out.println("content is null");
		
		Board article = new Board();
		
		article.setTitle(title);
		article.setWriter(writer);
		article.setCount(count);
		article.setContent(content);
		article.setFilename(filename);
		article.setRegip(regip);
		BoardDao.getInstance().insertArticle(article);
		
		return "insert.jsp";
	}
}
