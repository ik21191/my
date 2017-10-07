package com.ecom.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller
{
       public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse h) throws Exception 
       {
           String myMessage="Hello Imran Khan.";
           ModelAndView modelAndView=new ModelAndView("display");
           modelAndView.addObject("message",myMessage);
           return modelAndView;
       }

    
    
}
