package web.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtility 
{
	private static  Logger log = Logger.getLogger("ecomLog");
	public static String getCurrentDate()
	{
		String date=null;
		try
		{
			Date d=new Date();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date=df.format(d);
		}
		catch(Exception e)
		{
			log.info(e);
		}
		return date;
	}
	public static void main(String ar[])
	{
		log.info(getCurrentDate());
	}
}
