package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(AccountDao accountDao, MembershipDao membershipDao, TrafficFortuneService trafficFortuneService){
		return runner ->{
			//demoTheBeforeAdvice(accountDao,membershipDao);
			//demoAfterReturningAdvice(accountDao);
			//demoAfterThrowingAdvice(accountDao);
			//demoAfterAdvice(accountDao);
			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundAdviceHandleException(trafficFortuneService);
			demoAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: AroundAdviceRethrowException\n");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\n Fortune is: "+data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: demoTheAroundAdvice\n");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\n Fortune is: "+data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\n Main Program: demoTheAroundAdvice\n");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("\n Fortune is: "+data);

	}

	private void demoAfterAdvice(AccountDao accountDao) {

		//Call method to find the accounts
		List<Account> accounts = null;

		try {
			//Add a boolean flag to simulate the exception
			boolean tripWire = false;
			accounts = accountDao.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main Program: Caught exception\n");
		}

		//Display the accounts
		System.out.println("\n\n Main Program: demoAfterAdvice\n");
		System.out.println(accounts + "\n");
	}

	private void demoAfterThrowingAdvice(AccountDao accountDao) {
		//Call method to find the accounts
		List<Account> accounts = null;

		try {
			//Add a boolean flag to simulate the exception
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main Program: Caught exception\n");
		}

		//Display the accounts
		System.out.println("\n\n Main Program: demoAfterThrowingAdvice\n");
		System.out.println(accounts + "\n");
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {

		//Call method to find the accounts
		List<Account> accounts = accountDao.findAccounts();

		//Display the accounts
		System.out.println("\n\n Main Program: demoAfterReturningAdvice\n");
		System.out.println(accounts + "\n");
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

		//Call the business method
		Account account = new Account();
		account.setName("Piya");
		account.setLevel("Platinum");
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
