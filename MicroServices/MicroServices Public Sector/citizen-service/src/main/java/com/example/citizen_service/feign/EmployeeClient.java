package com.example.citizen_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.citizen_service.dto.EmployeeDTO;

@FeignClient(name="employee-service", url="http://localhost:1118")
public interface EmployeeClient {
	
	@GetMapping("/api/employees/id")
	EmployeeDTO getProductById(@PathVariable Long id );

}