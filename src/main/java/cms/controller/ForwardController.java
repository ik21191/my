package cms.controller;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ForwardController extends AbstractController
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("Back End Application Test Response");
        String result=null;
        String arr[]=request.getRequestURI().split("/");
        String str=arr[arr.length-1];
        log.info(str);
        if(str.equalsIgnoreCase("crmmenuapp.asp"))
        	result="crmmenu";
        else if(str.equalsIgnoreCase("productApp-app.asp"))
        	result="productApp";
        else if(str.equalsIgnoreCase("bulkupload-app.asp"))
        	result="bulkupload";
        else if(str.equalsIgnoreCase("categoryApp-app.asp"))
        	result="categoryApp";
        else if(str.equalsIgnoreCase("productCategoryRelation-app.asp"))
        	result="productCategoryRelation";
        else if(str.equalsIgnoreCase("search-app.asp"))
        	result="search";
        else if(str.equalsIgnoreCase("testapp.asp"))
        	result="crmmenu";
        return new ModelAndView(result);
    }
    
}
