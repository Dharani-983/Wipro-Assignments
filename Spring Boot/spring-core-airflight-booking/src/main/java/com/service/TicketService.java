package com.service;

public class TicketService {
	private FlightService flightService;

    // Setter for Dependency Injection
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public String confirmBooking(String flightNumber, String userId) {
        if (flightService.isSeatAvailable(flightNumber)) {
            flightService.reduceSeat(flightNumber);
            return "Booking confirmed for " + userId + " on " + flightNumber;
        } else {
            return "Flight " + flightNumber + " is full";
        }
    }
}
