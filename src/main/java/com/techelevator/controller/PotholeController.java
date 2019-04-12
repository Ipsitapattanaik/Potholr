package com.techelevator.controller;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import com.techelevator.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
@SessionAttributes({ "currentUser", "isEmployee" })
public class PotholeController {
	
	private PotholeDAO potholeDAO;
	
	@Autowired
	public PotholeController(PotholeDAO potholeDAO) {
		this.potholeDAO= potholeDAO;
	}

	@RequestMapping(path = "/Potholes/allPotholes", method = RequestMethod.GET)
	public String showAllPotholes(Model model, @RequestParam(required = false) String orderBy, HttpSession session) {

		if (session.getAttribute("isEmployee") == null)
			session.setAttribute("isEmployee", false);

		if (orderBy == null) {
			orderBy = "report_date";
		}

		model.addAttribute("allPotholes", potholeDAO.getListOfPotholes(orderBy));

		return "/Potholes/allPotholes";
	}
	
	@RequestMapping(path="/Potholes/report", method=RequestMethod.POST)
	public String savePothole(@ModelAttribute Pothole pothole, BindingResult result, ModelMap modelHolder, RedirectAttributes flash) {
		System.out.println(pothole.getUserId() + " | " + pothole.getStreetNumber() + " | " + pothole.getStreetName() + " | " + pothole.getCity() + " | " 
	+ pothole.getState() + " | " + pothole.getZipCode() + " | " + pothole.getCountry() + " | " + pothole.getLat() + " | " + pothole.getLng());
		potholeDAO.savePothole(pothole.getUserId(), pothole.getStreetNumber(), pothole.getStreetName(), pothole.getCity(), pothole.getState(), pothole.getZipCode(), pothole.getCountry(), pothole.getLat(), pothole.getLng());
		return "redirect:/Users/userDashboard";
	}

	@RequestMapping(path = "/potholes/employeePotholeUpdate", method = RequestMethod.GET)
	public String employeeModifyPotholeGet(Model model, @RequestParam long pothole_Id) {

		model.addAttribute("pothole", potholeDAO.getPotholeById(pothole_Id));

		return "/Potholes/employeePotholeUpdate";
	}

	@RequestMapping(path = "/Potholes/employeePotholeUpdate", method = RequestMethod.POST)
	public String employeeModifyPotholePost(@RequestParam long pothole_Id, @RequestParam int severity,
			@RequestParam String status_Code,
			@RequestParam("status_Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date status_Date) {

		LocalDate localDate = status_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		potholeDAO.updatePotholeById(status_Code, localDate, severity, pothole_Id);

		return "redirect:/Potholes/allPotholes";
	}

	@RequestMapping(path = "/potholes/deletePothole", method = RequestMethod.POST)
	public String employeeDeletePothole(@RequestParam long pothole_Id) {

		potholeDAO.deletePotholeById(pothole_Id);

		return "redirect:/Potholes/allPotholes";
	}

	@RequestMapping(path = "/Potholes/report", method = RequestMethod.GET)
	public String showReport(Model model, HttpSession session, RedirectAttributes attr) {

//		String currentUser = (String) session.getAttribute("currentUser");

		return "/Potholes/report";

//		if (currentUser != null) {
//			return "/Potholes/reportPothole";
//		} else {
//			return "redirect:/User/login";
//		}
	}
}
