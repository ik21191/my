package com.ecom.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.HomePageService;
import com.ecom.service.HomePageServiceImpl;

public class HomeSearchController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			HomePageService homePageService = new HomePageServiceImpl();
			String searchParameter = hsr.getParameter("val1");
			List<Map<String, Object>> searchResult = homePageService.homeSearch(searchParameter);
			modelAndView.addObject("list", searchResult);
			modelAndView.setViewName("displayproducts");
		} catch (Exception e) {
			log.error("Problem while searching item " + e);
		}
		return modelAndView;
	}

}
