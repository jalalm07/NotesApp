package com.jalal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jalal.model.User;
import com.jalal.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req , HttpServletResponse res) {
		System.out.println("inside showRegister");
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req , HttpServletResponse res, @ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}
}
