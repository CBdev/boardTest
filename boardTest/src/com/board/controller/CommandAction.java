package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//명령어에서 찾은 클래스를 클래스화 시키기 위한 것
public interface CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws Throwable;
}
