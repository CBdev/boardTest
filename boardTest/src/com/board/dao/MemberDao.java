package com.board.dao;

import java.sql.SQLException;

import com.board.beans.Member;

public class MemberDao extends CommonDao{
	public static MemberDao getInstance() {
		MemberDao instance = new MemberDao();
		instance.SetDB();
		return instance;
	}

	public int login(Member member) throws SQLException {
		System.out.println("member.getId : "+member.getId());
		int loginCheck= ((Integer) GetDB().queryForObject("login", member)).intValue();
		//System.out.println("loginCheck : "+loginCheck);
		return loginCheck;
	}
}
