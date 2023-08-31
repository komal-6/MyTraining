package com.example.aopdemo.dao;


import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " doing my db work: For adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " going for work");
        return false;
    }
}
