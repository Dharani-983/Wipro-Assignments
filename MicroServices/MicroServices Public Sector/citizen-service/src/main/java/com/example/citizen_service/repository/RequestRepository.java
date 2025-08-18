package com.example.citizen_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citizen_service.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long>{

}
