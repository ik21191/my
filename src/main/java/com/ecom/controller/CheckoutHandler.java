package com.ecom.controller;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@SuppressWarnings({"rawtypes"})
public class CheckoutHandler implements Controller
{
	private static  Logger log = Logger.getLogger("ecomLog");
        @Override
        public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
            HttpSession session=getSession(hsr);
            log.info("List of name/value parameter start");    
            Enumeration e=hsr.getParameterNames();
            String name,value;
            String addn="";
            while(e.hasMoreElements())
            {
                name=(String)e.nextElement();
                value=hsr.getParameter(name);
                log.info("name : "+name+" Value : "+value);
            }
            log.info("List of name/value parameter end");
            log.info("Getting product detail");
            //List list=QueryExecutor.productDetailCart(hsr.getParameter("productid"));
            log.info("Got product detail");
            String addons[]=hsr.getParameterValues("addonsid");
            Map<String,List<Map<String,String>>> cartDetails=new HashMap<String,List<Map<String,String>>>();
            List addonList=null;
            if(addons!=null)
            {
                for(int i=0;i<addons.length;i++)
                {
                    addn=addn+addons[i]+",";
                    log.info(addons[i]);
                }
                int len=addn.length();
                addn=addn.substring(0,(len-1));
                //addonList=QueryExecutor.getAddonRelation(null,null,null);
                //cartDetails.put("addonList",addonList);
            }
            log.info("Addons are : "+addn);
            ModelAndView modelAndView=new ModelAndView();
            String sessionValue=session.getId().toString();
            //cartDetails.put("parentProduct",list);
            //session.setAttribute("cartDetails",cartDetails);
            log.info("Displaying addon list: "+addonList);
            modelAndView.setViewName("checkout");
            return modelAndView;
}
        public static HttpSession getSession(HttpServletRequest req)
        {
            HttpSession session=req.getSession();
            return session;
        }
}
