package com.example.Assignment_portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/")
    public String showHomePage() {
        return "home"; // This will map to /WEB-INF/home.html
    }
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Resolves to /WEB-INF/test.html
    }
    @GetMapping("/contact")
    public String contactPage() {
    	return "contact";
    }
    @GetMapping("/education")
    public String educationPage() {
    	return "education";
    }
    @GetMapping("/skills")
    public String skillsPage() {
    	return "skills";
    }
}
