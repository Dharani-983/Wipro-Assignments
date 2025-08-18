package com.example.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.department_service.entity.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long>{

}
