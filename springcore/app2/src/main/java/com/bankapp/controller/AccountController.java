package com.bankapp.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.controller.dto.DepositDto;
import com.bankapp.controller.dto.TransferDto;
import com.bankapp.controller.dto.WithdrawDto;
import com.bankapp.model.entity.Account;
import com.bankapp.model.service.AccountService;

@Controller
public class AccountController {
	
	private AccountService accountService;
	
	//@PostConstruct
	public void init() {
		accountService.createAccount(new Account("amit", 6000, "amit@gmail.com", "4545454545"));
		accountService.createAccount(new Account("sumit", 6000, "sumit@gmail.com", "6645454545"));
	}
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//ModelMap vs Model vs ModelAndView
	
	@GetMapping("/")
	public String home() {
		return "redirect:allaccounts";
	}
	
	@GetMapping("allaccounts")
	public String allAccounts(ModelMap modelMap) {
		modelMap.addAttribute("accountList", accountService.getAll());
		return "accounts";
	}

	//------whenever u want to have post operation u have to create 2 methods
	@GetMapping("transfer")
	public String transferGet(ModelMap map) {
		map.addAttribute("transferDto", new TransferDto());//formBean used to capture the data from form
		return "transfer";
	}
	
	@PostMapping("transfer")
	public String transferPost(TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
		return "redirect:allaccounts";
	}
	
	//------whenever u want to have post operation u have to create 2 methods
	@GetMapping("deposit")
	public String depositGet(ModelMap map) {
		map.addAttribute("depositDto", new DepositDto());//formBean used to capture the data from form
		return "deposit";
	}
	
	@PostMapping("deposit")
	public String depositPost(DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "redirect:allaccounts";
	}

	//------whenever u want to have post operation u have to create 2 methods
	@GetMapping("withdraw")
	public String withdrawGet(ModelMap map) {
		map.addAttribute("withdrawDto", new WithdrawDto());//formBean used to capture the data from form
		return "withdraw";
	}
	
	@PostMapping("withdraw")
	public String withdrawPost(WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "redirect:allaccounts";
	}

//	@GetMapping("allaccounts")
//	public ModelAndView allAccounts(ModelAndView mv) {
//		mv.setViewName("accounts");
//		mv.addObject("accountList", accountService.getAll());
//		return mv;
//		
//	}

}
