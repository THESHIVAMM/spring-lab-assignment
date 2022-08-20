package com.bankapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhatIsLogging {

	private static Logger logger=LoggerFactory.getLogger(WhatIsLogging.class);
	
	public static void main(String[] args) {
		
		
		logger.info("code is working till line no 6");
		
		logger.info("code is working till line no 16");
		
		logger.info("code is working till line no 21");
		
		try {
		Integer val=Integer.parseInt("44f");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		
		System.out.println("------");
	}
}
