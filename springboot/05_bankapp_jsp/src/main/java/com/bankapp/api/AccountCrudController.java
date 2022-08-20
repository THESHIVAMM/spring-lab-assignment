package com.bankapp.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankapp.model.service.AccountService;

@Controller
public class AccountCrudController {

	private AccountService accountService;
	
	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "accounts")
	public String allAccountsV2(ModelMap model) {
		model.addAttribute("accountsList", accountService.getAll());
		return "accounts";
	}

}





