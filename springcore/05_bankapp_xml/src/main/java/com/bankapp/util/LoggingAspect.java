package com.bankapp.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bankapp.model.service.AccountServiceImpl;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Pointcut("execution(* com.bankapp.model.service.*Impl.*(..))")
	public void allMthodsOfServiceLayer() {}
	
	@Around("allMthodsOfServiceLayer()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object val=joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		//we want to get the name of method from joinPoint
		
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		logger.info(method.getName() + " " + (end - start) + " ms");
		return val;
	}
}
