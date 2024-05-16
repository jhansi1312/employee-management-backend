package com.example.employmanagementsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employmanagementsystem.dto.Employeedto;
import com.example.employmanagementsystem.entity.Employee;
import com.example.employmanagementsystem.mapper.Employeemapper;
import com.example.employmanagementsystem.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeedto){
		Employeedto savedEmployee = employeeService.createEmployee(employeedto);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employeedto> getEmployeeById(@PathVariable("id") Long employeeId){
		Employeedto employeedto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeedto);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Employeedto>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());	
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employeedto> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		return ResponseEntity
				.ok(employeeService
				.updateEmployee(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){

		employeeService.deleteEmployeeById(id);
		return ResponseEntity.ok("Employee deleted successfully");
				
	}
	
	
	
}
