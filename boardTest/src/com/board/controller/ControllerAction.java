package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//@SuppressWarnings("serial")
public class ControllerAction extends HttpServlet {
	
	//@SuppressWarnings("rawtypes")
	private Map commandMap = new HashMap(); // ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����

	//Ŭ������ ����Ǹ� init�Լ��κ��� ��ɾ� ó���� ���� com/board/properties/Command ��ηκ��� properties������ �ҷ��µ� �̸� �ʿ� ����
	public void init(ServletConfig config) throws ServletException {
		// Common properties
		loadProperties("com/board/properties/Command");	
	}
	// properties ����
	//properties���Ͽ��� ������ ���������� ��Ű�������� �������� Ŭ����ȭ ��Ų�� ���ҽ� �����̶�� �ϴ� ��ü�� ����
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);//������ ���������� rb�� ����.
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while(actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			System.out.println("command : "+command);
			System.out.println("className : "+className);
			try {
				Class commandClass = Class.forName(className); // �ش� ���ڿ��� Ŭ������ �����
				Object commandInstance = commandClass.newInstance(); // �ش� Ŭ������ ��ü�� ����
				commandMap.put( command, commandInstance); // Map ��ü�� commandMap�� ��ü ����
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
	//get��û
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet go");
		requestPro(request, response);		//get��İ� post����� ��� requestPro�� ó��
	}
	//post��û
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost go");
		requestPro(request, response);
	}
	
	// ������� ��û(url)�� �м��ؼ� ���ҽ� ���鿡 ����� �ش� �׼� ��ü�� ����
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
