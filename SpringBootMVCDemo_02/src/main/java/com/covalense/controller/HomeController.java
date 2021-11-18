package com.covalense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		@RequestMapping("/")
		public String home() {
			return "home" ;
		}
		@RequestMapping("/employee")
		public String Employee() {
			return "employee";
			
		}
		@RequestMapping("/department")
		public String Department() {
			return "department" ;
		}
		
}
