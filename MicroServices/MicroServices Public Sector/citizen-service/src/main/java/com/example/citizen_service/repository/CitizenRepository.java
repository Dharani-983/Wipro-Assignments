package com.example.citizen_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citizen_service.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long>{

	Optional<Citizen> findById(Citizen citizen);

}
