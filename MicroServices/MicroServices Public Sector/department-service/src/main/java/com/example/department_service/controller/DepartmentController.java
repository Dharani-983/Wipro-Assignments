package com.example.department_service.controller;

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

import com.example.department_service.entity.Department;
import com.example.department_service.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@GetMapping
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartments();
	}

	@PostMapping
	public Department createdepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
//		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
		System.out.println(" inside getCustomerById");
		Department department = departmentService.getDepartmentById(id);
		if (department == null) {
			// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {
		Department existingDepartment = departmentService.getDepartmentById(id);
//		existingDepartment.setDepartmentId(department.getDepartmentId());
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setLocation(department.getLocation());

		Department result = departmentService.saveDepartment(existingDepartment);

		return result;
	}
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return "Department deleted with this " + id;
	}
}
