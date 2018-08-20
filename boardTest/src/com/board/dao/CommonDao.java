package com.board.dao;

import java.sql.*;

public class CommonDao { 
    //���������� ���� ���ӿ� ���õ� ���� �������� ����� �����մϴ�. 
    private final String driverName="com.mysql.jdbc.Driver"; 
    private final String url="jdbc:mysql://localhost:3306/board_test"; 
    private final String id="root"; 
    private final String pw="1234"; 
    //���ӿ� �ʿ��� ������ �����մϴ�.
    private Connection con=null; 
    private Statement stmt=null;     
 
    //db���������� ���ð�, �����Ŀ� SQL���� ����ϱ����� �ʿ��� 
    //statement��ü�� ��ȯ�ϴ� openConnection �޼ҵ带 �����մϴ�. 
    public Statement openConnection(){ 
        try{ 
            Class.forName(driverName); 
            con=DriverManager.getConnection(url,id,pw); 
            stmt=con.createStatement(); 
        }catch(Exception e){ 
            System.err.println("Mysql Database Connection Something Problem!!"); 
            System.out.println(e.getMessage()); 
            e.printStackTrace(); 
        } 
        return stmt; 
    }
    //������ �����ϱ����� closeConnection �޼ҵ带 �����մϴ�. 
    public void closeConnection(){ 
        try { 
            if(!con.isClosed())//������ �ʾ����� 
                con.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
}



