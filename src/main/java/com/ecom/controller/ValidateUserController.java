package com.ecom.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.UserService;
import com.ecom.service.UserServiceImpl;

@SuppressWarnings({ "rawtypes" })
public class ValidateUserController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {
		String action = hsr.getParameter("action");
		UserService userService = new UserServiceImpl();
		try {
			if (action != null) {
				if (hsr.getParameter("action").equalsIgnoreCase("authorizeUser")) {
					log.info("############## ValidateUserController");
					HttpSession session = getSession(hsr);
					List list = userService.validateUser(hsr.getParameter("userid"), hsr.getParameter("userpassword"));
					Map m = (Map) list.get(0);
					if (m.get("status") == "Valid") {
						log.info("Authorize user");
						session.setAttribute("customerFirstName", m.get("customerFirstName"));
						session.setAttribute("customerEmail", m.get("customerEmail"));
					} else {
						log.info("InValid User");
						hsr.setAttribute("loginResult", "InValid user name or password");
					}
					RequestDispatcher rd = hsr.getRequestDispatcher("index.htm");
					rd.forward(hsr, hsr1);
				} else {
					RequestDispatcher rd = hsr.getRequestDispatcher("index.htm");
					rd.forward(hsr, hsr1);
				}
			} else {

			}
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	public static HttpSession getSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session;
	}
}
