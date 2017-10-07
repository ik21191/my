package web.cms;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ecom.db.helper.QueryExecutor;

public class InsertController extends AbstractController
{
	private static  Logger log = Logger.getLogger("ecomLog");
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        log.info("############### Insert Controller");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String value=QueryExecutor.dataInsert(request);
        out.println(value);
        return null;
    }
    
}
