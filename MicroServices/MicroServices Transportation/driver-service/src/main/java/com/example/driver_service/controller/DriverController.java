package com.example.driver_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.driver_service.model.Driver;
import com.example.driver_service.service.DriverService;

@Configuration
@RestController
@RequestMapping("/api/drivers")
@CrossOrigin("*")
public class DriverController {
	@Autowired
	DriverService driverService;
	
	@GetMapping
	public ResponseEntity<List<Driver>> getAllDriver() {
		return ResponseEntity.ok(driverService.getAllDrivers());
	}

	@PostMapping
	public Driver createDriver(@RequestBody Driver driver) {
		driver.setCreatedAt(LocalDateTime.now());
		driver.setUpdatedAt(LocalDateTime.now());
		return driverService.saveDriver(driver);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
	    Driver driver = driverService.getDriverById(id);
	    if (driver != null) {
	        return ResponseEntity.ok(driver);   
	    } else {
	        return ResponseEntity.notFound().build(); 
	    }
	}
	
	@PutMapping("/{id}")
	public Driver updateDriver(@RequestBody Driver driver, @PathVariable Long id) {
		Driver existingDriver = driverService.getDriverById(id);
		existingDriver.setName(driver.getName());
		existingDriver.setPhoneNumber(driver.getPhoneNumber());
		existingDriver.setLicenseNumber(driver.getLicenseNumber());
		existingDriver.setAvailabilityStatus(driver.getAvailabilityStatus());
		existingDriver.setVehicleId(driver.getVehicleId());
		existingDriver.setCreatedAt(driver.getCreatedAt());
		existingDriver.setUpdatedAt(driver.getUpdatedAt());

		Driver result = driverService.saveDriver(existingDriver);

		return result;

	}

	@DeleteMapping("/{id}")
	public String deleteDriver(@PathVariable Long id) {
		driverService.deleteDriver(id);
		return "Driver deleted with this " + id;
	}
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**") // allow all endpoints
	                        .allowedOrigins("*") // allow all origins
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                        .allowedHeaders("*");
	            }
	        };
	    }

}
