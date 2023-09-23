package com.example.backendboadingapp.Repository;

import com.example.backendboadingapp.Entity.AccountToPayOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountToPayOwnerRepo extends JpaRepository<AccountToPayOwnerEntity,Integer> {
}
