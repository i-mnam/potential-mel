package me.himna.sb.page.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PageController {
	
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/")
	public String home(HttpSession session) {
		return "fragments/main/index";
	}
	
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(HttpSession session) {
		System.out.print("Index???");
		return "fragments/main/index";
	}
	
	@RequestMapping(value="/404")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFound(HttpSession session) {
		return "404";
	}
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(value="test")
	public String test(HttpSession session) {
		return "test";
	}
	
}
