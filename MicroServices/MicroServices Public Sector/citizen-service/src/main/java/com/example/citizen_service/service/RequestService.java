package com.example.citizen_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.citizen_service.dto.DepartmentDTO;
import com.example.citizen_service.dto.EmployeeDTO;
import com.example.citizen_service.dto.RequestDTO;
import com.example.citizen_service.entity.Citizen;
import com.example.citizen_service.entity.Request;
import com.example.citizen_service.entity.RequestStatus;
import com.example.citizen_service.feign.DepartmentClient;
import com.example.citizen_service.feign.EmployeeClient;
import com.example.citizen_service.repository.CitizenRepository;
import com.example.citizen_service.repository.RequestRepository;
import com.example.citizen_service.repository.RequestStatusRepository;

@Service
public class RequestService {
	@Autowired
    RequestRepository requestRepository;
	
	@Autowired
    CitizenRepository citizenRepository;
	
	@Autowired
    RequestStatusRepository statusRepository;
	
	@Autowired
    EmployeeClient employeeClient;
	
	@Autowired
    DepartmentClient departmentClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	 private static final String EMPLOYEE_SERVICE_URL = "http://employee-service/api/employees";
	 private static final String DEPARTMENT_SERVICE_URL = "http://department-service/api/departments";

    public Request createRequest(RequestDTO dto) {
        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() -> new RuntimeException("Citizen not found"));

        RequestStatus status = statusRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        Request req = new Request();
        req.setTitle(dto.getTitle());
        req.setDescription(dto.getDescription());
//        req.setCitizen(citizen);
        req.setStatus(status);
        req.setDepartmentId(dto.getDepartmentId());
        req.setCreatedDate(LocalDateTime.now());
        req.setUpdatedDate(LocalDateTime.now());

        return requestRepository.save(req);
    }
    
    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public EmployeeDTO getEmployeeForRequest(Long employeeId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("driverService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(EMPLOYEE_SERVICE_URL + "/"+employeeId, EmployeeDTO.class),
                throwable -> employeeFallBack(employeeId, throwable)
        );
	}
    public DepartmentDTO getDepartmentForRequest(Long departmentId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("driverService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(DEPARTMENT_SERVICE_URL + "/"+departmentId, DepartmentDTO.class),
                throwable -> departmentFallBack(departmentId, throwable)
        );
	}
    public EmployeeDTO employeeFallBack(Long employeeId, Throwable t) {
        System.out.println("⚠ Employee service is unavailable. Cause: " + t.getMessage());
        return new EmployeeDTO(employeeId, "N/A", "Employee data not available", "N/A", null);
    }
    public DepartmentDTO departmentFallBack(Long departmentId, Throwable t) {
        System.out.println("⚠ Department service is unavailable. Cause: " + t.getMessage());
        return new DepartmentDTO(departmentId, "N/A", "Department data not available");
    }
}