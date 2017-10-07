package com.ecom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.ecom.service.HomePageService;
import com.ecom.service.HomePageServiceImpl;

public class IndexController extends ParameterizableViewController {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView v = new ModelAndView();
		try {
			
			HomePageService homePageService = new HomePageServiceImpl();
			log.info("###############    IndexController class ################333");

			v.addObject("abc", "Hello test title");
			log.info("Loading home page widget.......");
			v.addObject("widgetMap", homePageService.loadHomePageWidget());
			log.info("Loaded home page widget.");
			v.setViewName("index");
		} catch (Exception e) {
			log.error("Unexpected error occured. " + e);
		}
		return v;
	}
}
