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
	public String loginProcess(String login_id, String login_password, HttpSession session) throws Exception {
		System.out.println("@[loginProc]" + login_id + "//" + login_password);
		
		
		int memberCount = memberMapper.getCntByLoginId(login_id);
		System.out.println("memberCOunt:"+memberCount);
		if(memberCount == 1) {
			MemberDomain member = memberMapper.getMemberByLoginId(login_id);
			if(member.getLogin_password().equals(login_password)) {
				session.setAttribute("login_id", member.getLogin_id());
				session.setAttribute("login_password", member.getLogin_password());
				session.setMaxInactiveInterval(60*60);
				logger.info("======== login success ========");
				return "success";
			} else {
				return "not_match_info";
			}
		} else if(memberCount==0) {
			logger.info("======== login fail ========");
			return "none";
		} else {
			logger.info("======== login fail:"+memberCount+" ========");
			return "fail";
		}

	}

	@Override
	public String logoutProcess(HttpSession session) throws Exception{
		String logoutStatus = "success";
		if(session == null) {
			logger.info("======== logout fail ========");
			logoutStatus = "fail";
		}else {
			logger.info("======== logout success ========");
			logoutStatus = "success";
			session.invalidate();
			
		}
		return logoutStatus;
	}

	@Override
	public int getLoginId(String login_id) throws Exception {
		return memberMapper.getCntByLoginId(login_id);
	}
	
	
}
