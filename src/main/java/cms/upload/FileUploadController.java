package cms.upload;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ecom.db.helper.QueryExecutor;

public class FileUploadController extends AbstractController {
	private static  Logger log = Logger.getLogger("ecomLog");

    private static String destinationDir="e:/uploadFiles/";
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,HttpServletResponse res) throws Exception 
    {
        log.info("###################################### FileUploadController");
        res.setContentType("text/html");
        if (!(req instanceof MultipartHttpServletRequest)) 
        {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expected multipart request");
            return null;
        }
        destinationDir="/var/lib/openshift/5554cf47fcf9333135000186/app-root/data/tempFile";
        log.info("location path is :"+destinationDir);
        File dir=new File(destinationDir);
        if(dir.isDirectory())
        {
            log.info("This is a directory and all the files are going to delete from it..........");
            File files[]=dir.listFiles();
            for(int i=0;i<files.length;i++)
            {
            	if(!files[i].getName().equalsIgnoreCase("tt.txt"))
                files[i].delete();
                log.info("file deleted.");
            }
        }
        else
        {
            log.info("It is file.");
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        MultipartFile file = multipartRequest.getFile("fileUploaded");
        File destination = new File(destinationDir +"/"+ file.getOriginalFilename());
        file.transferTo(destination);
        File file1=new File(destination.getAbsolutePath());
        String action=req.getParameter("action");
        log.info("###############  action is : "+action);
        if(action.equalsIgnoreCase("productBulkUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.productBulkUpload(file1);
        }
        else if(action.equalsIgnoreCase("productAddonUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.productAddonUpload(file1);
        }
        else if(action.equalsIgnoreCase("countryUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.countryUpload(file1);
        }
        else if(action.equalsIgnoreCase("stateUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.stateUpload(file1);
        }
        else if(action.equalsIgnoreCase("cityUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.cityUpload(file1);
        }
        else if(action.equalsIgnoreCase("cityGroupUpload"))
        {
            log.info("##################  action is : "+action);
            QueryExecutor.cityGroupUpload(file1);
        }
        log.info("Success, wrote to " + destination.getAbsolutePath());
        res.getWriter().write("Successfully uploaded.");
        res.flushBuffer();
        return null;
    }
}