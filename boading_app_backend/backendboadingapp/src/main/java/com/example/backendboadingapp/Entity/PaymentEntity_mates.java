package com.example.backendboadingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name="PaymentEntity_mates")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity_mates {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
private  String name;
private String date;
private Integer amount;
private Integer arrears;
    private Integer slip;
    private String month;
//    @Lob
//    private byte[] image;

    @Lob
    @Column(columnDefinition = "LONGBLOB") // Specify the column type
    private byte[] image;






}
