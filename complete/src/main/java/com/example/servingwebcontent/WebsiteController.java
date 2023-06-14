package com.example.servingwebcontent;

import org.springframework.stereotype.Controller; //addthis
import org.springframework.ui.Model; //add this
import org.springframework.web.bind.annotation.GetMapping; // add this
import org.springframework.web.bind.annotation.RequestParam; //add this

@Controller
public class WebsiteController {

	@GetMapping("/test")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="name") String name, Model model) {
		model.addAttribute("name", name);
		return "test";
	}

	@GetMapping("/homepage")
	public String homepage() {
		return "homepage";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

	@GetMapping("/studentWelcome")
	public String studentWelcome() {
		return "studentWelcome";
	}

	@GetMapping("/teacherWelcome")
	public String teacherWelcome() {
		return "teacherWelcome";
	}

	@GetMapping("/loginPortal")
	public String loginPortal() {
		return "loginPortal";
	}

	@GetMapping("/studentHomepage")
	public String studentHomepage() {
		return "studentHomepage";
	}

}
