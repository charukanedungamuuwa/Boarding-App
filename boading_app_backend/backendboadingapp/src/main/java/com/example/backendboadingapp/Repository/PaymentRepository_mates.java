package com.example.backendboadingapp.Repository;

import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Entity.PaymentEntity_mates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.MonthDay;
import java.util.List;

@Repository
public interface PaymentRepository_mates extends JpaRepository<PaymentEntity_mates,Integer> {




//    @Query("SELECT a FROM PaymentEntity_mates a WHERE a.month = ?1")
//    List<PaymentEntity_mates> getByCurrentMonth(String currentMonthString);
@Query("SELECT a FROM PaymentEntity_mates a WHERE a.month = 'April'")
List<PaymentEntity_mates> getBytMonth(String month);
    @Query("SELECT a FROM PaymentEntity_mates a WHERE a.month = 'February'")
    List<PaymentEntity_mates> getBytMonth2(String month);
    @Query("SELECT a FROM PaymentEntity_mates a WHERE a.month = 'March'")
    List<PaymentEntity_mates> getBytMonth3(String month);

    @Query("SELECT a FROM PaymentEntity_mates a WHERE a.month = ?1")

    List<PaymentEntity_mates> getByCurrentMonth(String currentMonthString);
}
