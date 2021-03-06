package me.himna.sb.member.service;

import javax.servlet.http.HttpSession;


import me.himna.sb.member.domain.MemberDomain;

public interface MemberService {
	public String loginProcess(String login_id, String login_password, HttpSession session) throws Exception;
	public String logoutProcess(HttpSession session) throws Exception;
	public int joinProcess(MemberDomain member) throws Exception;
	public int getLoginId(String login_id) throws Exception;
}
