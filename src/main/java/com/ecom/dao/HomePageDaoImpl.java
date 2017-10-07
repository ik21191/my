package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ecom.db.helper.ConnectionFactory;
import com.ecom.utils.DbUtil;

public class HomePageDaoImpl implements HomePageDao {
	private Logger log = Logger.getLogger(HomePageDaoImpl.class);
	@Override
	public Map<String, List<Map<String, String>>> loadHomePageWidget() throws Exception {
		Map<String, List<Map<String, String>>> widgetMap = new HashMap<String, List<Map<String, String>>>();
        log.info("#######################  getCityInfo(int)");
        Connection con=ConnectionFactory.getConnection();
        String query=
        "SELECT s.title as widgetName,s.url as widgetUrl,sp.productid as productId,pro.item_name as productName," +
        "pro.sell_price as wp, image.smallimage FROM BASE_SPECIALCATEGORY s,BASE_SP_RELATION sp,BASE_PRODUCT pro," +
        "BASE_PRODUCTIMAGE image WHERE s.id=sp.specialcategoryid AND sp.productid=pro.product_id and " +
        "pro.product_id=image.productid and sp.status='Yes' order by s.sequence,sp.sequence";
        PreparedStatement stm=con.prepareStatement
        (query.toLowerCase());
            ResultSet rset=stm.executeQuery();
            List<Map<String, String>> list1=new ArrayList<Map<String, String>>();
            List<Map<String, String>> list2=new ArrayList<Map<String, String>>();
            List<Map<String, String>> list3=new ArrayList<Map<String, String>>();
            List<Map<String, String>> list4=new ArrayList<Map<String, String>>();
            List<Map<String, String>> list5=new ArrayList<Map<String, String>>();
            int i=1;
            while(rset.next())
            {
                if(i<=4){
                log.info(rset.getString(1));
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("widgetUrl",rset.getString(2)+"");
                map.put("productName",rset.getString(4));
                map.put("wp",rset.getInt(5)+"");
                map.put("smallImage","productImages/"+rset.getString(6));
                map.put("productURL",(rset.getString(4).replaceAll(" ","-")+"-"+rset.getInt(3)+"-p.htm").toLowerCase());
                list1.add(map);
                widgetMap.put("list1",list1);
            }
            if(i>=5 && i<=8){
                log.info(rset.getString(1));
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("widgetUrl",rset.getString(2)+"");
                map.put("productName",rset.getString(4));
                map.put("wp",rset.getInt(5)+"");
                map.put("smallImage","productImages/"+rset.getString(6));
                map.put("productURL",(rset.getString(4).replaceAll(" ","-")+"-"+rset.getInt(3)+"-p.htm").toLowerCase());
                list2.add(map);
                widgetMap.put("list2",list2);
            }
            if(i>=9 && i<=11){
                log.info(rset.getString(1));
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("widgetUrl",rset.getString(2)+"");
                map.put("productName",rset.getString(4));
                map.put("wp",rset.getInt(5)+"");
                map.put("smallImage","productImages/"+rset.getString(6));
                map.put("productURL",(rset.getString(4).replaceAll(" ","-")+"-"+rset.getInt(3)+"-p.htm").toLowerCase());
                list3.add(map);
                widgetMap.put("list3",list3);
            }
            if(i>=12 && i<=15){
                log.info(rset.getString(1));
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("widgetUrl",rset.getString(2)+"");
                map.put("productName",rset.getString(4));
                map.put("wp",rset.getInt(5)+"");
                map.put("smallImage","productImages/"+rset.getString(6));
                map.put("productURL",(rset.getString(4).replaceAll(" ","-")+"-"+rset.getInt(3)+"-p.htm").toLowerCase());
                list4.add(map);
                widgetMap.put("list4",list4);
            }
            if(i>=16 && i<=19){
                log.info(rset.getString(1));
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("widgetUrl",rset.getString(2)+"");
                map.put("productName",rset.getString(4));
                map.put("wp",rset.getInt(5)+"");
                map.put("smallImage","productImages/"+rset.getString(6));
                map.put("productURL",(rset.getString(4).replaceAll(" ","-")+"-"+rset.getInt(3)+"-p.htm").toLowerCase());
                list5.add(map);
                widgetMap.put("list5",list5);
            }
                i++;
            }
            DbUtil.close(con);
            DbUtil.close(stm);
            DbUtil.close(rset);
            
       return widgetMap;
	}
	
	@Override
	public List<Map<String, Object>> homeSearch(String searchParameter) throws Exception {
		log.info("################## homeSeach(String) ");
		List<Map<String, Object>> searchResultList = new ArrayList<Map<String, Object>>();
		Connection con = ConnectionFactory.getConnection();
		String query = "select p.PRODUCT_ID,p.ITEM_NAME,p.SKU,p.SELL_PRICE,image.smallimage "
				+ " from "
				+ " BASE_PRODUCT p,BASE_PRODUCTIMAGE image where p.product_id=image.productid and p.adl_string_1='Yes' and "
				+ "(p.ITEM_NAME LIKE ? or p.SKU LIKE ?)";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setString(1, "%" + searchParameter + "%");
		stm.setString(2, "%" + searchParameter + "%");
		ResultSet rset = stm.executeQuery();
		while (rset.next()) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			log.info(rset.getString(2));
			resultMap.put("productId", rset.getInt(1));
			resultMap.put("productName", rset.getString(2));
			resultMap.put("productSku", rset.getString(3));
			resultMap.put("productPrice", rset.getDouble(4));
			resultMap.put("productURL", (rset.getString(2).replaceAll(" ", "-") + "-"	+ rset.getInt(1) + "-p.htm").toLowerCase());
			resultMap.put("productSmallImage", "productImages/" + rset.getString(5));
			searchResultList.add(resultMap);
		}
		return searchResultList;
	}
}
