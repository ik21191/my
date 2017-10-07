package com.ecom.service;

import java.util.List;
import java.util.Map;

public interface HomePageService {

	Map<String, List<Map<String, String>>> loadHomePageWidget() throws Exception;
	List<Map<String, Object>> homeSearch(String searchParameter) throws Exception;
}
