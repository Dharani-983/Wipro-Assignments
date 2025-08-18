package com.example.citizen_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citizen_service.entity.RequestStatus;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatus,Long>{

}
