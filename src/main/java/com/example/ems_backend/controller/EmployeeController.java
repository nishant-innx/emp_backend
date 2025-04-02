package com.example.ems_backend.controller;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=  employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    //build getemployeebyid
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")  Long employeeId){
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //build get all emplyees rest api
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //build update
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody   EmployeeDto updatedEmployee){
        EmployeeDto updateEmployee=employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);

    }

}
