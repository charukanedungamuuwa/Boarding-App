package com.example.backendboadingapp.Controller;

import com.example.backendboadingapp.Entity.AccountToPayMateEntity;
import com.example.backendboadingapp.Entity.AccountToPayOwnerEntity;
import com.example.backendboadingapp.Services.AccountToPayOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/owner")
public class AccountToPayOwnerController {

    @Autowired
   private AccountToPayOwnerService accountToPayOwnerService;


    @PostMapping("/save")
    public AccountToPayOwnerEntity save(@RequestBody AccountToPayOwnerEntity accountToPayOwnerEntity){
        return accountToPayOwnerService.save(accountToPayOwnerEntity);
    }
    @PutMapping("/updateowner/{id}")
    public AccountToPayOwnerEntity update(@PathVariable Integer id,@RequestBody AccountToPayOwnerEntity accountToPayOwnerEntity){
return accountToPayOwnerService.update(id,accountToPayOwnerEntity);
    }
    @GetMapping("/getowner")
        public List<AccountToPayOwnerEntity> getall(){
        return accountToPayOwnerService.getowner();

    }
}

