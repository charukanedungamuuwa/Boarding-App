package com.example.backendboadingapp.Services;

import com.example.backendboadingapp.Entity.AccountToPayOwnerEntity;
import com.example.backendboadingapp.Repository.AccountToPayOwnerRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountToPayOwnerService {
    @Autowired
    private AccountToPayOwnerRepo accountToPayOwnerRepo;
    public AccountToPayOwnerEntity save(AccountToPayOwnerEntity accountToPayOwnerEntity){
        return accountToPayOwnerRepo.save(accountToPayOwnerEntity);
    }
    public AccountToPayOwnerEntity update(Integer id,AccountToPayOwnerEntity newowneraccount){
        AccountToPayOwnerEntity existingaccount=accountToPayOwnerRepo.findById(id).get();
        existingaccount.setAccount_Name(newowneraccount.getAccount_Name());
        existingaccount.setAccount_Number(newowneraccount.getAccount_Number());
        existingaccount.setBank(newowneraccount.getBank());
        existingaccount.setBranch(newowneraccount.getBranch());
        existingaccount.setMonthly_Payment(newowneraccount.getMonthly_Payment());
        return  accountToPayOwnerRepo.save(existingaccount);

    }
    public List<AccountToPayOwnerEntity> getowner(){
        return accountToPayOwnerRepo.findAll();
    }


}
