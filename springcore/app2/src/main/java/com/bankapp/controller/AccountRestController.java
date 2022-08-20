package com.bankapp.controller;

import java.util.*;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.controller.dto.DepositDto;
import com.bankapp.controller.dto.TransferDto;
import com.bankapp.controller.dto.WithdrawDto;
import com.bankapp.model.entity.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path = "api")
public class AccountRestController {

	private AccountService accountService;

	@Autowired
	public AccountRestController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("accounts")
	public List<Account> allAccounts() {
		return accountService.getAll();
	}
	

	@GetMapping("accounts/{id}")
	public Account getAnAccount( @PathVariable(name="id") int id) {
		return accountService.getById(id);
	}

}
