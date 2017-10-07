package com.ecom.controller;

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
import com.ecom.service.RemoveCartItemService;
import com.ecom.service.RemoveCartItemServiceImpl;

@SuppressWarnings({ "unchecked" })
public class RemoveCartItemController implements Controller {
	private static Logger log = Logger.getLogger("ecomLog");

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse hsr1) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			RemoveCartItemService removeCartItemService = new RemoveCartItemServiceImpl();
			CartService cartService = new CartServiceImpl();
			log.info("RemoveCartController..............");
			String parentProduct = request.getParameter("product");
			String addonProduct = request.getParameter("addon");
			if (parentProduct != null) {
				long parentProductId = Long.parseLong(parentProduct);
				removeCartItemService.removeParentProductFromCart(parentProductId, request.getSession().getId());
			}
			if (addonProduct != null) {
				long addonProductId = Long.parseLong(addonProduct);
				removeCartItemService.removeAddonProductFromCart(addonProductId, request.getSession().getId());
			}
			List<Object> cartDetails = getCartDetailsFromSession(request.getSession());
			Map<String, Object> finalCart = cartService.getCartDetails(cartDetails);
			request.getSession().setAttribute("cartDetails", finalCart.get("cartDetails"));
			request.getSession().setAttribute("cartValue", finalCart.get("cartValue"));
			log.info((Double) request.getSession().getAttribute("cartValue"));
			modelAndView.setViewName("mycartTest2");
		} catch (Exception e) {
			log.error("Unexpected error occured " + e);
		}
		return modelAndView;
	}

	public static List<Object> getCartDetailsFromSession(HttpSession session) {
		return (List<Object>) session.getAttribute("cartDetails");
	}

}
