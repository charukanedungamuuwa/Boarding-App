package com.example.backendboadingapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="StatusEntity")
public class StatusEntity {
    @Id
    private int employeeid;
    private String employeename;
    public boolean intheboarding;
    public boolean keyholder;

}
