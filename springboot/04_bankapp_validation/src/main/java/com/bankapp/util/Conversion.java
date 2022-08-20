package com.bankapp.util;

import com.bankapp.model.dto.AccountDto;
import com.bankapp.model.entity.Account;

public class Conversion {
	public  static Account convertAccountDtoToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setName(accountDto.getName());
		account.setPhone(accountDto.getPhone());
		return account;
	}
}
