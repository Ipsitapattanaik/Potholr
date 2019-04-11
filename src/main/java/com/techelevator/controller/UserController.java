package com.techelevator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path="/Users/new", method=RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "Users/newUser";
	}
	
	@RequestMapping(path="/Users/new", method=RequestMethod.POST)
	public String displayDashBoardForNewlyRegisteredUser(@RequestParam(defaultValue = "false") boolean checkbox,
			@Valid @ModelAttribute User user, BindingResult result, ModelMap modelHolder, RedirectAttributes flash) {
//		if( ! modelHolder.containsAttribute("user")) {
//			modelHolder.addAttribute("user", new User());
//		}

	    if (checkbox) {
	    	System.out.println("Checkbox is checked");
	    	user.setEmployee(true);
	    }
	    else {
	    	System.out.println("Checkbox is UNCHECKED");
	    	user.setEmployee(false);
	    }

		System.out.println("******************************************");
		System.out.println(user.getUserName() + "  " + user.getPassword() + " " + user.isEmployee());
		userDAO.saveUser(user.getUserName(), user.getPassword(), user.isEmployee());
		
		return "redirect:/Users/userDashboard";
	}
	

	@RequestMapping(path="/Users/login", method=RequestMethod.GET)
	public String displayLoginUser(ModelMap modelHolder) {
		return "Users/login";
	}


	@RequestMapping(path="/Users/login", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash) {
		System.out.println("Entering the POST method");
		System.out.println("******************************************");
		System.out.println(user.getUserName() + "  " + user.getPassword());
		
		
//		if(result.hasErrors()) {
//			flash.addFlashAttribute("user", user);
//			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
//			return "redirect:/Users/newUser";
//		}
		System.out.println("Before saving");
		
		userDAO.searchForUsernameAndPassword(user.getUserName(), user.getPassword());
		
		//Need to start the session with a user
//
//		//		userDAO.saveUser(user.getUserName(), user.getPassword());
		System.out.println("After saving");
		return "redirect:/Users/userDashboard";
	}
	
	@RequestMapping(path="/Users/userDashboard", method=RequestMethod.GET)
	public String displayUserDashboard(ModelMap modelHolder) {
		return "Users/userDashboard";
	}	

	
}
