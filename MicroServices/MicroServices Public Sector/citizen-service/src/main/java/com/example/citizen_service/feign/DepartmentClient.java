package com.example.citizen_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.citizen_service.dto.DepartmentDTO;

@FeignClient(name="department-service", url="http://localhost:1117")
public interface DepartmentClient {
	
	@GetMapping("/api/departments/id")
	DepartmentDTO getProductById(@PathVariable Long id );

}