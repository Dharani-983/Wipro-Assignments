package com.example.ecommerce_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_app_rest_api.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	
}
