package cms.test;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class BackEndTestController extends AbstractController
{
    @Override
    protected ModelAndView handleRequestInternal
    (HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("Back End Application Test Response");
        //ModelAndView v=new ModelAndView("test");
        return null;
    }
    
}
