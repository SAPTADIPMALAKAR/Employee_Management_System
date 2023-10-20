package com.amdocs.employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.amdocs.employee.entity.Employee;
import com.amdocs.employee.repository.EmployeeDAO;


@Service
public class EmployeeServices {
	   
		@Autowired
	    private EmployeeDAO employeeRepository;

	    
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee getEmployeeById(Integer id) {
	        return employeeRepository.findById(id).orElse(null);
	    }

	    public Employee saveEmployee(Employee employee) {
	    		
	    	employeeRepository.save(employee);
	        return employee;
	    }

	    public Employee updateOrCreateEmployee(Employee employee) {
	        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmp_Id());
	        
	        if (existingEmployee.isPresent()) {
	            Employee updatedEmployee = existingEmployee.get();
	            updatedEmployee.setName(employee.getName());
	            updatedEmployee.setNumber(employee.getNumber());
	            updatedEmployee.setRole(employee.getRole());
	            return employeeRepository.save(updatedEmployee);
	        } else {
	            return employeeRepository.save(employee);
	        }
	    }

	    public void deleteEmployee(Integer id) {
	        employeeRepository.deleteById(id);
	    }}

