package com.example.aopdemo.dao;


import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " doing my db work: For adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " going for work");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        //Simulate the exception
        if(tripWire){
            throw new RuntimeException("Exception is generated");
        }
        List<Account> accounts = new ArrayList<>();

        //Create sample accounts
        Account temp1 = new Account("Komal","Silver");
        Account temp2 = new Account("Piya","Gold");
        Account temp3 = new Account("Kavya","Platinum");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        //Add them to our accounts list
        return accounts;
    }
}
