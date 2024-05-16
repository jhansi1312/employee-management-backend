package com.example.employmanagementsystem.mapper;
import com.example.employmanagementsystem.dto.Employeedto;
import com.example.employmanagementsystem.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employeemapper {
		
		public static Employeedto mapToEmployeedto(Employee employee) {
			return new Employeedto(
						employee.getId(),
						employee.getFirstName(),
						employee.getLastName(),
						employee.getEmail()
			);	
		}
		
		public static Employee mapToEmployee(Employeedto employeedto) {
			
			return new Employee(
					employeedto.getId(),
					employeedto.getFirstName(),
					employeedto.getLastName(),
					employeedto.getEmail()	
			);
						
		}

}
