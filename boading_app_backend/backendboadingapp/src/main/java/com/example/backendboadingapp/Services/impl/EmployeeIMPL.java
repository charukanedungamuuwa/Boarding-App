package com.example.backendboadingapp.Services.impl;

import com.example.backendboadingapp.DTO.EmployeeDTO;
import com.example.backendboadingapp.DTO.LoginDTO;
import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Repository.EmployeeRepo;
import com.example.backendboadingapp.Response.LoginMesage;
import com.example.backendboadingapp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }
    EmployeeDTO employeeDTO;
    @Override
    public LoginMesage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);

                if (employee.isPresent()) {
                    int userId = employee.get().getEmployeeid();
                    return new LoginMesage("Login Success", true,userId);
                } else {
                    return new LoginMesage("Login Failed", false,0);
                }
            } else {
                return new LoginMesage("password Not Match", false,0);
            }
        }else {
            return new LoginMesage("Email not exits", false,0);
        }
    }
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeid(employee.getEmployeeid());
            employeeDTO.setEmployeename(employee.getEmployeename());
            employeeDTO.setEmail(employee.getEmail());

            // You may choose to omit the password field for security reasons

            employeeDTOs.add(employeeDTO);
        }

        return employeeDTOs;
    }
    @Override
    public EmployeeDTO getEmployeeById(int userId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(userId);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeid(employee.getEmployeeid());
            employeeDTO.setEmployeename(employee.getEmployeename());
            employeeDTO.setEmail(employee.getEmail());

            // You may choose to omit the password field for security reasons

            return employeeDTO;
        } else {
            return null; // or throw an exception or handle as needed if the employee is not found
        }
    }
}