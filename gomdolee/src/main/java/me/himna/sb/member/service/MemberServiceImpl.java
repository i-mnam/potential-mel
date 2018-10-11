package me.himna.sb.member.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.himna.sb.member.dao.MemberDao;
import me.himna.sb.member.domain.MemberDomain;

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	//Field memberMapper in me.himna.sb.member.service.MemberServiceImpl 
	//required a bean of type 'me.himna.sb.member.dao.MemberDao' that could not be found.
	@Autowired
	MemberDao memberMapper;
	
	@Override
	public int joinProcess(MemberDomain member) throws Exception {
		logger.info("======== member join process ========");
		return memberMapper.memberJoin(member);		
	}

	@Override
	public String loginProcess(String login_id, String login_password, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logoutProcess(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginId(String login_id) throws Exception {
		return memberMapper.getLoginId(login_id);
	}
	
	
}
