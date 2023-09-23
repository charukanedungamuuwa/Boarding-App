package com.example.backendboadingapp.Services;

import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Entity.PaymentEntity_mates;
import com.example.backendboadingapp.Repository.PaymentRepository_mates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PaymentServices_mates {
    @Autowired
    private PaymentRepository_mates paymentRepository_mates;
//    public PaymentEntity_mates save(PaymentEntity_mates paymentEntity_mates){
//        return paymentRepository_mates.save(paymentEntity_mates);
//
//    }
//public PaymentEntity_mates save(PaymentEntity_mates paymentEntity_mates) {
//    // Save the entity first to get its ID
//    PaymentEntity_mates savedEntity = paymentRepository_mates.save(paymentEntity_mates);
//
//    // Attach the image to the entity
//    if (paymentEntity_mates.getImage() != null) {
//        savedEntity.setImage(paymentEntity_mates.getImage());
//    }
//
//    return paymentRepository_mates.save(savedEntity);
//}

    public PaymentEntity_mates save(PaymentEntity_mates paymentEntity_mates) {
        // Perform necessary validations before saving
        // ...

        PaymentEntity_mates savedEntity = paymentRepository_mates.save(paymentEntity_mates);
        return savedEntity;
    }



    public List<PaymentEntity_mates> getall(){
        return paymentRepository_mates.findAll();
    }
//    public PaymentEntity_mates  findbyid(int id){
//        return paymentRepository_mates.findById(id).get();
//    }

    public PaymentEntity_mates findbyid(int id) {
        Optional<PaymentEntity_mates> paymentOptional = paymentRepository_mates.findById(id);
        return paymentOptional.orElse(null); // Return null if not found
        // Alternatively, you can throw an exception for better error handling
        // throw new EntityNotFoundException("Payment with ID " + id + " not found");
    }
    public String  deletebyid(int id){
        paymentRepository_mates.deleteById(id);
        return ("succesfully deleted");
    }
    public PaymentEntity_mates  update(Integer id,PaymentEntity_mates newpaymentmates){
        PaymentEntity_mates existingpaymentmates=paymentRepository_mates.findById(id).get();

        existingpaymentmates.setAmount(newpaymentmates.getAmount());
        existingpaymentmates.setDate(newpaymentmates.getDate());
        existingpaymentmates.setName(newpaymentmates.getName());
        existingpaymentmates.setArrears(newpaymentmates.getArrears());
        existingpaymentmates.setSlip(newpaymentmates.getSlip());
        existingpaymentmates.setMonth(newpaymentmates.getMonth());

        return paymentRepository_mates.save(existingpaymentmates);

    }

    public List<PaymentEntity_mates> getByMonth(String month) {
        // Use the repository to get payments for the specified month
        return paymentRepository_mates.getBytMonth(month);
    }
    public List<PaymentEntity_mates> getByMonth2(String month) {
        // Use the repository to get payments for the specified month
        return paymentRepository_mates.getBytMonth2(month);
    }
    public List<PaymentEntity_mates> getByMonth3(String month) {
        // Use the repository to get payments for the specified month
        return paymentRepository_mates.getBytMonth3(month);
    }





    public List<PaymentEntity_mates> getbycurrentmonth() {
        Month currentMonth = LocalDate.now().getMonth();

        // Convert it to a capitalized string
        String currentMonthString = currentMonth.getDisplayName(
                TextStyle.FULL, Locale.ENGLISH
        ).substring(0, 1).toUpperCase() +
                currentMonth.getDisplayName(TextStyle.FULL, Locale.ENGLISH).substring(1).toLowerCase();

        // Use the repository to get payments for the current month
        List<PaymentEntity_mates> currentMonthPayments = paymentRepository_mates.getByCurrentMonth(currentMonthString);

        return currentMonthPayments;
    }
}
