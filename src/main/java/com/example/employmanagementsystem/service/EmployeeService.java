package com.example.employmanagementsystem.service;

import java.util.List;

import com.example.employmanagementsystem.dto.Employeedto;
import com.example.employmanagementsystem.entity.Employee;

public interface EmployeeService {
	
	Employeedto createEmployee(Employeedto employeedto);

	Employeedto getEmployeeById(Long employeeId);
	
	List<Employeedto> getAllEmployees();

	Employeedto updateEmployee(Long id, Employee employee);
	
	void deleteEmployeeById(Long id);

}
