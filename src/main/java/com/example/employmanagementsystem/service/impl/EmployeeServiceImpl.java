package com.example.employmanagementsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employmanagementsystem.dto.Employeedto;
import com.example.employmanagementsystem.entity.Employee;
import com.example.employmanagementsystem.exception.ResourceNotFoundException;
import com.example.employmanagementsystem.mapper.Employeemapper;
import com.example.employmanagementsystem.repository.EmployeeRepo;
import com.example.employmanagementsystem.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepo employeeRepo; 

	@Override
	public Employeedto createEmployee(Employeedto employeedto) {
		
		Employee employee = Employeemapper.mapToEmployee(employeedto);
		Employee savedEmployee = employeeRepo.save(employee);
		return Employeemapper.mapToEmployeedto(savedEmployee);
	}

	@Override
	public Employeedto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
//		employeeRepo.findby
		Employee employee = employeeRepo.findById(employeeId)
			.orElseThrow(() -> new ResourceNotFoundException("Employee doesnot Exist"+employeeId));
		return Employeemapper.mapToEmployeedto(employee);
	}

	@Override
	public List<Employeedto> getAllEmployees() {
		return 
			employeeRepo
				.findAll()
				.stream()
				.map(employee -> Employeemapper.mapToEmployeedto(employee))
				.toList();
	}

	@Override
	public Employeedto updateEmployee(Long id, Employee employee) {
		Employee employee2 = employeeRepo
								.findById(id)
								.orElseThrow(() -> 
								new ResourceNotFoundException("Employee doesnot Exist"+id));
;
		
		if(employee.getFirstName() != null) {
			employee2.setFirstName(employee.getFirstName());
		}
		if(employee.getLastName() != null) {
			employee2.setLastName(employee.getLastName());
		}
		if(employee.getEmail() != null) {
			employee2.setEmail(employee.getEmail());
		}
		
		return Employeemapper.mapToEmployeedto(employeeRepo
		.save(employee2));
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesnot Exist"+id));

		employeeRepo.deleteById(id);
		
	}

	
	
	

}
