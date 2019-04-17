package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;


@Controller
public class HomeController {
	
	private PotholeDAO potholeDAO;

	@Autowired
	public HomeController(PotholeDAO potholeDAO) {
	    this.potholeDAO= potholeDAO;
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(ModelMap modelHolder, HttpServletRequest req) {
		List<Pothole> listOfPotholes = potholeDAO.getListOfAllPotholes();
		req.setAttribute("potholes", listOfPotholes);
		req.setAttribute("arrayOfPotholes", potholeDAO.getArrayOfPothole(listOfPotholes));
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
