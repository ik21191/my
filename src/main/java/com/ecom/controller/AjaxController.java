package com.ecom.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.service.CartService;
import com.ecom.service.CartServiceImpl;
import com.ecom.service.ShippingService;
import com.ecom.service.ShippingServiceImpl;

@SuppressWarnings("unchecked")
public class AjaxController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			ShippingService shippingService = new ShippingServiceImpl();
			CartService cartService = new CartServiceImpl();
			log.info("############# Ajax Controller ###########");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String cartid = request.getParameter("cartid");
			String quantity = request.getParameter("quantity");
			String price = request.getParameter("price");
			log.info(cartid + "  " + quantity + "  " + price);
			if (cartid != null && quantity != null && price != null) {
				long c = Long.parseLong(cartid);
				int q = Integer.parseInt(quantity);
				double p = Double.parseDouble(price);
				boolean result = cartService.updateCartPrice(c, q, p);
				if (result)
					out.println(q * p);
				List<Object> sessionAttribute = getCartDetails(request.getSession());
				Map<String, Object> finalCart = cartService.getCartDetails(sessionAttribute);
				request.getSession().setAttribute("cartDetails", finalCart.get("cartDetails"));
				request.getSession().setAttribute("cartValue", finalCart.get("cartValue"));
				log.info((Double) request.getSession().getAttribute("cartValue"));
				// log.info(QueryExecutor.getCart(sessionAttribute));
			}
			String shippingCity = request.getParameter("shippingcity");
			if (shippingCity != null) {
				log.info("...........fetching shipping info");
				int cityId = Integer.parseInt(shippingCity);
				List<Map<Object, Object>> list = shippingService.getCitySpecificShippingInfo(cityId);
				Iterator<Map<Object, Object>> itr = list.iterator();
				Map<Object, Object> m = new HashMap<Object, Object>();
				out.println("<select id=ship class=inp_pro_detail>");
				while (itr.hasNext()) {
					m = itr.next();
					out.println("<option value=" + (Integer) m.get("shippingId") + ">"
							+ (String) m.get("shippingTitle") + "["
							+ (Double) m.get("shippingWp") + "]" + "</option>");
				}
				out.println("</select>");
				log.info("...........fetching shipping info done..........");
			}
			String cartValue = request.getParameter("cartValue");
			log.info(cartValue);
			if (cartValue != null) {
				log.info("cartValue of AjaxController");
				log.info((Double) request.getSession().getAttribute("cartValue"));
				out.println("<h1>" + (Double) request.getSession().getAttribute("cartValue") + "</h1>");
			}
		} catch (Exception e) {
			log.error("Unexpected error occured " + e);
		}

		return null;
	}

	public static List<Object> getCartDetails(HttpSession session) {
		return (List<Object>) session.getAttribute("cartDetails");
	}
}
