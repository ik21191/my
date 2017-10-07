package com.ecom.service;

import java.util.List;
import java.util.Map;

public interface ShippingService {

	Map<String,String> getCountryStateCityRelation(int cityId)throws Exception;
	List<Map<Object,Object>> getCitySpecificShippingInfo(int cityId) throws Exception;
}
