package com.techelevator.controller;

import com.techelevator.model.PotholeDAO;
import com.techelevator.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
@SessionAttributes({ "currentUser", "isEmployee" })
public class PotholeController {

	@Autowired
	private PotholeDAO potholeDAO;

	@RequestMapping(path = "/potholes/allPotholes", method = RequestMethod.GET)
	public String showAllPotholes(Model model, @RequestParam(required = false) String orderBy, HttpSession session) {

		if (session.getAttribute("isEmployee") == null)
			session.setAttribute("isEmployee", false);

		if (orderBy == null) {
			orderBy = "report_date";
		}

		model.addAttribute("allPotholes", potholeDAO.getListOfPotholes(orderBy));

		return "/potholes/allPotholes";
	}

	@RequestMapping(path = "/potholes/employeePotholeUpdate", method = RequestMethod.GET)
	public String employeeModifyPotholeGet(Model model, @RequestParam long pothole_Id) {

		model.addAttribute("pothole", potholeDAO.getPotholeById(pothole_Id));

		return "/potholes/employeePotholeUpdate";
	}

	@RequestMapping(path = "/potholes/employeePotholeUpdate", method = RequestMethod.POST)
	public String employeeModifyPotholePost(@RequestParam long pothole_Id, @RequestParam int severity,
			@RequestParam String status_Code,
			@RequestParam("status_Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date status_Date) {

		LocalDate localDate = status_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		potholeDAO.updatePotholeById(status_Code, localDate, severity, pothole_Id);

		return "redirect:/potholes/allPotholes";
	}

	@RequestMapping(path = "/potholes/deletePothole", method = RequestMethod.POST)
	public String employeeDeletePothole(@RequestParam long pothole_Id) {

		potholeDAO.deletePotholeById(pothole_Id);

		return "redirect:/potholes/allPotholes";
	}

	@RequestMapping(path = "/potholes/report", method = RequestMethod.GET)
	public String showReport(Model model, HttpSession session, RedirectAttributes attr) {

		String currentUser = (String) session.getAttribute("currentUser");

		if (currentUser != null) {
			return "/potholes/report";
		} else {
			return "redirect:/user/login";
		}
	}
}
