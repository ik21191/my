package com.ecom.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.UserService;
import com.ecom.service.UserServiceImpl;
public class GuestRegistrationController implements Controller
{
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {
		try {
			log.info("############## GuestRegistrationController");
			HttpSession session = getSession(hsr);
			UserService userService = new UserServiceImpl();
			String email = hsr.getParameter("email");
			boolean flag = userService.checkEmail(email);
			if (!flag) {
				log.info("Registering user............");
				userService.registerEmail(email);
				session.setAttribute("customerFirstName", "guest");
				session.setAttribute("customerEmail", email);
			} else {
				log.info("User already exists.");
				session.setAttribute("customerFirstName", "guest");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return new ModelAndView("checkout2");
	}
        public static HttpSession getSession(HttpServletRequest req)
        {
            HttpSession session=req.getSession();
            return session;
        }
}
