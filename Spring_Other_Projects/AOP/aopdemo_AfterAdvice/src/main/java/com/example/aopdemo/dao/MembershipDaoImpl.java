package com.example.aopdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " doing my db work: For membership an account");
        return true;
    }

    @Override
    public boolean goToSleep() {
        System.out.println(getClass() + "  going to sleep");
        return false;
    }
}
