package com.ecom.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecom.dao.HomePageDao;
import com.ecom.dao.HomePageDaoImpl;
@Service("HomePageService")
public class HomePageServiceImpl implements HomePageService {
	@Override
	public Map<String, List<Map<String, String>>> loadHomePageWidget() throws Exception {
		HomePageDao homePageDao = new HomePageDaoImpl();
		return homePageDao.loadHomePageWidget() ;
	}
	@Override
	public List<Map<String, Object>> homeSearch(String searchParameter) throws Exception {
		HomePageDao homePageDao = new HomePageDaoImpl();
		return homePageDao.homeSearch(searchParameter);
	}
}
