package com.amdocs.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amdocs.employee.entity.Employee;
import com.amdocs.employee.services.EmployeeServices;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
	
	@Autowired
    private EmployeeServices employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok (this.employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?>  getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok (employeeService.getEmployeeById(id));
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setEmp_Id(id);
        return employeeService.updateOrCreateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Integer id) {
    	
    	try {
    	this.employeeService.deleteEmployee(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    	}catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}

