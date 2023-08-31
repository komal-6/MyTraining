package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner ->{
			demoTheBeforeAdvice(accountDao,membershipDao);

		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

		//Call the business method
		Account account = new Account();
		accountDao.addAccount(account,true);
		accountDao.doWork();

		//Call the AccountDao getter/setter methods
		accountDao.setName("Komal");
		accountDao.setServiceCode("Silver");

		String name = accountDao.getName();
		String code = accountDao.getServiceCode();

		//call the membership business account
		membershipDao.addSillyMember();
		membershipDao.goToSleep();
	}

}
