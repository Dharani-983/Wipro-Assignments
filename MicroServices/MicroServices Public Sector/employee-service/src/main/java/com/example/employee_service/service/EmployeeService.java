package com.example.employee_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository EmployeeRepository;

	public Employee saveEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		Employee e = EmployeeRepository.save(Employee);
		return e;
	}
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id)  {
		// TODO Auto-generated method stub
		Optional<Employee> dept = EmployeeRepository.findById(id);
		if(dept.isPresent())
			return EmployeeRepository.findById(id).get();
		else
			return null;
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		EmployeeRepository.deleteById(id);
		
	}
}
