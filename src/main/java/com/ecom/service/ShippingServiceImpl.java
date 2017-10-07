package com.ecom.service;

import java.util.List;
import java.util.Map;

import com.ecom.dao.ShippingDao;
import com.ecom.dao.ShippingDaoImpl;

public class ShippingServiceImpl implements ShippingService {

	@Override
	public Map<String, String> getCountryStateCityRelation(int cityId) throws Exception {
		ShippingDao shippingDao = new ShippingDaoImpl();
		return shippingDao.getCountryStateCityRelation(cityId);
	}

	@Override
	public List<Map<Object, Object>> getCitySpecificShippingInfo(int cityId) throws Exception {
		ShippingDao shippingDao = new ShippingDaoImpl();
		return shippingDao.getCitySpecificShippingInfo(cityId);
	}
}
