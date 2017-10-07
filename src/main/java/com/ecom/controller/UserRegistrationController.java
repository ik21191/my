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

import com.ecom.beans.User;
import com.ecom.service.UserService;
import com.ecom.service.UserServiceImpl;

@SuppressWarnings({ "rawtypes" })
public class UserRegistrationController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		log.info("############## UserRegistrationController");
		User user = new User();
		UserService userService = new UserServiceImpl();
		try {
			user.setFirstName(request.getParameter("FIRSTNAME"));
			user.setLastName(request.getParameter("LASTNAME"));
			user.setMobileNo(request.getParameter("MOBILENO"));
			user.setEmail(request.getParameter("EMAILADDRESS"));
			user.setPassword(request.getParameter("USERPASSWORD"));
			HttpSession session = getSession(request);
			List list = userService.userRegistration(user);
			Map m = (Map) list.get(0);
			if (m.get("status") == "false") {
				log.info("User Successfully Registered.");
				session.setAttribute("customerId", m.get("customerId"));
				session.setAttribute("customerFirstName",
						m.get("customerFirstName"));
				session.setAttribute("customerEmail", m.get("customerEmail"));
			} else {
				log.info("User already exists.");
				request.setAttribute("registerResult",
						"This user already exists.");
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.htm");
			rd.forward(request, response);
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
