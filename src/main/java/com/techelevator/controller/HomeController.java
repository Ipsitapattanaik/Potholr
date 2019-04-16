package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

@Controller
public class HomeController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomePage(ModelMap modelHolder) {

		return "Home";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String displayAboutPage(ModelMap modelHolder) {

		return "about";
	}

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String displayContactPage(ModelMap modelHolder) {

		return "contact";
	}

	@RequestMapping(path = "/contact", method = RequestMethod.POST)
	public String acceptContactInput(ModelMap modelHolder, @RequestParam String name, @RequestParam String email,
			@RequestParam String subject, @RequestParam String message)
			throws MailjetException, MailjetSocketTimeoutException {
		MailjetClient client;
		MailjetRequest request;
		MailjetResponse response;
		client = new MailjetClient(System.getenv("c7207a2dd9b1bf3091282c6ac3da7838"),
				System.getenv("bf2ea2d034b89b8c62275fc135fa4d0e"), new ClientOptions("v3.1"));
		request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, new JSONArray().put(new JSONObject()
				.put(Emailv31.Message.FROM, new JSONObject().put("Email", "team404potholecapstone@gmail.com").put("Name", name))
				.put(Emailv31.Message.TO,
						new JSONArray().put(new JSONObject().put("Email", "team404capstone@googlegroups.com")
								.put("Name", "The Pothole Tracking Team")))
				.put(Emailv31.Message.SUBJECT, subject).put(Emailv31.Message.TEXTPART, "New message from "+email+" the message is: " + message)
				.put(Emailv31.Message.HTMLPART, "<h6>New message from "+email+" <p>" + message + "</p>")));
		response = client.post(request);
		System.out.println(response.getStatus());
		System.out.println(response.getData());

		return "redirect:/ThankYouForYourInput";
	}

	@RequestMapping(path = "/ThankYouForYourInput", method = RequestMethod.GET)
	public String ThankYouForYourInput(ModelMap modelHolder) {

		return "contactSuccess";
	}

	@RequestMapping(path = "/careers", method = RequestMethod.GET)
	public String displayCareersPage(ModelMap modelHolder) {

		return "careers";
	}
}
