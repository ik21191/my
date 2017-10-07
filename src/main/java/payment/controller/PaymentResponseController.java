package payment.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class PaymentResponseController implements Controller
{
	private static  Logger log = Logger.getLogger("ecomLog");
	@Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception 
    {
		log.info("PaymentResponseController............");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("pr");
        return modelAndView;
    }
}
