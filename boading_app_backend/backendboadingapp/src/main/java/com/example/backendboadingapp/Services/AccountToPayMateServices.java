package com.example.backendboadingapp.Services;

import com.example.backendboadingapp.Entity.AccountToPayMateEntity;
import com.example.backendboadingapp.Repository.AccountToPayMateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountToPayMateServices {

@Autowired
   private AccountToPayMateRepo accountToPayMateRepo;

public AccountToPayMateEntity add(AccountToPayMateEntity accountToPayMateEntity){
    return accountToPayMateRepo.save(accountToPayMateEntity);
}
    public  AccountToPayMateEntity update(Integer id, AccountToPayMateEntity newaccounttopay){

        AccountToPayMateEntity existingaccounttopay= accountToPayMateRepo.findById(id).get();
        existingaccounttopay.setAccount_Name(newaccounttopay.getAccount_Name());
        existingaccounttopay.setAccount_Number(newaccounttopay.getAccount_Number());
        existingaccounttopay.setBank(newaccounttopay.getBank());
        existingaccounttopay.setBranch(newaccounttopay.getBranch());
        existingaccounttopay.setMonthly_Payment(newaccounttopay.getMonthly_Payment());

        return accountToPayMateRepo.save(existingaccounttopay);
    }

    public List<AccountToPayMateEntity> get(){
    return accountToPayMateRepo.findAll();
    }
}
