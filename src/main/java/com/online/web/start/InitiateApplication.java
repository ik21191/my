package com.online.web.start;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ecom.db.helper.DbConstants;

@SuppressWarnings("unchecked")
public class InitiateApplication implements ApplicationContextAware {
	private static  Logger log = Logger.getLogger("ecomLog");
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		log.info("Initialization started.................");
		Map<String, String> dbMap = (Map<String, String>)applicationContext.getBean("dbMap");
		DbConstants.DRIVER = dbMap.get("dbDriver");
		DbConstants.URL = dbMap.get("dbUrl");
		DbConstants.USERNAME = dbMap.get("dbUser");
		DbConstants.PASSWORD = dbMap.get("dbPassword");
		log.info("Initialization completed..............." + dbMap.get("appName"));
	}
}
