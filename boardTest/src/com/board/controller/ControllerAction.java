package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//@SuppressWarnings("serial")
public class ControllerAction extends HttpServlet {
	
	//@SuppressWarnings("rawtypes")
	private Map commandMap = new HashMap(); // 명령어와 명령어 처리 클래스를 쌍으로 저장

	//클래스가 실행되면 init함수로부터 명령어 처리를 위해 com/board/properties/Command 경로로부터 properties파일을 불러온뒤 이를 맵에 저장
	public void init(ServletConfig config) throws ServletException {
		// Common properties
		loadProperties("com/board/properties/Command");	
	}
	// properties 설정
	//properties파일에서 가져온 맵핑정보의 패키지정보를 바탕으로 클래스화 시킨뒤 리소스 번들이라고 하는 객체에 저장
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);//누구를 실행할지를 rb에 저장.
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while(actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			System.out.println("command : "+command);
			System.out.println("className : "+className);
			try {
				Class commandClass = Class.forName(className); // 해당 문자열을 클래스로 만든다
				Object commandInstance = commandClass.newInstance(); // 해당 클래스의 객체를 생성
				commandMap.put( command, commandInstance); // Map 객체인 commandMap에 객체 저장
			} catch(ClassNotFoundException e) {
				continue; // error
				//throw new ServletException(e);
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}				
	}
	//get요청
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet go");
		requestPro(request, response);		//get방식과 post방식을 모두 requestPro로 처리
	}
	//post요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost go");
		requestPro(request, response);
	}
	
	// 사용자의 요청(url)을 분석해서 리소스 번들에 저장된 해당 액션 객체를 실행
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			String command = request.getRequestURI();
			//System.out.println("2222222222222222222222222222");
			if ( command.indexOf(request.getContextPath()) == 0 ) {
				//System.out.println("3333333333333333333333333333");
				command = command.substring(request.getContextPath().length());
				//System.out.println("444444444444444444444444");
			}
			//System.out.println("55555555555555555555");
			//System.out.println("command : "+command);
			
			
			com = (CommandAction)commandMap.get(command);
			
			
			//System.out.println("com : "+com);
			if ( com == null ) {
				System.out.println("not found : " + command);
				return;
			}
			//System.out.println("77777777777777777777777");
			view = com.requestPro(request, response);
			if ( view == null ) {
				return; 
			}
			System.out.println("command : "+command);
			System.out.println("com : "+com);
			System.out.println("view : "+view);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		if ( view == null ) 
			return;

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
