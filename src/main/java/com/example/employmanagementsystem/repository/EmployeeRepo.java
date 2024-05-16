package com.example.employmanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employmanagementsystem.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
