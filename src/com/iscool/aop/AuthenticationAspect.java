package com.iscool.aop;

import com.iscool.security.SessionUtil;
import com.iscool.security.model.User;
import com.iscool.util.ERPConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class AuthenticationAspect {

	@Pointcut("within(@org.springframework.stereotype.Controller *) " +
			"&& !within(@org.springframework.stereotype.Controller com.iscool.security.AuthenticationController) " +
            "&& !within(@org.springframework.stereotype.Controller com.iscool.security.HomeController)")
	public void allControllers(){}

	@Pointcut("execution(* *(..))")
    public void methodPointcut() {}

	@Around("allControllers() && methodPointcut()")
	public Object proceedToAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
		if(SessionUtil.getSession().getAttribute(ERPConstants.SESSION_USER) instanceof User){
            return proceedJoinPoint.proceed();
		} else {
            return new ModelAndView("redirect:/");
		}
	}

}
