package com.bankapp.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bankapp.model.service.AccountService;

@Controller
public class TransactionController {

	private AccountService accountService;
	
	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	
	

}
