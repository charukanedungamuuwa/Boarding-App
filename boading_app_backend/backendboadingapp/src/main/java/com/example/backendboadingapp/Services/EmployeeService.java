package com.example.backendboadingapp.Services;

import com.example.backendboadingapp.DTO.EmployeeDTO;
import com.example.backendboadingapp.DTO.LoginDTO;
import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Response.LoginMesage;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    LoginMesage loginEmployee(LoginDTO loginDTO);
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(int userId);
}