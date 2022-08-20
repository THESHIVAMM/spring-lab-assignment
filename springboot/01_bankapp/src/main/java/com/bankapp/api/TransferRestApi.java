package com.bankapp.api;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dto.DepositRequest;
import com.bankapp.model.dto.TransferRequest;
import com.bankapp.model.dto.WithdrawRequest;
import com.bankapp.model.entity.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path="api")
public class TransferRestApi {

	private AccountService accountService;
	
	@Autowired
	public TransferRestApi(AccountService accountService) {
		this.accountService = accountService;
	}

	//--------tranfer-------
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody TransferRequest transferRequest) {
		accountService.transfer(transferRequest.getFromAcc(), 
				transferRequest.getToAcc(),
				transferRequest.getAmount());
		return "fund is transfered";
	}
	
	
	//--------deposit-------
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody DepositRequest depositRequest) {
		accountService.deposit(depositRequest.getAccId(), depositRequest.getAmount());
		return "fund is deposited";
	}
	
	
	//--------withdraw-------
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody WithdrawRequest withdrawRequest) {
		accountService.withdraw(withdrawRequest.getAccId(), withdrawRequest.getAmount());
		return "fund is withdraw";
	}
	
	
	//--------check balance method-------
	

}
