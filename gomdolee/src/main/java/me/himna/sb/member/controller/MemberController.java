package me.himna.sb.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping(value="/register")
	public String register(HttpSession session, Model model) {
		//if(session.getAttribute("id") != null){return "index";}

		return "fragments/member/register";
	}
	
	
}
