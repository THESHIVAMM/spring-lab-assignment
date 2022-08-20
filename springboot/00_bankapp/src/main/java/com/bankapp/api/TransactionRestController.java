package com.bankapp.api;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entity.Account;
/*
 * 	@RestController= @Controller	+ @ResponseBody?
 *  jackson parser java --> json
 */

//http://localhost:8090/bankapp/api/accounts

//http://localhost:8090/bankapp/api/accounts
@RestController
@RequestMapping(path="api")
public class TransactionRestController {
	
	@GetMapping(path = "accounts")
	public  List<Account> getAllAccounts() {
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(new Account(1, "sumit", 5000, "sumit@gmail.com", "465466656"));
		accounts.add(new Account(2, "amit", 5000, "amit@gmail.com", "405466656"));
		
		return accounts;
		
	}
	

}
