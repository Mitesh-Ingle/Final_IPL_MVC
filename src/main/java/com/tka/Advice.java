package com.tka;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {

	@Before("execution(* com.tka.dao..*(..))")
	public void callAllMethods() {
		System.err.println("**********");
		System.err.println("Current Timing is = " + new java.util.Date());

	}
}
