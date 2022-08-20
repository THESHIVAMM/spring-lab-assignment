package com.bankapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bankapp.model.entity.Account;
import com.bankapp.model.presistance.AccountRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
//i want that when spring boot i should insert some account object => CommandLineRunner
	
	@Autowired
	private AccountRepository accountRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("ravi", new BigDecimal(7000), "ravi@gmail.com", "7565656566"));
		accountRepo.save(new Account("seema", new BigDecimal(7000), "seema@gmail.com", "7500656566"));
		
	}

}
