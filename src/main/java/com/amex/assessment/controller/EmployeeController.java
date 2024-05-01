package com.amex.assessment.controller;

import com.amex.assessment.model.EmployeeDetails;
import com.amex.assessment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeService.saveEmployee(employeeDetails);
    }

    @GetMapping("/getById/{employeeId}")
    public EmployeeDetails getEmployeeDetailsById(@PathVariable("employeeId") long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/getAll")
    public EmployeeDetails getAllEmployeeDetails() {
        return (EmployeeDetails) employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteById/{employeeId}")
    public String deleteDepartmentById(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Deleted Successfully";
    }

    @PutMapping("/update")
    public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeService.updateEmployee(employeeDetails);
    }
}
