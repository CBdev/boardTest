package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Member;
import com.board.controller.CommandAction;
import com.board.dao.MemberDao;

public class LoginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("馬馬馬馬馬馬馬馬馬馬馬馬馬馬");
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("亜蟹陥虞原原原原原");
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		System.out.println("id : "+member.getId());
		System.out.println("pwd : "+member.getPwd());
		int loginCheck = MemberDao.getInstance().login(member);
		//request.setAttribute("loginCheck", loginCheck);
		if(loginCheck==0)	return "loginForm.jsp"; 
		else	return "list.jsp";
		/*
		System.out.println("222222222222222");
		if(!id.equals(null) || !id.equals("")) {
			System.out.println("33333333333333");
		}
		else{
			System.out.println("44444444444444");
			request.setAttribute("id", null);
			request.setAttribute("pwd", null);
			return "loginForm.jsp";
		}
		*/
	}
}
