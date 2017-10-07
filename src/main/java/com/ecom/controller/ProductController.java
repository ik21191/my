package com.ecom.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.ProductService;
import com.ecom.service.ProductServiceImpl;

public class ProductController implements Controller 
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {
		ModelAndView modelAndView = new ModelAndView();
		ProductService productService = new ProductServiceImpl();
		try {
			String uri = hsr.getRequestURI();
			log.info("requested uri is :  " + uri);
			String productID = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
			String[] allString = uri.split("-");
			productID = allString[allString.length - 2];
			log.info("Requested Product id is: " + productID);
			modelAndView.setViewName("productdetail");
			modelAndView.addObject("mainProductDetails", productService.loadMainProductDetail((Integer.parseInt(productID))));
			modelAndView.addObject("addonListDetails", productService.loadAddonProductDetails(Integer.parseInt(productID)));
		} catch (Exception e) {
			log.error("Unexpected error occured : " + e);
		}
		return modelAndView;
	}

}
