package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(ModelMap modelHolder) {

		return "Home";
	}
	
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String displayAboutPage(ModelMap modelHolder) {

		return "about";
	}
	
	@RequestMapping(path="/contact", method=RequestMethod.GET)
	public String displayContactPage(ModelMap modelHolder) {

		return "contact";
	}
	
	@RequestMapping(path="/contact", method=RequestMethod.POST)
	public String acceptContactInput(ModelMap modelHolder) {
		
		return "redirect:/ThankYouForYourInput";
	}
	
	@RequestMapping(path="/ThankYouForYourInput", method=RequestMethod.GET)
	public String ThankYouForYourInput(ModelMap modelHolder) {

		return "contactSuccess";
	}
	
	@RequestMapping(path="/careers", method=RequestMethod.GET)
	public String displayCareersPage(ModelMap modelHolder) {

		return "careers";
	}
}
