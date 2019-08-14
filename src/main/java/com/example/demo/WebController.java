package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	private DemoService demoService;
	
	public WebController(DemoService demoService) {
		super();
		this.demoService = demoService;
	}

	@GetMapping("/")
	public String home(Model model) {
		
		demoService.count();
		model.addAttribute("attr", demoService.attr("1"));
		
		return "index";
	}
	

}
