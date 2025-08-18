package com.example.employee_service.controller;

import java.util.List;

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

import com.example.employee_service.entity.Employee;
import com.example.employee_service.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
		System.out.println(" inside getEmployeeById");
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPhoneNumber(employee.getPhoneNumber());
		existingEmployee.setDepartmentId(employee.getDepartmentId());

		Employee result = employeeService.saveEmployee(existingEmployee);

		return result;
	}
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted with this " + id;
	}
}
