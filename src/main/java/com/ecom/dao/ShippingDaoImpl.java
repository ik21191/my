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

public class ShippingDaoImpl implements ShippingDao {
	private Logger log = Logger.getLogger(ShippingDaoImpl.class);
	
	@Override
	public Map<String, String> getCountryStateCityRelation(int cityId) throws Exception {
		log.info("#######################  getCityInfo(int)");
		String query = "SELECT city.id,city.name,state.id,state.name,country.id,country.name FROM BASE_CITY city,BASE_STATE state,"
				+ "BASE_COUNTRY country where city.stateid=state.id and state.countryid=country.id and city.id=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, cityId);
		ResultSet rset = stm.executeQuery();
		Map<String, String> ship = new HashMap<String, String>();
		if (rset.next()) {
			ship.put("cityId", rset.getString(1));
			ship.put("cityName", rset.getString(2));
			ship.put("stateId", rset.getString(3));
			ship.put("stateName", rset.getString(4));
			ship.put("countryId", rset.getString(5));
			ship.put("countryName", rset.getString(6));
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return ship;
	}

	@Override
	public List<Map<Object, Object>> getCitySpecificShippingInfo(int cityId) throws Exception {
		log.info("#######################  getShippingInfo(int)");
		Connection con = ConnectionFactory.getConnection();
		String query = "select rel.citygroupid,rel.cityid,sm.title,sm.leaddays,sm.leadtime,sm.shippingwp,sm.id as shippingId from base_citygroup_relation rel,"
				+ "base_shippinggroup sg,shippingmode sm where sg.citygroupid=rel.citygroupid and sg.shippingmodeid=sm.id and "
				+ "sm.status='Y' and rel.cityid=? group by sm.title";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setInt(1, cityId);
		ResultSet rset = stm.executeQuery();
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		while (rset.next()) {
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("shippingTitle", rset.getString(3));
			map.put("shippingLeadDays", rset.getInt(4));
			map.put("shippingWp", rset.getDouble(6));
			map.put("shippingId", rset.getInt("shippingId"));
			log.info(rset.getString(3));
			list.add(map);
		}
		DbUtil.close(con);
		DbUtil.close(stm);
		DbUtil.close(rset);
		return list;
	}
}
