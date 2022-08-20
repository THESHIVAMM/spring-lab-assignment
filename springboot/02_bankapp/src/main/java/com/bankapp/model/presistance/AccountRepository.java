package com.bankapp.model.presistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	
	
	
	
	
}
