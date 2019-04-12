package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	//Handling signup page
	
//	@RequestMapping(path="/Users/new", method=RequestMethod.GET)
//	public String displayNewUserForm(ModelMap modelHolder) {
//		if( ! modelHolder.containsAttribute("user")) {
//			modelHolder.addAttribute("user", new User());
//		}
//		return "Users/newUser";
//	}

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
		System.out.println(user.getUserName() + "  " + user.getEmail() + " "+ user.getPhone() + " " + user.getPassword() + " " + user.isEmployee());
		userDAO.saveUser(user.getUserName(), user.getEmail(), user.getPhone(), user.getPassword(), user.isEmployee());
		
		return "redirect:/Users/userDashboard";
	}
	
	
    //Handling login Link
	
	@RequestMapping(path="/Users/login", method=RequestMethod.GET)
	public String displayLoginUser(ModelMap modelHolder) {
		return "Users/login";
	}

	// post method after submitting the login 
	
	@RequestMapping(path="/Users/login", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, 
			RedirectAttributes flash, HttpSession session) {
//		if(result.hasErrors()) {
//			flash.addFlashAttribute("user", user);
//			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
//			return "redirect:/Users/newUser";
//		}
		
		
		userDAO.searchForUsernameAndPassword(user.getUserName(), user.getPassword());
		
		//Need to start the session with a user
//
//		//		userDAO.saveUser(user.getUserName(), user.getPassword());
		return "redirect:/Users/userDashboard";
	}
	
	
//	//added new set of code -create user method
//	@RequestMapping(path="/User/login", method= RequestMethod.POST)
//	public String createUser(@RequestParam String userName, @RequestParam String password) {
//	userDAO.saveUser(userName, password);
//	return "redirect:/Users/userDashboard";
//	}

	
	@RequestMapping(path="/Users/userDashboard", method=RequestMethod.GET)
	public String displayUserDashboard(ModelMap modelHolder, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
//		System.out.println("In the displayUserDashboard method. The user is " + user.getUserName());
//		System.out.println("email " + user.getEmail());
//		System.out.println("employee " + user.isEmployee());
		return "Users/userDashboard";
	}	
	
//	@RequestMapping(path="/User/userDashboard{userid}", method=RequestMethod.GET)
//	public String displayUserDashboard(Map<String, Object> model, @PathVariable String userName) {
//	return "Home";
//	}

	
}
