package com.ecom.controller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


@SuppressWarnings({"unchecked"})
public class TestController extends AbstractController
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("This response is displayed without creating jsp or velocity file.");
        ModelAndView v=new ModelAndView("test");
        //return null;
        List<Object> list=new ArrayList<Object>();
        list.add("Imran Khan");
        list.add(new Integer(101));
        v.addObject("list",list);
        List<String> list1=null;
        HttpSession s=request.getSession();
        list1=getList(s);
        if(list1==null)
        {
        	log.info("Creating list1");
        	list1=new ArrayList<String>();
        }
        list1.add("Imran");
        try
		{
			/*Class.forName(DB_Constants.DRIVER);
			Connection con=DriverManager.getConnection
			(DB_Constants.URL,DB_Constants.USERNAME,DB_Constants.PASSWORD);
			Statement stm=con.createStatement();
			ResultSet rset=stm.executeQuery("select count(*) from test1");
			String db="Database not Connected";
			if(rset.next())
			db="Connected to DB";
			v.addObject("list",db);*/
		}
		catch(Exception e)
		{
			log.info(e);
		}
        s.setAttribute("list1", list1);
        log.info(list1);
        return v;
    }
    public List<String> getList(HttpSession s)
    {
    	return (List<String>)s.getAttribute("list1");
    }
    
}
