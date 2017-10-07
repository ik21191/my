package com.ecom.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ecom.db.helper.QueryExecutor;
import com.ecom.service.CartService;
import com.ecom.service.CartServiceImpl;
import com.ecom.service.ProductService;
import com.ecom.service.ProductServiceImpl;
import com.ecom.service.ShippingService;
import com.ecom.service.ShippingServiceImpl;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CartHandler implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			CartService cartService = new CartServiceImpl();
			ShippingService shippingService = new ShippingServiceImpl();
			ProductService productService = new ProductServiceImpl();
			Map<Object, Object> cart = new HashMap<Object, Object>();
			String productID = hsr.getParameter("productId");
			String shipping = hsr.getParameter("shipping");
			int city = Integer.parseInt(hsr.getParameter("city"));
			Map<String, String> cityRelation = shippingService.getCountryStateCityRelation(city);
			List shippingInfo = shippingService.getCitySpecificShippingInfo(city);
			Iterator<Map<Object, Object>> itr = shippingInfo.iterator();
			Map<Object, Object> shippingMode = new HashMap<Object, Object>();
			while (itr.hasNext()) {
				Map<Object, Object> temp = itr.next();
				if ((Integer) temp.get("shippingId") == Integer.parseInt(shipping)) {
					shippingMode.put("shippingTitle", (String) temp.get("shippingTitle"));
					shippingMode.put("shippingLeadDays", (Integer) temp.get("shippingLeadDays"));
					shippingMode.put("shippingWp", (Double) temp.get("shippingWp"));
					shippingMode.put("shippingId", (Integer) temp.get("shippingId"));
				}
			}
			log.info("**************         " + shippingMode);
			log.info("displaying shippingInfo: " + shipping);
			String deliverydate = hsr.getParameter("deliverydate");
			cart.put("cityRelation", cityRelation);
			cart.put("shippingInfo", shippingInfo);
			cart.put("deliverydate", deliverydate);
			cart.put("shippingId", (Integer) shippingMode.get("shippingId"));
			cart.put("shippingTitle", (String) shippingMode.get("shippingTitle"));
			cart.put("shippingWp", (Double) shippingMode.get("shippingWp"));
			log.info("Deliverydate: " + deliverydate);
			String addons = hsr.getParameter("addons");
			HttpSession session = hsr.getSession();
			List<Map<Object, Object>> parentProduct = null;
			parentProduct = productService.getParentProductForAddToCart(productID);
			Long subOrderId = cartService.saveParentProductToCart(parentProduct, cityRelation, session.getId().toString(),
					deliverydate, (String) shippingMode.get("shippingTitle"), (Double) shippingMode.get("shippingWp"));
			cart.put("subOrderId", subOrderId);
			cart.put("parentProduct", parentProduct);
			List<Map<Object, Object>> addonList = null;
			if (addons.length() > 0) {
				log.info("------Adssons------");
				int len = addons.length();
				addons = addons.substring(0, (len - 1));
				log.info(addons);
				addonList = productService.getAddonRelationForAddToCart(addons);
				cartService.saveAddonListToCart(addonList, cityRelation, session.getId().toString(), deliverydate, shipping, subOrderId);
				cart.put("addonList", addonList);
				log.info("------Adssons------");
			}

			String sessionId = session.getId().toString();
			log.info("Printing session variable's valus:    ++++++++++++++    "
					+ sessionId);
			log.info("########### product id is " + productID);
			log.info("Requested Product id is: " + productID);
			List<Object> cartDetails = getCartDetails(session);
			log.info("........................" + cartDetails);
			if (cartDetails == null)
				cartDetails = new ArrayList<Object>();
			cartDetails.add(cart);
			// QueryExecutor.saveCartDetails(cart, sessionId);
			session.setAttribute("cartDetails", cartDetails);
			Map<String, Object> finalCart = cartService.getCartDetails(cartDetails);
			hsr.getSession().setAttribute("cartDetails", finalCart.get("cartDetails"));
			hsr.getSession().setAttribute("cartValue", finalCart.get("cartValue"));
			modelAndView.setViewName("mycartTest2");
		} catch (Exception e) {
			log.error("Unexpected error occured : " + e);
		}

		return modelAndView;
	}

	public static List<Object> getCartDetails(HttpSession session) {
		return (List<Object>) session.getAttribute("cartDetails");
	}

}
