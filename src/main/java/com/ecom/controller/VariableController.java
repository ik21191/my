package com.ecom.controller;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class VariableController extends AbstractController
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        log.info("############### Variable Controller");
        String val1=request.getParameter("data");
        if(val1.equalsIgnoreCase("citylist"))
        {
            List<Map> list=null;//QueryExecutor.getShippingInfo(Integer.parseInt(request.getParameter("shippingcity")));
            ListIterator itr=list.listIterator();
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            
            Map m;
            while(itr.hasNext())
            {
                m=new HashMap();
                out.println("<option>"+m.get("cityName")+"</option>");
                
            }
            
            
            //out.println("This response is displayed without creating jsp or velocity file.");
        }
        else
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("This response is displayed without creating jsp or velocity file.Else Block");
        }
        return null;
    }
    
}
