package com.bankapp.api;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dto.AccountDto;
import com.bankapp.model.entity.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.util.Conversion;

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
	public ResponseEntity<Account> addAccount( @Valid  @RequestBody AccountDto accountDto) {
		//i need to convert accountDto to account object
		Account account = Conversion.convertAccountDtoToAccount(accountDto);
		
		Account accountSaved= accountService.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountSaved);
	}

	
	
	//-------update account--------------
	@PutMapping(path = "accounts/{id}")
	public Account updateAccount(@PathVariable(name="id")  int id,  @RequestBody Account account) {
		account.setId(id);
		return accountService.updateAccount(account);
	}
	
	//-------delete an account--------------
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "accounts/{id}")
	public  void deleteAccountById(@PathVariable(name="id")  int id) {
		 accountService.deleteAccount(id);
	}
}





