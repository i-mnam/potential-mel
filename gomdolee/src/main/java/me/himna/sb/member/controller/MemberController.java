package me.himna.sb.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.himna.sb.member.domain.MemberDomain;
import me.himna.sb.member.service.MemberService;

//@RequestMapping(value="/member-")
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	/**
	 * 회원가입 페이지 이동처리 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/member-register", method=RequestMethod.GET)
	public String register(HttpSession session, Model model) {
		//if(session.getAttribute("id") != null){return "index";}

		return "fragments/member/register";
	}
	
	/**
	 * 회원가입 등록 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/member-join", method=RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		String result = "fail";
		MemberDomain member = new MemberDomain();
		member.setLogin_id(request.getParameter("login_id"));
		member.setLogin_password(request.getParameter("login_password"));
		if(member.getLogin_id()!=null && member.getLogin_password()!=null) {
			if(memberService.joinProcess(member) == 1) { // 서비스와 연동하면서 예외처리가 반드시 필요한가보다.
				result = "success";
			}
		}
		return result;
	}
	/**
	 * ID CHECK 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/member-idcheck", method=RequestMethod.GET)
	public @ResponseBody String idCheck(HttpServletRequest request) throws Exception {
		String result = "fail";
		if(memberService.getLoginId(request.getParameter("login_id")) == 0) {
			result =  "success";
		} 
		return result;		
	}
		
}
