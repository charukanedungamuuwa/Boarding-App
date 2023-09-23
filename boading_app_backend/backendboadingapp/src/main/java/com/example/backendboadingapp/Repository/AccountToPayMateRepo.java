package com.example.backendboadingapp.Repository;

import com.example.backendboadingapp.Entity.AccountToPayMateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountToPayMateRepo extends JpaRepository<AccountToPayMateEntity,Integer> {
}
