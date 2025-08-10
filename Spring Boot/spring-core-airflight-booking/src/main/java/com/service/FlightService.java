package com.service;

import java.util.HashMap;
import java.util.Map;

public class FlightService {
	private Map<String, Integer> flightSeats = new HashMap<>();

    public FlightService() {
        // Sample data: flight number and remaining seats
        flightSeats.put("FL123", 2);
        flightSeats.put("FL456", 0);
    }

    public boolean isSeatAvailable(String flightNumber) {
        Integer seats = flightSeats.get(flightNumber);
        return seats != null && seats > 0;
    }

    public void reduceSeat(String flightNumber) {
        if (isSeatAvailable(flightNumber)) {
            flightSeats.put(flightNumber, flightSeats.get(flightNumber) - 1);
        }
    }
}
