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


}
