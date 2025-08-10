package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Address;
import com.model.Customer;

public class CustomerMain {
	public static void main(String[] args) {
		//load the context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//fetch the bean
		Customer cust=(Customer) context.getBean("customer");
		//access the variables
		System.out.println(cust.getName());
		
		Address addr=context.getBean(Address.class);
		System.out.println(addr.getCityName());
	}
}
