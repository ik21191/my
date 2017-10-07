package com.ecom.controller;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@SuppressWarnings({"rawtypes"})
public class PurchaseController implements Controller
{
	private static  Logger log = Logger.getLogger("ecomLog");
        @Override
        public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
            log.info("##############     PurchaseController");
            HttpSession session=getSession(hsr);
            /*Name/Value parameter code start*/
            Enumeration e=hsr.getParameterNames();
            String pname="";
            while(e.hasMoreElements())
            {
                pname=(String)e.nextElement();
                log.info(pname+"     "+hsr.getParameter(pname));
            }
            /*Name/Value parameter code end*/
            
            
            /*     Product and Addnos Information Start Here*/
            log.info("Getting product info");
            List list=(List)session.getAttribute("list");
            ListIterator itr=list.listIterator();
            Map map=new HashMap();
            while(itr.hasNext())
            {
                map=(Map)itr.next();
                log.info(map.get("productId"));
            }
            log.info("product info got.");
            log.info("Getting addon info");
            list=(List)session.getAttribute("addonList");
            itr=list.listIterator();
            map=new HashMap();
            while(itr.hasNext())
            {
                map=(Map)itr.next();
                log.info(map.get("addonId"));
            }
            log.info("addon info got.");
            /*     Product and Addnos Information End Here*/
            /* Getting shipping information start */
            
            String shipname=hsr.getParameter("shipname");
            String shippincode=hsr.getParameter("shippincode");
            String shipaddress=hsr.getParameter("shipaddress");
            String shipcountry=hsr.getParameter("shipcountry");
            String shipstate=hsr.getParameter("shipstate");
            String shipcity=hsr.getParameter("shipcity");
            String shipmobile=hsr.getParameter("shipmobile");
            
            /* Getting shipping information end */
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("thankyou");
            return modelAndView;
}
        public static HttpSession getSession(HttpServletRequest req)
        {
            HttpSession session=req.getSession();
            return session;
        }
}
