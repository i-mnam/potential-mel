package me.himna.sb.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);
	
	@Pointcut("excution(* me.himna.sb.member.controller.MemberController.*(..))")
	public void MemberService() {System.out.println("=============MemberServcie - LoginAspect=============");}
	
	
//	@Around("")
//	public Object checkLoginAspect() {
//		System.out.println("=============LoginAspect=============");
//		Object result = null;
//		return result;
//	}
}
