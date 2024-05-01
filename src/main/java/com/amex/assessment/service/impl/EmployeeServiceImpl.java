package com.amex.assessment.service.impl;

import com.amex.assessment.model.EmployeeDetails;
import com.amex.assessment.repository.EmployeeRepository;
import com.amex.assessment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    /**
     * @param employeeDetails
     * @return
     */
    @Override
    public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * @param employeeId
     * @return
     */
    @Override
    public EmployeeDetails getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    /**
     * @param employeeDetails
     * @return
     */
    @Override
    public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
        EmployeeDetails details = employeeRepository.findById(employeeDetails.getEmployeeId()).get();
        if (employeeDetails.getEmployeeId() != null) {
            throw new NoSuchElementException("Employee details are not found");
        } else {
            details.setEmployeeName(Objects.nonNull(employeeDetails.getEmployeeName()) ? employeeDetails.getEmployeeName() : details.getEmployeeName());
            details.setDepartment(Objects.nonNull(employeeDetails.getDepartment()) ? employeeDetails.getDepartment() : details.getDepartment());
            details.setEmployeeName(Objects.nonNull(employeeDetails.getAddress()) ? employeeDetails.getAddress() : details.getAddress());
            details.setSalary(Objects.nonNull(employeeDetails.getSalary()) ? employeeDetails.getSalary() : details.getSalary());
            return employeeRepository.save(details);
        }
    }

    /**
     * @param employeeId
     */
    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
