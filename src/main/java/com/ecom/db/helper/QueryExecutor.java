package com.ecom.db.helper;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.Ostermiller.util.CSVParser;
import com.Ostermiller.util.LabeledCSVParser;
@SuppressWarnings({"unchecked", "rawtypes"})
public class QueryExecutor
{
	private static  Logger log = Logger.getLogger("ecomLog");
    public static synchronized String dataInsert(HttpServletRequest req)
    {
        String application=req.getParameter("t1");
        String status="";
        if(application.equalsIgnoreCase("productApp"))
        {
            String a1=req.getParameter("name");
            String a2=req.getParameter("title");
            String a3=req.getParameter("sku");
            String a4=req.getParameter("status");
            String a5=req.getParameter("sdescription");
            String a6=req.getParameter("ldescription");
            double a7=Double.parseDouble(req.getParameter("wp"));
            double a8=Double.parseDouble(req.getParameter("pp"));
            double a9=Double.parseDouble(req.getParameter("mrp"));
            String a10=req.getParameter("metatitle");
            String a11=req.getParameter("metakeyword");
            String a12=req.getParameter("metadescription");
            String a13=req.getParameter("simage");
            String a14=req.getParameter("limage");
            String a15=req.getParameter("adl_string_1");
            String a16=req.getParameter("PRODUCTTYPE");
            String a17=req.getParameter("WEIGHT");
            String a18=req.getParameter("SHIPPINGTYPE");
            try
            {
                Connection con=ConnectionFactory.getConnection();
                String query="insert into BASE_PRODUCT(ITEM_NAME,SKU,SHORTDESCRIPTION,LONGDESCRIPTION,"
                    + "SELL_PRICE,PURCHASE_PRICE,MRP,META_TITLE,META_KEYWORD,META_DESCRIPTION,TITLE,STATUS,CREATEDDATE,ADL_STRING_1,"
                    + "PRODUCTTYPE,WEIGHT,SHIPPINGTYPE)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stm=con.prepareStatement
                (query.toLowerCase());
                stm.setString(1,a1);
                stm.setString(2,a3);
                stm.setString(3,a5);
                stm.setString(4,a6);
                stm.setDouble(5,a7);
                stm.setDouble(6,a8);
                stm.setDouble(7,a9);
                stm.setString(8,a10);
                stm.setString(9,a11);
                stm.setString(10,a12);
                stm.setString(11,a2);
                stm.setString(12,a4);
                stm.setString(13,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.setString(14,a15);
                stm.setString(15,a16);
                stm.setString(16,a17);
                stm.setString(17,a18);
                stm.executeUpdate();
                String query1="SELECT PRODUCT_ID FROM BASE_PRODUCT ORDER BY PRODUCT_ID DESC limit 1";
                stm=con.prepareStatement
                (query1.toLowerCase());
                ResultSet rset=stm.executeQuery();
                rset.next();
                int productId=rset.getInt(1);
                String query2="insert into base_productimage(PRODUCTID,SMALLIMAGE,LARGEIMAGE,CREATEDDATE)"
                    + "VALUES(?,?,?,?)";
                stm=con.prepareStatement(query2.toLowerCase());
                stm.setInt(1,productId);
                stm.setString(2,a13);
                stm.setString(3,a14);
                stm.setString(4,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
            }
            catch(Exception e)
            {
                log.info(e);
            }
        }
        else if(application.equalsIgnoreCase("categoryApp"))
        {
            String a1=req.getParameter("TITLE");
            int a2=Integer.parseInt(req.getParameter("PARENT_ID"));
            String a3=req.getParameter("STATUS");
            String a4=req.getParameter("DESCRIPTION");
            String a5=req.getParameter("META_TITLE");
            String a6=req.getParameter("META_KEYWORD");
            String a7=req.getParameter("META_DESCRIPTION");
            try
            {
                Connection con=ConnectionFactory.getConnection();
                String query3="INSERT INTO BASE_CATEGORY(PARENT_ID,TITLE,DESCRIPTION,META_TITLE,META_KEYWORD,META_DESCRIPTION,STATUS,CREATEDDATE) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement stm=con.prepareStatement
                (query3.toLowerCase());
                stm.setInt(1,a2);
                stm.setString(2,a1);
                stm.setString(3,a4);
                stm.setString(4,a5);
                stm.setString(5,a6);
                stm.setString(6,a7);
                stm.setString(7,a3);
                stm.setString(8,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
            }
            catch(Exception e)
            {
                log.error(e);
            }
        }
        else if(application.equalsIgnoreCase("pcRelation"))
        {
            int a1=Integer.parseInt(req.getParameter("CATEGORYID"));
            int a2=Integer.parseInt(req.getParameter("PRODUCTID"));
            String a3=req.getParameter("STATUS");
            int a4=Integer.parseInt(req.getParameter("SEQUENCE"));
            try
            {
                Connection con=ConnectionFactory.getConnection();
                String query="INSERT INTO BASE_PRODUCTCATEGORY(CATEGORYID,PRODUCTID,SEQUENCE,STATUS,CREATEDDATE) VALUES "
                    + "(?,?,?,?,?)";
                PreparedStatement stm=con.prepareStatement
                (query.toLowerCase());
                stm.setInt(1,a1);
                stm.setInt(2,a2);
                stm.setString(4,a3);
                stm.setInt(3,a4);
                stm.setString(5,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
            }
            catch(Exception e)
            {
                log.error(e);
            }
        }
        return "Product Successfully inserted.";
    }
    
    public static void getAllCities(ModelAndView view)
    {
        try
        {
            log.info("#######################  getCityInfo(int)");
            Connection con=ConnectionFactory.getConnection();
            String query="SELECT ID,NAME FROM BASE_CITY";
            PreparedStatement stm=con.prepareStatement
            (query.toLowerCase());
            ResultSet rset=stm.executeQuery();
            List<Map> cityList=new ArrayList<Map>();
            while(rset.next())
            {
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("cityId",rset.getInt(1)+"");
                map.put("cityName",rset.getString(2));
                cityList.add(map);
            }
        view.addObject("cityList",cityList);
        }catch(Exception e)
        {
            log.info(e);
        }
    }
    
   
    public static synchronized String productBulkUpload(File file)
    {  
        log.info("####################### productBulkUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into BASE_PRODUCT(ITEM_NAME,SKU,SHORTDESCRIPTION,LONGDESCRIPTION,SELL_PRICE,PURCHASE_PRICE,MRP,"
                +"META_TITLE,META_KEYWORD,META_DESCRIPTION,TITLE,STATUS,CREATEDDATE,ADL_STRING_1,PRODUCTTYPE,WEIGHT,SHIPPINGTYPE)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String ITEM_NAME = lcsvp.getValueByLabel("ITEM_NAME");
                String SKU = lcsvp.getValueByLabel("SKU");
                String SHORTDESCRIPTION = lcsvp.getValueByLabel("SHORTDESCRIPTION");
                String LONGDESCRIPTION = lcsvp.getValueByLabel("LONGDESCRIPTION");
                String SELL_PRICE = lcsvp.getValueByLabel("SELL_PRICE");
                String PURCHASE_PRICE = lcsvp.getValueByLabel("PURCHASE_PRICE");
                String MRP = lcsvp.getValueByLabel("MRP");
                String META_TITLE = lcsvp.getValueByLabel("META_TITLE");
                String META_KEYWORD = lcsvp.getValueByLabel("META_KEYWORD");
                String META_DESCRIPTION = lcsvp.getValueByLabel("META_DESCRIPTION");
                String TITLE = lcsvp.getValueByLabel("TITLE");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                String ISSELLABLE = lcsvp.getValueByLabel("ISSELLABLE");
                String PRODUCTTYPE = lcsvp.getValueByLabel("PRODUCTTYPE");
                String WEIGHT = lcsvp.getValueByLabel("WEIGHT");
                String SHIPPINGTYPE = lcsvp.getValueByLabel("SHIPPINGTYPE");
                
                
                stm.setString(1,ITEM_NAME);
                stm.setString(2,SKU);
                stm.setString(3,SHORTDESCRIPTION);
                stm.setString(4,LONGDESCRIPTION);
                stm.setString(5,SELL_PRICE);
                stm.setString(6,PURCHASE_PRICE);
                stm.setString(7,MRP);
                stm.setString(8,META_TITLE);
                stm.setString(9,META_KEYWORD);
                stm.setString(10,META_DESCRIPTION);
                stm.setString(11,TITLE);
                stm.setString(12,STATUS);
                stm.setString(13, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.setString(14,ISSELLABLE);
                stm.setString(15,PRODUCTTYPE);
                stm.setString(16,WEIGHT);
                stm.setString(17,SHIPPINGTYPE);
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total Products created : "+totalRecord);
        return result;
    }
    public static synchronized String productAddonUpload(File file)
    {  
        log.info("####################### productAddonUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into BASE_PRODUCTADDON_RELATION(PRODUCTID,ADDONID,SEQUENCE,STATUS,CREATEDDATE) "
                + " VALUES(?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String PRODUCTID = lcsvp.getValueByLabel("PRODUCTID");
                String ADDONID = lcsvp.getValueByLabel("ADDONID");
                String SEQUENCE = lcsvp.getValueByLabel("SEQUENCE");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                
                stm.setString(1,PRODUCTID);
                stm.setString(2,ADDONID);
                stm.setString(3,SEQUENCE);
                stm.setString(4,STATUS);
                stm.setString(5, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total relation created : "+totalRecord);
        return result;
    }
    public static synchronized String countryUpload(File file)
    {  
        log.info("####################### countryUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into BASE_COUNTRY(NAME,STATUS,COUNTRYCODE,CREATEDDATE) VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String NAME = lcsvp.getValueByLabel("NAME");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                String COUNTRYCODE = lcsvp.getValueByLabel("COUNTRYCODE");
                
                
                stm.setString(1,NAME);
                stm.setString(2,STATUS);
                stm.setString(3,COUNTRYCODE);
                stm.setString(4, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total record created : "+totalRecord);
        return result;
    }
    public static synchronized String stateUpload(File file)
    {  
        log.info("####################### stateUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into BASE_STATE(NAME,STATUS,COUNTRYID,CREATEDDATE) VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String NAME = lcsvp.getValueByLabel("NAME");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                String COUNTRYID = lcsvp.getValueByLabel("COUNTRYID");
                
                
                stm.setString(1,NAME);
                stm.setString(2,STATUS);
                stm.setString(3,COUNTRYID);
                stm.setString(4, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total record created : "+totalRecord);
        return result;
    }
    public static synchronized String cityUpload(File file)
    {  
        log.info("####################### cityUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into BASE_CITY(NAME,STATUS,STATEID,CREATEDDATE) VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String NAME = lcsvp.getValueByLabel("NAME");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                String STATEID = lcsvp.getValueByLabel("STATEID");
                
                
                stm.setString(1,NAME);
                stm.setString(2,STATUS);
                stm.setString(3,STATEID);
                stm.setString(4, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total record created : "+totalRecord);
        return result;
    }
    public static synchronized String cityGroupUpload(File file)
    {  
        log.info("####################### cityGroupUpload(File)");
        int totalRecord=0;
        String result="Something went wrong !";
        try 
        {
            Connection con = ConnectionFactory.getConnection();
            String query="insert into base_citygroup_relation(CITYGROUPID,CITYID,STATUS,CREATEDDATE) VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement
            (query.toLowerCase());
            
            FileInputStream stream1=new FileInputStream(file);
            LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
            while(lcsvp.getLine() != null)
            {
                String CITYGROUPID = lcsvp.getValueByLabel("CITYGROUPID");
                String CITYID = lcsvp.getValueByLabel("CITYID");
                String STATUS = lcsvp.getValueByLabel("STATUS");
                
                
                stm.setString(1,CITYGROUPID);
                stm.setString(2,CITYID);
                stm.setString(3,STATUS);
                stm.setString(4, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
                stm.executeUpdate();
                totalRecord++;
            }stream1.close();
            result="Successfully uploaded !";
        }
        catch(Exception e)
        {
            log.info(e);
        }
        log.info("Total record created : "+totalRecord);
        return result;
    }
    
}