package com.ecom.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.CategoryService;
import com.ecom.service.CategoryServiceImpl;

public class CategoryController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		CategoryService categoryService = new CategoryServiceImpl();
		String uri = hsr.getRequestURI();
		log.info("requested uri is :  " + uri);
		String category = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		String[] allString = uri.split("-");
		category = allString[allString.length - 2];
		log.info("Requested Category is: " + category);
		List<Map<String, Object>> list = categoryService.getListOfProductsFromCategory(Integer.parseInt(category));
		modelAndView.setViewName("welcome");
		String categoryName = categoryService.getCategoryName(Integer.parseInt(category));
		modelAndView.addObject("categoryName", categoryName);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
