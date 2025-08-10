package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.AppointmentService;

public class BookingMain {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appointment.xml");

        AppointmentService appointmentService = (AppointmentService) context.getBean("appointmentService");

        String result = appointmentService.book("DOC101", "2025-04-10");
        System.out.println(result); 

//        String result1 = appointmentService.book("DOC101", "2025-04-15");
//        System.out.println(result1);
    }
}
