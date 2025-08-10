package com.example.first_spring_boot_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppContoller {
	@GetMapping("/")
    public String showHomePage() {
        return "home"; // This will map to /WEB-INF/home.html
    }
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Resolves to /WEB-INF/test.html
    }
    @PostMapping("/login")
    public String loginValidate(@RequestParam String uname, @RequestParam String psw) {
    	System.out.println("inside login Validate");
    	if(uname.equalsIgnoreCase("admin") && psw.equalsIgnoreCase("123")) {
    		System.out.println("user credentials is correct" +uname+ " " +psw);
    		return "dashboard";
    	}else {
    		System.out.println("user credentials is not correct");
    		return "home";
    	}
    }
}
