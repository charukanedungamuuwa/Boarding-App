package com.example.backendboadingapp.Controller;

import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Entity.PaymentEntity_mates;
import com.example.backendboadingapp.Services.PaymentServices_mates;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PayementsController_mates {
    @Autowired
    private PaymentServices_mates paymentServices_mates;
//    @PostMapping("/save")
//    public PaymentEntity_mates savepayments(@RequestBody PaymentEntity_mates paymentEntity_mates){
//        return paymentServices_mates.save(paymentEntity_mates);
//    }
//@PostMapping("/save")
//public PaymentEntity_mates savepayments(
//        @RequestPart("payment") PaymentEntity_mates paymentEntity_mates,
//        @RequestPart(value = "image", required = false) MultipartFile imageFile) throws IOException {
//
//    if (imageFile != null && !imageFile.isEmpty()) {
//        paymentEntity_mates.setImage(imageFile.getBytes());
//    }
//
//    return paymentServices_mates.save(paymentEntity_mates);
//}
@PostMapping("/save")
public ResponseEntity<String> savePayments(
        @RequestPart("payment") String paymentData,
        @RequestPart(value = "image", required = false) MultipartFile imageFile) {

    try {
        ObjectMapper objectMapper = new ObjectMapper();
        PaymentEntity_mates paymentEntity_mates = objectMapper.readValue(paymentData, PaymentEntity_mates.class);

        if (imageFile != null && !imageFile.isEmpty()) {
            paymentEntity_mates.setImage(imageFile.getBytes());
        }

        PaymentEntity_mates savedPayment = paymentServices_mates.save(paymentEntity_mates);

        return ResponseEntity.ok("Payment saved with ID: " + savedPayment.getId());
    } catch (IOException e) {
        return ResponseEntity.badRequest().body("Error processing the request data.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}

    @GetMapping("/get")
    public  List<PaymentEntity_mates> getpayments(){
        return paymentServices_mates.getall();
    }
    @GetMapping("/get/{id}")
    public PaymentEntity_mates getbyid(@PathVariable Integer id){
        return paymentServices_mates.findbyid(id);
    }
    @PutMapping("/update/{id}")
    public PaymentEntity_mates update(@PathVariable Integer id,@RequestBody PaymentEntity_mates paymentEntity_mates){
        return paymentServices_mates.update(id,paymentEntity_mates);
    }
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return paymentServices_mates.deletebyid(id);

    }



    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        PaymentEntity_mates payment = paymentServices_mates.findbyid(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Change to the appropriate image type (e.g., MediaType.IMAGE_PNG for PNG images)

        return new ResponseEntity<>(payment.getImage(), headers, HttpStatus.OK);
    }

    @GetMapping("/getmonth/{month}")
    public List<PaymentEntity_mates> getbymonth(String month){
//    return paymentServices_mates.getbymonth(month);
        return paymentServices_mates.getByMonth(month);

    }
    @GetMapping("/getmonth2/{month}")
    public List<PaymentEntity_mates> getbymonth2(String month){
//    return paymentServices_mates.getbymonth(month);
        return paymentServices_mates.getByMonth2(month);

    }
    @GetMapping("/getmonth3/{month}")
    public List<PaymentEntity_mates> getbymonth3(String month){
//    return paymentServices_mates.getbymonth(month);
        return paymentServices_mates.getByMonth3(month);

    }
    @GetMapping("/currentmonth/{month}")
    public List<PaymentEntity_mates>getbycurrentmonth(){
    return paymentServices_mates.getbycurrentmonth();
    }

}


