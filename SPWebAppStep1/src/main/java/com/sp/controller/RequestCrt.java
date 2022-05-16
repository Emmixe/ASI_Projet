package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.service.UserService;

@Controller 
public class RequestCrt {

	private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

	@Autowired
	UserService uService;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("messageLocal", messageLocal);
		return "index";
	}
	@RequestMapping(value = { "/sign_in" }, method = RequestMethod.GET)
	public String display_sign_in(Model model) {
		return "display_sign_in";
	}
	
	@RequestMapping(value = { "/log_in" }, method = RequestMethod.GET)
	public String display_log_in(Model model) {
		return "display_log_in";
	}
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public void addUser(@RequestBody UserDto userDto) {
		System.out.println("\n\n\n\n" + userDto.getName() + "\n\n\n\n");
		uService.addUser(userDto);
	}
	
	@RequestMapping(value = { "/logIn" }, method = RequestMethod.POST)
	public void logIn(@RequestBody UserDto userDto) {
		System.out.println("\n\n\n\n" + "Connexion" + "\n\n\n\n");
		uService.logIn(userDto);
	}

}
