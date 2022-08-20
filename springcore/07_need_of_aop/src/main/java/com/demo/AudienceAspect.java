package com.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAspect {
	
    //@After vs @Before vs @AfterReturning(iff target method ex succcessfully)
	
	@Around("execution(public String doMagic())")
	public Object clapping(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start");
		Object val=joinPoint.proceed();
		System.out.println("end");
		return val;
	}
	
	
	
	
//	@AfterReturning("execution(public void doMagic())")
//	@After("execution(public void doMagic())")
//	public void clapping() {
//		System.out.println("maza aa gaya! wow");
//	}
//	
//	@AfterThrowing(pointcut ="execution(public void doMagic())" , throwing = "ex")
//	public void callTheDr(GetIllException ex) {
//		System.out.println(ex.getMessage());
//	}
}





//@Pointcut("execution(public void doMagic())")
//public void myPointCut() {}
//
