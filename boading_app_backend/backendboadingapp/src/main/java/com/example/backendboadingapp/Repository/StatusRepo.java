package com.example.backendboadingapp.Repository;

import com.example.backendboadingapp.Entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepo extends JpaRepository<StatusEntity,Integer> {

   @Query("select  q from StatusEntity q  where q .keyholder=true")
    List<StatusEntity> getbykeystatus(boolean keyholder);

    @Query("select  q from StatusEntity q  where q .intheboarding=true")
    List<StatusEntity> getbyavailablestatus(boolean intheboarding);
}
