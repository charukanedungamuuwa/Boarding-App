package com.example.backendboadingapp.Controller;

import com.example.backendboadingapp.DTO.EmployeeDTO;
import com.example.backendboadingapp.DTO.LoginDTO;
import com.example.backendboadingapp.Entity.Employee;
import com.example.backendboadingapp.Entity.StatusEntity;
import com.example.backendboadingapp.Response.LoginMesage;
import com.example.backendboadingapp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
//    @GetMapping("/all")
//    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
//        List<EmployeeDTO> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
    @GetMapping("/{userId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int userId) {
        EmployeeDTO employee = employeeService.getEmployeeById(userId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


}