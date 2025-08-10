package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.TicketService;

public class AirFlightMain {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("airline-content.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");

        String result1 = ticketService.confirmBooking("FL123", "USER456");
        System.out.println(result1); 

        String result2 = ticketService.confirmBooking("FL456", "USER789");
        System.out.println(result2);
    }
}
