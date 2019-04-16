package com.techelevator.controller;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import com.techelevator.model.User;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
@SessionAttributes({ "currentUser", "isEmployee" })
public class PotholeController {
	
	private PotholeDAO potholeDAO;
	private UserDAO userDAO;
	
	@Autowired
	public PotholeController(PotholeDAO potholeDAO, UserDAO userDAO) {
		this.potholeDAO= potholeDAO;
		this.userDAO = userDAO;
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

	@RequestMapping(path = "/Users/employeeDashboard", method = RequestMethod.POST)
	public String employeeModifyPotholePost(HttpServletRequest request, @ModelAttribute Pothole pothole, HttpSession session, BindingResult result, ModelMap modelHolder, RedirectAttributes flash) {
		long potholeId = Long.parseLong(request.getParameter("PotholeId"));
		int severity = Integer.parseInt(request.getParameter("severity"));
		String statusCode = request.getParameter("statusCode");
		
		LocalDate date = LocalDate.now();
		potholeDAO.updatePotholeById(statusCode, date, severity, potholeId);
		return "redirect:/Users/employeeDashboard";
	}
	
	@RequestMapping(path="/Potholes/report", method=RequestMethod.POST)
	public String savePothole(HttpServletRequest request, @ModelAttribute Pothole pothole, HttpSession session, BindingResult result, ModelMap modelHolder, RedirectAttributes flash) {
		Long userId = Long.parseLong(request.getParameter("userId"));
	potholeDAO.savePothole(userId, pothole.getStreetNumber(), pothole.getStreetName(), pothole.getCity(), pothole.getState(), pothole.getZipCode(), pothole.getCountry(), pothole.getLat(), pothole.getLng(), pothole.getSeverity());

	
	User loggedUser = userDAO.searchForUserByUserId(userId);
	
//	session.setAttribute("user", loggedUser);
	
	
	if(loggedUser.isEmployee()) {
		return "redirect:/Users/employeeDashboard";

		    }
		    else {
		        return "redirect:/Users/userDashboard";
		    }
}

	@RequestMapping(path = "/potholes/deletePothole", method = RequestMethod.POST)
	public String employeeDeletePothole(@RequestParam long pothole_Id) {

		potholeDAO.deletePotholeById(pothole_Id);

		return "redirect:/Potholes/allPotholes";
	}

	
	@RequestMapping(path = "/Potholes/report", method = RequestMethod.GET)
	public String reportPothole(Model model, HttpSession session, RedirectAttributes attr) {
		User user = (User)session.getAttribute("user");
//		String currentUser = (String) session.getAttribute("currentUser");

		return "/Potholes/report";

//		if (currentUser != null) {
//			return "/Potholes/reportPothole";
//		} else {
//			return "redirect:/User/login";
//		}
	}
	
	
	
}
