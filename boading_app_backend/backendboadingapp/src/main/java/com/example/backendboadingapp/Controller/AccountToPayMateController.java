package com.example.backendboadingapp.Controller;

import com.example.backendboadingapp.Entity.AccountToPayMateEntity;
import com.example.backendboadingapp.Services.AccountToPayMateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping("/admin")
public class AccountToPayMateController {
    @Autowired
    private AccountToPayMateServices accountToPayMateServices;

    @PostMapping("/save")
    public AccountToPayMateEntity save(@RequestBody AccountToPayMateEntity accountToPayMateEntity){
        return accountToPayMateServices.add(accountToPayMateEntity);
    }
    @PutMapping("/update/{id}")
    public AccountToPayMateEntity update(@PathVariable Integer id, @RequestBody AccountToPayMateEntity accountToPayMateEntity){
        return accountToPayMateServices.update(id,accountToPayMateEntity);
    }
    @GetMapping("/getall")
    public List<AccountToPayMateEntity> getall()        {
        return accountToPayMateServices.get();
    }

}
