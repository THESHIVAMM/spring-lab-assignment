package com.bankapp.controller;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.model.persistance.Account;
import com.bankapp.model.service.AccountService;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=(AccountService) ctx.getBean("accountService");
		
		List<Account> accounts=accountService.getAll();
		
		accounts.forEach(acc-> System.out.println(acc));
		
		
		accountService.transfer(1, 2, 10);
		
		accounts=accountService.getAll();
		
		accounts.forEach(acc-> System.out.println(acc));
		
	}

}
