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

import com.example.ecommerce_app_rest_api.model.Booking;
import com.example.ecommerce_app_rest_api.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {
	@Autowired
	BookingService bookingService;
		
	@GetMapping("/bookings")
		public List<Booking> getAllBooking(){
			return bookingService.getAllBookings();
		}

		@PostMapping("/bookings")
		public Booking createBooking(@RequestBody Booking booking) {
			return bookingService.saveBooking(booking);
		}
		@GetMapping("/bookings/{id}")
		public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
			Booking booking = bookingService.getBookingById(id);
			return  new ResponseEntity<Booking>(booking,HttpStatus.OK) ;
		}
		
		@PutMapping("/bookings/{id}")
		public Booking updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
			Booking existingBooking = bookingService.getBookingById(id);
	    	existingBooking.setBookingDate(booking.getBookingDate());
	    	existingBooking.setSeats(booking.getSeats());
	    	
	    	Booking result = bookingService.saveBooking(existingBooking);
	    	
	    	return result;
		}
		@DeleteMapping("/bookings/{id}")
		public String deleteBooking(@PathVariable Long id) {
			bookingService.deleteBooking(id);
			return "Booking deleted with this "+id;
		}

}
