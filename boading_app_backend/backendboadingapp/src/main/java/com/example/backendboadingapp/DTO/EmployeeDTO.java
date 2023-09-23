package com.example.backendboadingapp.DTO;

import lombok.Data;

@Data

public class EmployeeDTO {
    private int employeeid;
    private String employeename;
    private String email;
    private String password;
    public EmployeeDTO() {
    }
    public EmployeeDTO(int employeeid, String employeename, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
} //create getters and setter