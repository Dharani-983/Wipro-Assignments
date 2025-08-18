package com.example.department_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department_service.entity.Department;
import com.example.department_service.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		Department d = departmentRepository.save(department);
		return d;
	}
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(Long id)  {
		// TODO Auto-generated method stub
		Optional<Department> dept = departmentRepository.findById(id);
		if(dept.isPresent())
			return departmentRepository.findById(id).get();
		else
			return null;
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
	}

	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		
	}
}
