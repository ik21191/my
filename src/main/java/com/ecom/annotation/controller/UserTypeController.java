package com.ecom.annotation.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserTypeController {
	private Logger log = Logger.getLogger("ecomLog");
	@RequestMapping(value="/usertype",method=RequestMethod.GET)
	public String showMessage() {
		log.info("aaa.htm  TestAnnotationController called");
		return "redirect:index.htm";
	}

}
