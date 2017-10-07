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

@SuppressWarnings({"unchecked"})
public class ReviewCartController implements Controller
{
	private static  Logger log = Logger.getLogger("ecomLog");
        @Override
        public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse hsr1) throws Exception 
        {
        	CartService cartService = new CartServiceImpl();
            log.info("##############     ReviewCartController");
            HttpSession session=getSession(req);
            /*Name/Value parameter code start*/
            List<Object> cartDetails=(List<Object>)session.getAttribute("cartDetails");
            Iterator<Object> itr=cartDetails.iterator();
            while(itr.hasNext())
            {
            	Map<Object,Object> m=(Map<Object,Object>)itr.next();
            	Long subOrderId=(Long)m.get("subOrderId");
            	log.info("subOrderId is : "+subOrderId);
            	String rec_name=req.getParameter("rec_name-"+subOrderId);
            	String rec_add=req.getParameter("rec_add-"+subOrderId);
            	String rec_pin=req.getParameter("rec_pin-"+subOrderId);
            	String rec_mob=req.getParameter("rec_mob-"+subOrderId);
            	String status=cartService.updateShipping(rec_name,rec_add,rec_pin,rec_mob,subOrderId);
            	log.info(status);
            }
            String sessionid=session.getId();
            int orderId=cartService.getOrder(session.getId());
            String status=cartService.updateCartOrder(orderId, sessionid);
            log.info("Status of order update : "+status);
            ModelAndView modelAndView=new ModelAndView();
            Map<String,Object> finalCart=cartService.getCartDetails(cartDetails);
            req.getSession().setAttribute("cartDetails",finalCart.get("cartDetails"));
            req.getSession().setAttribute("cartValue",finalCart.get("cartValue"));
            modelAndView.addObject("business", "ik21191@gmail.com");
            modelAndView.addObject("password", "Ik78613524");
            modelAndView.setViewName("payment");
            return modelAndView;
}
        public static HttpSession getSession(HttpServletRequest req)
        {
            HttpSession session=req.getSession();
            return session;
        }
}
