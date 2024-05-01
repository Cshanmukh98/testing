package com.amex.assessment.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String employeeName;
    private String department;
    private String address;
    private Double salary;
}
