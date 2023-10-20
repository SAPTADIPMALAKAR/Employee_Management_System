package com.amdocs.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amdocs.employee.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

}
