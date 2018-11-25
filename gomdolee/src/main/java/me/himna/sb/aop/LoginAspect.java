package me.himna.sb.aop;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);
	
	@Pointcut("execution(* me.himna.sb.page.controller.PageController.*(..))")
	public void PageController() {System.out.println("=============PageController - LoginAspect=============");}
	
	//@Pointcut("execution(* me.himna.sb.page.controller.PageController.*(..))")
	//public void PageController() {System.out.println("=============PageController - LoginAspect=============");}
	
	@Around("PageController()")
	public Object checkLoginAspect(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("=============LoginAspect=============");
		HttpSession session = null;
		HttpServletResponse res = null;
		
		// Session 파라메터 가져오기
		for(Object obj : pjp.getArgs()) {
			if(obj instanceof HttpSession) {
				session = (HttpSession)obj;
			}
			if(obj instanceof HttpServletResponse) {
				res = (HttpServletResponse)obj;
			}
		}
		
		// login_id 체크
		if(session.getAttribute("login_id") == null) {
			System.out.println("session에 login_id가 없어.");
			return "fragments/member/login";
		}
		
		Object result = pjp.proceed();
		return result;
	}
}
