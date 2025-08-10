package com.example.ecommerce_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_app_rest_api.model.Theater;
import com.example.ecommerce_app_rest_api.service.TheaterService;


@RestController
@RequestMapping("/api")
public class TheaterController {
	@Autowired
	TheaterService theaterService;
	
	@GetMapping("/theaters")
	public List<Theater> getAllTheater(){
		return theaterService.getAllTheaters();
	}

	@PostMapping("/theaters")
	public Theater createTheater(@RequestBody Theater theater) {
		return theaterService.saveTheater(theater);
	}
	@GetMapping("/theaters/{id}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
		Theater theater = theaterService.getTheaterById(id);
		return  new ResponseEntity<Theater>(theater,HttpStatus.OK) ;
	}
	
	@PutMapping("/theaters/{id}")
	public Theater updateTheater(@RequestBody Theater theater, @PathVariable Long id) {
		Theater existingTheater = theaterService.getTheaterById(id);
    	existingTheater.setName(theater.getName());
    	existingTheater.setLocation(theater.getLocation());
    	
    	Theater result = theaterService.saveTheater(existingTheater);
    	
    	return result;
	}
	@DeleteMapping("/theaters/{id}")
	public String deleteTheater(@PathVariable Long id) {
		theaterService.deleteTheater(id);
		return "Theater deleted with this "+id;
	}

}
