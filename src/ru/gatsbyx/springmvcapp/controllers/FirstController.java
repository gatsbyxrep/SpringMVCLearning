package ru.gatsbyx.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name", required = false) String name, 
							@RequestParam(value = "surname", required = false) String surname,
							Model model) {
		model.addAttribute("message", "Hello, " + name + " " + surname);
		return "first/hello";
	}
	
	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}
	
	@GetMapping("/calc")
	public String calculator(@RequestParam("a") double a, 
			@RequestParam("b") double b, 
			@RequestParam("operation") String operation, Model model) {
		
		double result = 0.0;
		switch(operation) {
			case "multiplication":
				result = a * b;
				break;
			case "division":
					result = a / b;
					break;
			case "subtraction":
				result = a - b;
				break;
			case "addition":
				result = a + b;
				break;
		}
		model.addAttribute("result", result);
		return "first/calculator";
	}
}
