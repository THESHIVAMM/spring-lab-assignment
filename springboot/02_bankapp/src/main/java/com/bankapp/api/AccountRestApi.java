package com.bankapp.api;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entity.Account;
import com.bankapp.model.presistance.AccountRepository;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path="api")
public class AccountRestApi {

	private AccountService accountService;
	
	@Autowired
	public AccountRestApi(AccountService accountService) {
		this.accountService = accountService;
	}

	//-------getting all account--------------
	@GetMapping(path = "accounts")
	public  List<Account> getAllAccounts() {
		return accountService.getAll();
	}
	//-------getting one acccount by id--------------
	//how to make api robust?(imp)
	@GetMapping(path = "accounts/{id}")
	public  Account getAccountById(@PathVariable(name="id")  int id) {
		return accountService.getById(id);
	}
	
	//-------add new account-------------
	//@RequestBody is used to trigger the jakson parsor to convert json to java object
	
	//it must return status code of 201 ie created not 
	//we should also apply validation (400)BAD_REQUEST
	@PostMapping(path = "accounts")
	public Account addAccount( @RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	//-------update account--------------
	@PutMapping(path = "accounts/{id}")
	public Account updateAccount(@PathVariable(name="id")  int id,  @RequestBody Account account) {
		account.setId(id);
		return accountService.updateAccount(account);
	}
	
	//-------delete an account--------------

	@DeleteMapping(path = "accounts/{id}")
	public  Account deleteAccountById(@PathVariable(name="id")  int id) {
		return accountService.deleteAccount(id);
	}
}





