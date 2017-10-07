package web.cms;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
public class SearchController extends AbstractController
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        log.info("############### Insert Controller");
        response.setContentType("text/html");
        //List<String> list=QueryExecutor.search(request);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("searchResult");
        //modelAndView.addObject("list",list);
        return modelAndView;
    }
    
}
