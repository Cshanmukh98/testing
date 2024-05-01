package com.amex.assessment.service;

import com.amex.assessment.model.EmployeeDetails;

import java.util.List;

public interface EmployeeService {
    EmployeeDetails saveEmployee(EmployeeDetails employeeDetails);
    List<EmployeeDetails> getAllEmployees();
    EmployeeDetails getEmployeeById(Long employeeId);
    EmployeeDetails updateEmployee(EmployeeDetails employeeDetails);
    void deleteEmployee(Long employeeId);
}
