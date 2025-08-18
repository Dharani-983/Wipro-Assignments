package com.example.citizen_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citizen_service.dto.DepartmentDTO;
import com.example.citizen_service.dto.EmployeeDTO;
import com.example.citizen_service.dto.RequestDTO;
import com.example.citizen_service.entity.Request;
import com.example.citizen_service.repository.RequestRepository;
import com.example.citizen_service.service.RequestService;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
	@Autowired
	RequestService requestService;
	
	@Autowired
	RequestRepository requestRepository;
	
	@PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody RequestDTO dto) {
        return ResponseEntity.ok(requestService.createRequest(dto));
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequest(@PathVariable Long id) {
        return ResponseEntity.of(requestRepository.findById(id));
    }

    @GetMapping("/{id}/employee")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return requestService.getEmployeeForRequest(id);
    }

    @GetMapping("/{id}/department")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        return requestService.getDepartmentForRequest(id);
    }
}
